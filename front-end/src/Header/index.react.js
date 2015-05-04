import React from 'react'

import {
  FlatButton,
  } from 'material-ui'

var Header = React.createClass({
  render() {
    return (
      <center className="footer">
        <FlatButton label="I am Footer!"/>
      </center>
    );
  }
});

module.exports = Header;
