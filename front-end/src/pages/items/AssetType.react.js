import React from 'react'

var AssetType = React.createClass({

  render() {
    return (
      <td className="asset__attribute">{this.props.asset_type}</td>
    )
  }
});

export default AssetType