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
    alert("You have clicked " + this.props.asset.asset_name + " " + this.state.clickCount + " times!")
    this.setState({
      clickCount: this.state.clickCount + 1
    });
  },
  showDetails(){
    alert(this.props.asset.asset_name + "'s Details.")
  },
  render() {
    var styleObj = {
      width: "145px"
    };
    return (
      //奇怪的是渲染之后这个td并没有包住下面的td，有danger error但是显示正确
      <div>
        <td className="asset__item">
          <RaisedButton style={styleObj}
                        label={this.props.asset.asset_name}
                        primary={true}
                        onClick={this.showDetails}/></td>

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