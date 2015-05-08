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

var Home = React.createClass({

  mixins: [Navigation, State],

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
    this.context.router.transitionTo('login');
  }
});

export default Home
