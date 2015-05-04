import React from 'react'
import {
  RaisedButton,
  FontIcon,
  Paper
  } from 'material-ui'
import {
  State
  } from 'react-router'

import userApi from '../services/user'

var Assets = React.createClass({

  mixins: [State],

  getInitialState() {
    return {
      title: 'User Assets',
      assets: []
    }
  },
  componentDidMount() {
    this._getAssets()
  },
  render() {
    return (
      <Paper zDepth={1}>
        <Paper zDepth={1}>
          <table>
            <tr>
              <th>Name</th>
              <th>Number</th>
              <th>Assigned Date</th>
              <th>Type</th>
            </tr>
            {this._renderAssets()}
          </table>
        </Paper>
        <RaisedButton secondary={true} onClick={this._getAssets}>
          <FontIcon className="muidocs-icon-custom-github example-button-icon"/>
          <span className="mui-raised-button-label example-icon-button-label">Get Assets</span>
        </RaisedButton>
      </Paper>
    );
  },
  _getAssets(userData) {
    userApi.assets(userData)
      .then(this.onAssetsLoad, this.onAssetsLoadFailed)
  },
  onAssetsLoad(assets) {
    this.setState({
      assets: assets.data
    })
  },
  onAssetsLoadFailed(err) {
    //
  },
  _renderAssets() {
    return this.state.assets.map(function (asset) {
      return (
        <tr className="asset__item">
          <td className="asset__attribute">{asset.name}</td>
          <td className="asset__attribute">{asset.date}</td>
          <td className="asset__attribute">{asset.number}</td>
          <td className="asset__attribute">{asset.type}</td>
        </tr>
      )
    })
  }
});

export default Assets
