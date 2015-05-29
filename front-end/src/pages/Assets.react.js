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

import $ from 'jquery'
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
  componentDidMount() {
    //this._getAssets();
    console.log("These are assets from back-end:")
    $.ajax({
      type: 'GET',
      url: "http://52.68.95.171:10000/users/allassets",
      dataType: 'json',
      success: function(data) {
        this.setState({assets: data});
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(this.url, status, err.toString());
      }.bind(this)
    });
    /*
    $.get("http://52.68.95.171:10000/users/allassets", function(result) {
      var assets = result
      console.log(assets)
      if (this.isMounted()) {
        this.setState({
          assets: assets
        });
      }
    }.bind(this));*/
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
