import React from 'react'

var AssetNumber = React.createClass({

  render() {
    return (
      <td className="asset__attribute">{this.props.asset_number}</td>

    )
  }
});

export default AssetNumber