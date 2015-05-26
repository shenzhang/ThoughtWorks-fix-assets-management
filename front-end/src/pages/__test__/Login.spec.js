require('chai').should()

import React from 'react/addons'
import mockRouter from '../../../utils/mock-react-router'
import Login from '../Login.react.js'

const TestUtils = React.addons.TestUtils

let login
describe('Login Page Component', function() {
    beforeEach(function() {
      login = TestUtils.renderIntoDocument(<Login />)
    });
    it('should be able to initialized independently', function() {
        TestUtils.isCompositeComponent(login).should.be.equal(true)
        TestUtils.isCompositeComponentWithType(login, Login)
    });
    it('should be disable to click login when username or password is empty', function() {
        login.refs.username.setValue('');
        login.refs.password.setValue('');
        login.onInputed();
        login.state.disabled.should.be.true;
        login.refs.username.setValue('name');
        login.onInputed();
        login.state.disabled.should.be.true;
        login.refs.password.setValue('password');
        login.refs.username.setValue('');
        login.onInputed();
        login.state.disabled.should.be.true;
    });
    it('should be able to click login when username and password are inputed', function() {
        login.refs.username.setValue('user');
        login.refs.password.setValue('password');
        login.onInputed();
        login.state.disabled.should.be.false;
    });
})
