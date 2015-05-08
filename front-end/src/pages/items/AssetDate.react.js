import React from 'react'

var AssetDate = React.createClass({

  render() {
    return (
      <td className="asset__attribute">{this.props.asset_date}</td>
    )
  }
});

export default AssetDate