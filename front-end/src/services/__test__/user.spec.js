require('chai').should()

import user from '../user'
import config from './superagent-mock-config'

// get request and mock it by config
var request = user._request
require('../../../utils/superagent-mock')(request, config);

describe('User Services', function() {
  it('should be able to login', function(done) {
    user.login()
      .then(function(data) {
        data.should.be.equal('success')
        done()
      })
      .catch(function(err) {
        done(err)
      })
  })
})
