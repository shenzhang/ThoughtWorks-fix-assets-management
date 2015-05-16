require('chai').should()

import React from 'react/addons'
import Assets from '../Assets.react.js'
import AssetsButton from '../button/AssetButton.react'
const TestUtils = React.addons.TestUtils

let assets
describe('Assets Page Component', function () {
  beforeEach(function () {
    assets = TestUtils.renderIntoDocument(<Assets />)
  });
  it.skip('should be able to initialized independently', function () {
    TestUtils.isCompositeComponent(Assets).should.not.be.equal(true)
  })

  t('should be able to initialized independently', function() {
    TestUtils.isCompositeComponent(assets).should.be.equal(true)
    TestUtils.isCompositeComponentWithType(leftNav, LeftNav)
  })

})