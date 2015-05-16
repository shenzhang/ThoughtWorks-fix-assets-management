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
  handleClick(event){
    this.setState({
      clickCount: this.state.clickCount + 1
    });
    event.stopPropagation();
  },
  render() {
    return (
          <RaisedButton label="Button"
                        secondary={true}
                        onClick={this.handleClick}>
          </RaisedButton>
    )
  }
});

export default AssetButton