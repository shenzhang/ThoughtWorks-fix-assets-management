import gutil from 'gulp-util'
import fs from 'fs'
import _ from 'lodash'
import docgen from 'react-docgen'
import doctrine from 'doctrine'
import path from 'path'
import through from 'through2'

const PLUGIN_NAME = 'react-doc';

module.exports = function () {

  var result = {};

  return through.obj(docJson, endStream);

  function endStream(cb) {

    var jsonFile = new gutil.File({
      path: PLUGIN_NAME + '.json',
      contents: new Buffer(JSON.stringify(result, null, 2))
    });

    var requireListFile = new gutil.File({
      path: PLUGIN_NAME + '.jsx',
      contents: new Buffer(getRequireListFileContents(result))
    });

    this.push(jsonFile);
    this.push(requireListFile);

    cb();

  }

  function docJson(file, enc, cb) {

    try {

      let moduleInfo = docgen.parse(String(file.contents));

      if (moduleInfo) {
        result[getModuleName(file)] = _.merge(descriptionProcess(file.path, moduleInfo), getInfoByVinylFile(file))
      }

    } catch (err) {
      this.emit('error', new gutil.PluginError(PLUGIN_NAME, err));
    }

    return cb();

  }

};

function getInfoByVinylFile(vinylFile) {
  return {
    'name': path.basename(vinylFile.path).split('.')[0],
    'module': path.dirname(getModuleName(vinylFile))
  }
}

function getModuleName(vinylFile) {
  return vinylFile.path.replace(vinylFile.cwd + '/', '')
}

function descriptionProcess(filename, obj) {

  obj = obj || {};

  let descObj = descriptionExtract(obj.description);

  if (descObj) {

    descObj = {
      description: descObj.description,
      examples: pickExampleFromTags(descObj.tags, filename)
    };

    if (_.isObject(obj.props)) {
      _.forEach(_.keys(obj.props), (key)=> {
        obj.props[key] = descriptionProcess(filename, obj.props[key]);
      });
    }

    return _.merge({}, obj, descObj);

  }

  return obj;
}

function descriptionExtract(descriptionString) {
  if (!descriptionString) {
    return null;
  }
  return doctrine.parse(descriptionString, {
    unwrap: true,
    sloppy: true,
    tags: [
      'example',
      'exampleFile'
    ]
  })
}

function pickExampleFromTags(tags, filename) {
  return _.reduce(tags, (exampleList, tagItem)=> {
    return exampleList.concat(getExample(tagItem, filename))
  }, [])
}

function getExample(tagItem, filename) {

  filename = filename || process.cwd();

  let contents;
  let exampleFile = null;

  if (tagItem.title === 'exampleFile') {
    exampleFile = path.resolve(path.dirname(filename), _.trim(tagItem['description']));
    contents = String(fs.readFileSync(exampleFile, 'utf-8'));
  } else {
    contents = tagItem['description']
  }

  var requireList = _.map(contents.match(/require\((\S+)\)/gm) || [], (item)=> {
    let resolvedPathName;
    let pathName = String(item.replace(/require\(['"](\S+)['"]\)/gm, '$1'));

    if (_.startsWith(pathName, './') || _.startsWith(pathName, '../')) {
      resolvedPathName = path.resolve(path.dirname(exampleFile || filename), pathName);
    } else {
      resolvedPathName = pathName;
    }

    // todo support es6
    return {
      path: resolvedPathName,
      src: item,
      dest: 'require("' + resolvedPathName + '")'
    }

  });

  return {
    requireList: requireList,
    contents: _.reduce(requireList, (contents, requireItem) => {
      return contents.replace(requireItem.src, requireItem.dest)
    }, contents)
  };
}


function getRequireListFileContents(result) {


  var requireList = {};

  findExample(result);

  function findExample(obj) {
    _.forEach(_.keys(obj), (key)=> {
      if (_.isPlainObject(obj[key])) {
        findExample(obj[key])
      } else if (key === 'examples') {
        _.forEach(obj[key], (exampleItem)=> {
          _.forEach(exampleItem.requireList, (requireItem) => {
            requireList[requireItem.path] = requireItem;
          })
        })
      }
    })
  }

  return _(requireList)
    .values()
    .map((requireItem) => {
      return 'require("' + requireItem.path + '");';
    })
    .push('module.exports = require;')
    .join('\n');
}
