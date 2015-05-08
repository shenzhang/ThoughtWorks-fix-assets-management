import React from 'react'

import {
  RaisedButton,
  }from 'material-ui'

var OwnerName = React.createClass({

  render() {
    return (
      <td className="asset__attribute">
        <RaisedButton label={this.props.owner_name} primary={true}/>
      </td>
    )
  }
});

export default OwnerName