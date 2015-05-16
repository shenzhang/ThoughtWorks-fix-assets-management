require('chai').should()

import React from 'react/addons'
import mockRouter from '../../../utils/mock-react-router'
import Login from '../Login.react.js'

const TestUtils = React.addons.TestUtils

var mockedLogin = mockRouter(Login)
let login
describe('Login Page Component', function() {
    beforeEach(function() {
      login = TestUtils.renderIntoDocument(<mockedLogin />)
    });
    it('should be able to initialized independently', function() {
        TestUtils.isCompositeComponent(login).should.be.equal(true)
        //TestUtils.isCompositeComponentWithType(login, Login)
    });
    //it.skip('should be able to toggle itself', function() {
    //    leftNav.toggle.should.be.a.Function
    //    leftNav.refs.leftNav.state.open.should.be.equal(false)
    //    leftNav.toggle()
    //    leftNav.refs.leftNav.state.open.should.be.equal(true)
    //    leftNav.toggle()
    //    leftNav.refs.leftNav.state.open.should.be.equal(false)
    //})
    //it.skip('should be able to close itself by click its title', function() {
    //    var menuTitle = React.findDOMNode(TestUtils.findRenderedDOMComponentWithClass(leftNav, 'menu__title'))
    //    leftNav.toggle()
    //    leftNav.refs.leftNav.state.open.should.be.equal(true)
    //    TestUtils.Simulate.click(menuTitle)
    //    leftNav.refs.leftNav.state.open.should.be.equal(false)
    //})
})
