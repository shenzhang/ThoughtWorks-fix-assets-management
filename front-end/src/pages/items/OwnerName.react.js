import React from 'react'

import {
  RaisedButton,
  }from 'material-ui'

var OwnerName = React.createClass({

  render() {
    return (
      //        <RaisedButton label={this.props.owner_name} primary={true}/>

      <td className="asset__attribute">{this.props.owner_name}</td>
    )
  }
});

export default OwnerName