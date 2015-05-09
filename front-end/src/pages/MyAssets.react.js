import React from 'react'

import {
  FlatButton,
  RaisedButton,
  }from 'material-ui'

import AssetName from './items/AssetName.react.js'
import AssetDate from './items/AssetDate.react.js'
import AssetNumber from './items/AssetNumber.react.js'
import AssetType from './items/AssetType.react.js'
import AssetButton from './items/AssetButton.react.js'

module.exports = React.createClass({

  _create_table_head(){
    return (
      <tr className="asset__head">
        <th className="asset__head__attribute">AssetName</th>
        <th className="asset__head__attribute">Number</th>
        <th className="asset__head__attribute">Assigned Date</th>
        <th className="asset__head__attribute">Type</th>
      </tr>
    )
  },
  render() {
    return (
      <div>
        <table className="my_assets_tab__container">
          {this._create_table_head()}
          {this.props.assets.map(function (asset) {
            return (
              <tr className="asset__item">
                <AssetName asset_name={asset.asset_name}/>
                <AssetDate asset_date={asset.date}/>
                <AssetNumber asset_number={asset.number}/>
                <AssetType asset_type={asset.type}/>
                <AssetButton asset={asset}/>
              </tr>
            )
          })}
        </table>
      </div >
    )
  }

})