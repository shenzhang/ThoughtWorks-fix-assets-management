import React from 'react'
import {
  RaisedButton,
  FontIcon,
  Paper
  } from 'material-ui'
import {
  Navigation,
  State
  } from 'react-router'

import userApi from '../services/user'

var newAsset = React.createClass({

  mixins: [Navigation, State],

  //TODO: 前端实现两个页面之间的数据传递（现在只是返回mock值且与新建时不同）

  getInitialState(){
    return {
      assetType: 'Apple Laptop',
      assetSerialName: 12345678
    }
  },
  componentDidMount() {
    this._getNewAssets();
  },
  render() {
    return (
      <h1>newAsset: {this.state.assetType} | {this.state.assetSerialName}</h1>
    );
  },
  _getNewAssets(newAsset){
    userApi.getNewAsset(newAsset)
      .then(this.onAssetLoad, this.onAssetLoadFailed)
  },
  onAssetLoad(newAsset) {
    this.setState({
      assetType: newAsset.assetType,
      assetSerialName: newAsset.assetSerialName
    })
  },
  onAssetLoadFailed(err) {
    //
  }
});

export default newAsset
