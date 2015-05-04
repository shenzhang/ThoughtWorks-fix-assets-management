import React from 'react'

import {
  Paper
  } from 'material-ui'

var Footer = React.createClass({
  render() {
    return (
      <Paper zDepth={1}>
        <center className="footer">I am Footer!</center>
      </Paper>
    );
  }
});

module.exports = Footer;
