import React from 'react'

import {
  FlatButton,
  RaisedButton,
  }from 'material-ui'

import Link from 'react-router'

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
  handleClick(){
    window.location.href = "http://www.jimmylv.info"
  },
  _create_table_body()
  {
    var self = this;
    return (
      this.props.assets.map(function (asset) {
        return (
          <tr className="asset__item" onClick={self.handleClick}>
            <td className="asset__attribute">{asset.asset_name}</td>
            <td className="asset__attribute">{asset.date}</td>
            <td className="asset__attribute">{asset.number}</td>
            <td className="asset__attribute">{asset.type}</td>
            <AssetButton asset={asset}/>
          </tr>
        )
      })
    )
  }
  ,
  render()
  {
    return (
      <table className="my_assets_tab__container">
        <thead>
        {this._create_table_head()}
        </thead>
        <tbody>
        {this._create_table_body()}
        </tbody>
      </table>
    )
  }
})