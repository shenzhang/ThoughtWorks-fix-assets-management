import React from 'react'


import {
  RaisedButton,
  }from 'material-ui'

var AssetButton = React.createClass({

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
  render() {
    return (
        <td className="asset__attribute">
          <RaisedButton label="Button"
                        secondary={true}
                        onClick={this.handleClick}>
          </RaisedButton>
        </td>
    )
  }
});

export default AssetButton