require('chai').should()

import user from '../user'

describe('User Services', function() {
  it('should be able to login', function(done) {
    user.login({
      username: 'admin',
      password: 'pw'
    })
    .then(function(data) {
      data.username.should.be.equal('admin')
      done()
    })
  })
  it('should not be able to login when password is incorrect', function(done) {
    user.login({
      username: 'admin',
      password: 'admin'
    }).then(null, function(err) {
      err.errorMessage.should.be.equal('Password is incorrect!')
      done()
    })
    .catch(done)
  })
  it.skip('should be able to get his assets', function(done) {
    user.assets({
      asset_name: 'Sam',
      token: 'xxxx'
    }).then(function(assets) {
      assets.should.be.an.Object
      assets.data.should.be.an.Array
      assets.data.length.should.be.above(1)
      assets.data[0].asset_name.should.be.equal('Mac Book')
      assets.data[0].type.should.be.equal('laptop')
      done()
    })
    .catch(function(err) {
      done(err)
    })
  })
})
