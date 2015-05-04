import React from 'react'

import {
  FlatButton,
  Paper
  } from 'material-ui'

var Footer = React.createClass({
  render() {
    return (
      <Paper zDepth={1}>
        <br/>
        <center className="footer">
          <FlatButton label="I am Footer!"/>
        </center>
        <br/>
      </Paper>
    );
  }
});

module.exports = Footer;
