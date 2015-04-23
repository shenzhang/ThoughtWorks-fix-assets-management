import React from 'react'
import {
  RaisedButton,
  FontIcon,
  Paper
} from 'material-ui'
import {
  State
} from 'react-router'

var Home = React.createClass({

  mixins: [State],

  render() {
    return (
      <Paper zDepth={1}>
        <h2>Hello World!</h2>
        <RaisedButton linkButton={true} href="https://github.com/callemall/material-ui" secondary={true}>
          <FontIcon className="muidocs-icon-custom-github example-button-icon"/>
          <span className="mui-raised-button-label example-icon-button-label">Login</span>
        </RaisedButton>
      </Paper>
    );
  }
});

export default Home
