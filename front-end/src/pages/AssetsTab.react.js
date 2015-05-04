import React from 'react'

import {
  FlatButton,
  Tab,
  Tabs
  }from 'material-ui'

import AssetItem from './AssetItem.react.js'

var AssetsTab = React.createClass({

  _renderAssets() {
    return this.props.assets.map(function (asset) {
      return (
        <AssetItem asset = {asset}/>
      )
    })
  },
  render() {
    return (
      <Tabs>
        <Tab label="My Assets">
          <div className="tab-template-container">
            <table>
              <tr>
                <th><FlatButton label="Name"/></th>
                <th><FlatButton label="Number"/></th>
                <th><FlatButton label="Assigned Date"/></th>
                <th><FlatButton label="Type"/></th>
              </tr>
              {this._renderAssets()}
            </table>
          </div>
        </Tab>
        <Tab label="Others Assets">
          <div className="tab-template-container">
            <h2 className="mui-font-style-headline">There are others assets.</h2>
          </div>
        </Tab>
      </Tabs>
    )
  }

});

export default AssetsTab