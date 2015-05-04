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
    alert("You have clicked " + this.props.asset.name + " "+this.state.clickCount + " times!")
  },
  showDetails(){
    alert(this.props.asset.name + "'s Details.")
  },
  render() {
    var styleObj = {
      width: "145px"
    };
    return (
      <tr className="asset__item">
        <td className="asset__name">
          <RaisedButton style={styleObj}
                        label={this.props.asset.name}
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
      </tr>
    )
  }
});

export default AssetItem