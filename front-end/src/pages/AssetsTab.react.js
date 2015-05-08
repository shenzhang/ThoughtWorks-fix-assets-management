import React from 'react'

import {
  FlatButton,
  RaisedButton,
  Tab,
  Tabs
  }from 'material-ui'

import AssetItem from './AssetItem.react.js'

var AssetsTab = React.createClass({

  render() {
    return (
      <Tabs>
        <Tab label="My Assets">
          <div className="tab-template-container">
            <table>
              <tr>
                <th><FlatButton label="AssetName"/></th>
                <th><FlatButton label="Number"/></th>
                <th><FlatButton label="Assigned Date"/></th>
                <th><FlatButton label="Type"/></th>
              </tr>
              {this.props.assets.map(function (asset) {
                return (
                  <tr>
                    <AssetItem asset={asset}/>
                  </tr>
                )
              })}
            </table>
          </div>
        </Tab>
        <Tab label="Others Assets">
          <div className="tab-template-container">
            <table>
              <tr>
                <th><FlatButton label="OwnerName"/></th>
                <th><FlatButton label="AssetName"/></th>
                <th><FlatButton label="Number"/></th>
                <th><FlatButton label="Assigned Date"/></th>
                <th><FlatButton label="Type"/></th>
              </tr>
              {this.props.assets.map(function (asset) {
                return (
                  <tr>
                    <td>
                      <RaisedButton label={asset.owner_name} primary={true}/>
                    </td>
                    <AssetItem asset={asset}/>
                  </tr>
                )
              })}
            </table>
          </div>
        </Tab>
      </Tabs>
    )
  }

});

export default AssetsTab