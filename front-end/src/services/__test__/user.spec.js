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
  it('should be able to get his assets', function(done) {
    user.assets({
      name: 'Sam',
      token: 'xxxx'
    }).then(function(assets) {
      assets.should.be.an.Object
      assets.data.should.be.an.Array
      assets.data.length.should.be.above(1)
      assets.data[0].name.should.be.equal('Mac Book')
      assets.data[0].type.should.be.equal('laptop')
      done()
    })
    .catch(function(err) {
      done(err)
    })
  })
})
