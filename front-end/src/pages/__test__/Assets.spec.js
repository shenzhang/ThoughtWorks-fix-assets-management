require('chai').should()

import React from 'react/addons'
import Assets from '../Assets.react.js'
import {
  RaisedButton,
  }from 'material-ui'
import AssetButton from '../button/AssetButton.react';

const TestUtils = React.addons.TestUtils

let assets
let assetsData = [
  {
    owner_name: "JimmyLv",
    asset_name: 'Nokia',
    number: '17006011',
    date: '2015-4-25',
    type: 'Mobile'
  }
];
describe('Assets Page Component', function () {
  beforeEach(function () {
    assets = TestUtils.renderIntoDocument(<Assets />)
    assets.setState({
      assets: assetsData
    });
  });
  it('should be able to initialized independently', function () {
    TestUtils.isCompositeComponent(Assets).should.not.be.equal(true)
  })

  it('should be do sth when click asset button', function () {
    var AssetsComponent = TestUtils.scryRenderedComponentsWithType(assets, AssetButton)[0];
    var AssetRealTrigger = TestUtils.findRenderedDOMComponentWithClass(AssetsComponent, 'mui-raised-button-label').getDOMNode();

    TestUtils.Simulate.click(AssetRealTrigger);
    AssetsComponent.state.clickCount.should.be.equal(2);
  })

})