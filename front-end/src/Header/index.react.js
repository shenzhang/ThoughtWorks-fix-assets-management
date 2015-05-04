import React from 'react'

import {
  Paper
  } from 'material-ui'

var Header = React.createClass({
  render() {
    return (
      <Paper zDepth={1}>
        <center className="footer">I am Footer!</center>
      </Paper>
    );
  }
});

module.exports = Header;
