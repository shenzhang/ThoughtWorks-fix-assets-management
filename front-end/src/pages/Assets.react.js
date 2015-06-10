import React from 'react'

import {
  RaisedButton,
  FontIcon,
  Paper,
  Tab,
  Tabs
  }from 'material-ui'

import {
  State
  } from 'react-router'

import userApi from '../services/user'
import AssetsTable from './AssetsTable.react.js'

var Assets = React.createClass({

  mixins: [State],

  getInitialState() {
    return {
      title: 'User Assets',
      assets: []
    }
  },
  handleSuccess(data) {
    this.setState({assets: data});
  },
  handleFailure(err) {
    console.log(err);
  },
  componentDidMount() {
    console.log("These are assets from back-end:");
    userApi.assets()
      .then(this.handleSuccess, this.handleFailure);
  },
  render() {
    return (
      <Paper zDepth={1}>
        <Tabs>
          <Tab label="My Assets">
            <AssetsTable assets={this.state.assets} hasOwner={false}/>
          </Tab>
          <Tab label="Others Assets">
            <AssetsTable assets={this.state.assets} hasOwner={true}/>
          </Tab>
        </Tabs>
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
      assets: assets
    })
  },
  onAssetsLoadFailed(err) {
    //
  }
});

export default Assets
