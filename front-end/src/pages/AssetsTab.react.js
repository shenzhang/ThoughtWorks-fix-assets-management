import React from 'react'

import {
  FlatButton,
  RaisedButton,
  Tab,
  Tabs
  }from 'material-ui'

import AssetName from './items/AssetName.react.js'
import AssetDate from './items/AssetDate.react.js'
import AssetNumber from './items/AssetNumber.react.js'
import AssetType from './items/AssetType.react.js'
import AssetItem from './AssetButton.react.js'

var AssetsTab = React.createClass({

  handleChange(){

  },
  render() {
    return (
      <Tabs onChange={this.handleChange}>
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
                    <AssetName asset_name={asset.asset_name}/>
                    <AssetDate asset_date={asset.date}/>
                    <AssetNumber asset_number={asset.number}/>
                    <AssetType asset_type={asset.type}/>
                    <AssetItem asset={asset}/>

                  </tr>
                )
              })}
            </table>
          </div>
        </Tab>
        <Tab label="Others Assets" >
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
                    <AssetName asset_name={asset.asset_name}/>
                    <AssetDate asset_date={asset.date}/>
                    <AssetNumber asset_number={asset.number}/>
                    <AssetType asset_type={asset.type}/>
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