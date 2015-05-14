require('chai').should()

import React from 'react/addons'
import Assets from '../Assets.react.js'
const TestUtils = React.addons.TestUtils

let assets
describe('Assets Page Component', function () {
  beforeEach(function () {
    assets = TestUtils.renderIntoDocument(<Assets />)
  });
  it('should be able to initialized independently', function () {
    TestUtils.isCompositeComponent(Assets).should.not.be.equal(true)
  })
})