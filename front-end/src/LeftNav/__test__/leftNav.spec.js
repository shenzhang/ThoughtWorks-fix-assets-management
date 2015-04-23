require('chai').should()

import React from 'react/addons'
import LeftNav from '../'
const TestUtils = React.addons.TestUtils

let leftNav
describe('Left Nav Component', function() {
  beforeEach(function() {
    leftNav = TestUtils.renderIntoDocument(<LeftNav />)
  })
  it('should be able to initialized independently', function() {
    TestUtils.isCompositeComponent(leftNav).should.be.equal(true)
    TestUtils.isCompositeComponentWithType(leftNav, LeftNav)
  })
  it('should be able to toggle itself', function() {
    leftNav.toggle.should.be.a.Function
    leftNav.refs.leftNav.state.open.should.be.equal(false)
    leftNav.toggle()
    leftNav.refs.leftNav.state.open.should.be.equal(true)
    leftNav.toggle()
    leftNav.refs.leftNav.state.open.should.be.equal(false)
  })
  it('should be able to close itself by click its title', function() {
    var menuTitle = React.findDOMNode(TestUtils.findRenderedDOMComponentWithClass(leftNav, 'menu__title'))
    leftNav.toggle()
    leftNav.refs.leftNav.state.open.should.be.equal(true)
    TestUtils.Simulate.click(menuTitle)
    leftNav.refs.leftNav.state.open.should.be.equal(false)
  })
})
