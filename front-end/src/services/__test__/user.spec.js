require('chai').should()

import user from '../user'

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
