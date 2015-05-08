import React from 'react'

import {
  FlatButton,
  RaisedButton,
  Tab,
  }from 'material-ui'

import AssetName from './items/AssetName.react.js'
import AssetDate from './items/AssetDate.react.js'
import AssetNumber from './items/AssetNumber.react.js'
import AssetType from './items/AssetType.react.js'
import AssetButton from './items/AssetButton.react.js'
import OwnerName from './items/OwnerName.react.js'


var OthersAssets = React.createClass({

  render() {
    return (
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
                <tr className="asset__item">
                  <OwnerName owner_name={asset.owner_name}/>
                  <AssetName asset_name={asset.asset_name}/>
                  <AssetDate asset_date={asset.date}/>
                  <AssetNumber asset_number={asset.number}/>
                  <AssetType asset_type={asset.type}/>
                  <AssetButton asset={asset}/>
                </tr>
              )
            })}
          </table>
        </div>
    )
  }
});

export default OthersAssets