import React from 'react'
import {
  FlatButton,
  RaisedButton,
  FontIcon,
  Paper,
  Tab,
  Tabs,
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
        <Tabs>
          <Tab label="My Assets">
            <div className="tab-template-container">
              <table>
                <tr>
                  <th><FlatButton label="Name" /></th>
                  <th><FlatButton label="Number" /></th>
                  <th><FlatButton label="Assigned Date" /></th>
                  <th><FlatButton label="Type" /></th>
                </tr>
                {this._renderAssets()}
              </table>
            </div>
          </Tab>
          <Tab label="Others Assets">
            <div className="tab-template-container">
              <h2 className="mui-font-style-headline">There are others assets.</h2>
            </div>
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
