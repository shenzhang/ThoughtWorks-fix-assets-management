import React from 'react'

import {
  RaisedButton,
  }from 'material-ui'

var AssetItem = React.createClass({
  render() {
    return(
      <tr className="asset__item">
        <td className="asset__attribute">{this.props.asset.name}</td>
        <td className="asset__attribute">{this.props.asset.date}</td>
        <td className="asset__attribute">{this.props.asset.number}</td>
        <td className="asset__attribute">{this.props.asset.type}</td>
        <td className="asset__attribute">
          <RaisedButton label="Button"
                        secondary={true}>
          </RaisedButton>
        </td>
      </tr>
    )
  }
});

export default AssetItem