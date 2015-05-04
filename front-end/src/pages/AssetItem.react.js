import React from 'react'

import {
  RaisedButton,
  }from 'material-ui'

var AssetItem = React.createClass({

  getInitialState(){
    return {
      msg: "你点了我!",
      clickCount: 1
    }
  },
  handleClick(){
    this.setState({
        clickCount: this.state.clickCount + 1
    });
    alert("你点了我" + this.state.clickCount + "次!")
  },
  render() {
    return(
      <tr className="asset__item">
        <td className="asset__attribute" value="sb">{this.props.asset.name}</td>
        <td className="asset__attribute">{this.props.asset.date}</td>
        <td className="asset__attribute">{this.props.asset.number}</td>
        <td className="asset__attribute">{this.props.asset.type}</td>
        <td className="asset__attribute">
          <RaisedButton label="Button"
                        secondary={true}
                        onClick={this.handleClick}>
          </RaisedButton>
        </td>
      </tr>
    )
  }
});

export default AssetItem