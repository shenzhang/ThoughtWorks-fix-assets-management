require('chai').should();

import user from '../user'

describe('User Services', function() {
  it('should be able to login', function(done) {
    user.login({
      name: 'ncmao',
      password: 'P@ss123456'
    })
    .then(function(data) {
      data.message.should.be.equal('Success!');
      done()
    })
  });
  it('should not be able to login when username is not exist', function(done) {
    user.login({
      name: 'tuber',
      password: 'tuber'
    }).then(null, function(err) {
      err.response.body.message.should.be.equal('The user is not exist.');
      done()
    })
    .catch(done)
  });
  it('should not be able to login when password is incorrect', function(done) {
    user.login({
      name: 'ncmao',
      password: 'pw'
    }).then(null, function(err) {
      err.response.body.message.should.be.equal('The password is not correct, please input again.');
      done()
    })
    .catch(done)
  });
  it('should be able to get his assets', function(done) {
    user.assets({
      assetName: 'Sam',
      token: 'xxxx'
    }).then(function(assets) {
      console.log(assets)
      assets.should.be.an.Object;
      assets.should.be.an.Array;
      assets.length.should.be.above(1);
      assets[0].assetName.should.be.equal('Nokia');
      assets[0].type.should.be.equal('Mobile');
      done()
    })
    .catch(function(err) {
      done(err)
    })
  });
  it('should be able to create a user', function (done) {
    user.create({
      username: 'jtao1'
    }).then(function (data) {
      data.message.should.be.equal("success");
      done();
    }).catch(function(err) {
      done(err);
    });
  });
});
