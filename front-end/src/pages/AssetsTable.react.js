import React from 'react'

import {
  FlatButton,
  RaisedButton,
  }from 'material-ui'

import AssetButton from './button/AssetButton.react.js'

var AssetsHeader = React.createClass({
  _create_owner_name_title(){
    if (this.props.hasOwner) {
      return (
        <th className="asset__head__attribute">OwnerName</th>
      )
    }
  },
  render() {
    return (
      <thead>
      <tr className="asset__head">
        {this._create_owner_name_title()}
        <th className="asset__head__attribute">AssetName</th>
        <th className="asset__head__attribute">Number</th>
        <th className="asset__head__attribute">Assigned Date</th>
        <th className="asset__head__attribute">Type</th>
      </tr>
      </thead>
    )
  }
});

var AssetsRow = React.createClass({
  _create_owner_name(ownerName){
    if (this.props.hasOwner) {
      return (
        <td className="asset__attribute">{ownerName}</td>
      )
    }
  },
  handleClick(){
    window.location.href = "about:blank"
  },
  render() {
    var asset = this.props.asset;
    return (
      <tr className="asset__item">
        {this._create_owner_name(asset.ownerName)}
        <td className="asset__attribute">{asset.assetName}</td>
        <td className="asset__attribute">
          <a className="asset__number"
             onClick={this.handleClick}
             title="about:blank">{asset.number}
          </a>
        </td>
        <td className="asset__attribute">{asset.assignDate}</td>
        <td className="asset__attribute">{asset.type}</td>
        <td className="asset__action"><AssetButton className="asset__button" asset={asset}/></td>
      </tr>
    )
  }
});

var AssetsTable = React.createClass({
  render(){
    var AssetsRows = this.props.assets.map((asset) => {
      return <AssetsRow asset={asset} hasOwner={this.props.hasOwner}/>
    });
    return (
      <table className="my_assets_tab__container">
        <AssetsHeader hasOwner={this.props.hasOwner}/>
        <tbody>
        {AssetsRows}
        </tbody>
      </table>
    )
  }
});

export default AssetsTable
