import React from 'react'

import {
  RaisedButton,
  }from 'material-ui'

var AssetItem = React.createClass({

  getInitialState(){
    return {
      clickCount: 1
    }
  },
  handleClick(){
    this.setState({
      clickCount: this.state.clickCount + 1
    });
    alert("You have clicked " + this.props.asset.asset_name + " " + this.state.clickCount + " times!")
  },
  showDetails(){
    alert(this.props.asset.asset_name + "'s Details.")
  },
  render() {
    var styleObj = {
      width: "145px"
    };
    return (
      <div>
        <td className="asset__name">
          <RaisedButton style={styleObj}
                        label={this.props.asset.asset_name}
                        primary={true}
                        onClick={this.showDetails}/>
        </td>
        <td className="asset__attribute">{this.props.asset.date}</td>
        <td className="asset__attribute">{this.props.asset.number}</td>
        <td className="asset__attribute">{this.props.asset.type}</td>
        <td className="asset__attribute">
          <RaisedButton label="Button"
                        secondary={true}
                        onClick={this.handleClick}>
          </RaisedButton>
        </td>
      </div>
    )
  }
});

export default AssetItem