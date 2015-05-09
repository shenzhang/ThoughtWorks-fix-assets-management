import React from 'react'

import {
  FlatButton,
  RaisedButton,
  }from 'material-ui'

import AssetButton from './button/AssetButton.react.js'

module.exports = React.createClass({

  _create_owner_name_title(){
    if (this.props.hasOwner) {
      return (
        <th className="asset__head__attribute">OwnerName</th>
      )
    }
  },
  _create_owner_name(asset){
    if (this.props.hasOwner) {
      return (
        <td className="asset__attribute">{asset.ownerName}</td>
      )
    }
  },
  handleClick(){
    window.location.href = "about:blank"
  },
  render(){
    var self = this;
    return (
      <table className="my_assets_tab__container">
        <thead>
        <tr className="asset__head">
          {this._create_owner_name_title()}
          <th className="asset__head__attribute">AssetName</th>
          <th className="asset__head__attribute">Number</th>
          <th className="asset__head__attribute">Assigned Date</th>
          <th className="asset__head__attribute">Type</th>
        </tr>
        </thead>
        <tbody>
        {this.props.assets.map(function (asset, index) {
          return (
            <tr className="asset__item" onClick={self.handleClick} key={index}>
              {self._create_owner_name(asset)}
              <td className="asset__attribute">{asset.assetName}</td>
              <td className="asset__attribute">{asset.number}</td>
              <td className="asset__attribute">{asset.assignedDate}</td>
              <td className="asset__attribute">{asset.type}</td>
              <AssetButton asset={asset}/>
            </tr>
          )
        })}
        </tbody>
      </table>
    )
  }
})