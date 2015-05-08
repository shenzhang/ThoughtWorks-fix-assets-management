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

import MyAssets from './MyAssets.react.js'
import OthersAssets from './OthersAssets.react.js'

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
  handleClick(){
    this.setState({
      assets: []
    });
  },
  render() {
    return (
      //两个组件很相似，如何复用
      <Paper zDepth={1}>
        <Tabs>
          <Tab label="My Assets">
            <MyAssets assets={this.state.assets}/>
          </Tab>
          <Tab label="Others Assets">
            <OthersAssets assets={this.state.assets}/>
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
      assets: assets.data
    })
  },
  onAssetsLoadFailed(err) {
    //
  }
});

export default Assets
