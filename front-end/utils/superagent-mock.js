'use strict';

var qs = require('qs');

/**
 * Module exports.
 */
module.exports = mock;

/**
 * Installs the `mock` extension to superagent.
 */
function mock (superagent, config) {
  var Request = superagent.Request;
  var parsers = [];

  /**
   * Keep the default methods
   */
  var oldEnd = Request.prototype.end;

  // /**
  //  * Override get function
  //  */
  // superagent.get = function (url, data, fn) {
  //   var match = config.filter(function (parser) {
  //     return new RegExp(parser.pattern, 'g').test(url);
  //   })[0] || null;
  //
  //   if (match && !parsers[url] == match) {
  //     parsers[url] = match;
  //   }
  //
  //   var req;
  //   if (parsers[url]) {
  //     req = superagent('GET', url, data, fn);
  //   } else {
  //     req = oldGet.call(this, url, data, fn);
  //   }
  //   return req;
  // };

  /**
   * Override end function
   */
  Request.prototype.end = function (fn) {

    var path = this.url;
    var querystring = '';

    if (this._query) {
      querystring += this._query.join('&');
    } else {
      if (this.qs) {
        querystring += qs.stringify(this.qs);
      }
      if (this.qsRaw) {
        querystring += this.qsRaw.join('&');
      }
    }

    if (querystring.length) {
      path += (~path.indexOf('?') ? '&' : '?') + querystring;
    }

    var parser = parsers[this.url];

    if (parser) {
      var match = new RegExp(parser.pattern, 'g').exec(path);
      fn(null, parsers[this.url].callback(match, parser.fixtures()));
      oldEnd.call(this, fn);
    }
  };

  // generate HTTP verb methods

  require('methods').forEach(function(method){
    var name = 'delete' == method ? 'del' : method;

    method = method.toUpperCase();
    superagent[name] = function(url, data, fn){
      var match = config.filter(function (parser) {
        return new RegExp(parser.pattern, 'g').test(url);
      })[0] || null;
      var req;
      if (match && !(parsers[url] == match)) {
        parsers[url] = match;
        superagent['old' + name] = superagent[name]
      }

      if (parsers[url]) {
        req = superagent(method, url);
      } else {
        req = superagent['old' + name](url);
      }

      if ('function' == typeof data) fn = data, data = null;
      if (data) req.send(data);
      fn && req.end(fn);
      return req;
    };
  });


}
