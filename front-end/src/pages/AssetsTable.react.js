import React from 'react'

import {
  FlatButton,
  RaisedButton,
  }from 'material-ui'

import AssetButton from './items/AssetButton.react.js'

module.exports = React.createClass({

  _create_owner_name_title(){
    if (this.props.hasOwner) {
      return (
        <th className="asset__head__attribute">OwnerName</th>
      )
    }
  },
  _create_table_head(){
    return (
      <tr className="asset__head" >
        {this._create_owner_name_title()}
        <th className="asset__head__attribute">AssetName</th>
        <th className="asset__head__attribute">Number</th>
        <th className="asset__head__attribute">Assigned Date</th>
        <th className="asset__head__attribute">Type</th>
      </tr>
    )
  },
  _create_owner_name(asset){
    if (this.props.hasOwner) {
      return (
        <td className="asset__attribute">{asset.owner_name}</td>
      )
    }
  },
  handleClick(){
    window.location.href = "about:blank"
  },
  _create_table_body()
  {
    var self = this;
    return (
      this.props.assets.map(function (asset, index) {
        return (
          <tr className="asset__item" onClick={self.handleClick} key={index}>
            {self._create_owner_name(asset)}
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