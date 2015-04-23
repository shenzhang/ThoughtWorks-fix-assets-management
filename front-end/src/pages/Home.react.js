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

var Home = React.createClass({

  mixins: [State],

  getInitialState() {
    return {
      title: 'Hello World!'
    }
  },

  render() {
    return (
      <Paper zDepth={1}>
        <h2>{this.state.title}</h2>
        <RaisedButton secondary={true} onClick={this._login}>
          <FontIcon className="muidocs-icon-custom-github example-button-icon"/>
          <span className="mui-raised-button-label example-icon-button-label">Login</span>
        </RaisedButton>
      </Paper>
    );
  },

  _login() {
    userApi.login()
      .then(this.onLogin, this.onLoginFail)
  },
  onLogin(msg) {
    this.setState({title: msg})
  },
  onLoginFail(err) {
    this.setState({title: err.message})
  }
});

export default Home
