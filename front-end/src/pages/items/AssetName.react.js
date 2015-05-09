import React from 'react'

import {
  RaisedButton,
  }from 'material-ui'

var AssetName = React.createClass({

  showDetails(){
    alert(this.props.asset_name + "'s Details.")
  },
  render() {
    var styleObj = {
      width: "145px"
    };
    return (
      /*
       <RaisedButton style={styleObj}
       label={this.props.asset_name}
       primary={true}
       onClick={this.showDetails}/>
       */
      <td className="asset__attribute">{this.props.asset_name}</td>
    )
  }
});

export default AssetName