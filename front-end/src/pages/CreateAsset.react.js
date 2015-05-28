import React from 'react'

import {
  DropDownMenu,
  TextField,
  RaisedButton,
  FontIcon
  } from 'material-ui';

import {
  Navigation,
  State
  } from 'react-router';
import userApi from './../services/user'

var menuItems = [
  {payload: '1', text: 'Apple Laptop'},
  {payload: '2', text: 'DELL Laptop'},
  {payload: '3', text: 'Services'},
  {payload: '4', text: 'Desktop'},
  {payload: '5', text: 'MAC Mini'},
  {payload: '6', text: 'Monitor'},
  {payload: '7', text: 'Switch'},
  {payload: '8', text: 'Telephone'},
  {payload: '9', text: 'Firewall'},
  {payload: '10', text: 'SSD'},
  {payload: '11', text: 'Mobile Device'},
  {payload: '12', text: 'Signed 3G/4G Network Card'},
];


var CreateAsset = React.createClass({

  mixins: [State, Navigation],

  getInitialState(){
    return {
      disabled: true,
      serialNumberError: '',
      selectedIndex: 0,
      selectedType: 'Apple Laptop'
    }
  },
  _createAsset(){
    //console.log(this.state.selectedType)

    this.setState({
      serialNumberError: '',
      selectedIndex: 0
    });
    userApi.createAsset({
      type: this.state.selectedType,
      serialName: this.refs.serialName.getValue()
    }).then(this._onCreate, this._onCreateFailure)

  },
  _onCreate(msg) {
    if (msg.isNewSerialNumber) {
      this.context.router.transitionTo('newAsset');
    } else {
      this.setState({
        serialNumberError: msg
      })
    }
  },
  _onCreateFailure(err) {
    this.setState({
      serialNumberError: err
    });
  },
  _cancelCreateAsset(){
    this.refs.assetType.state.selectedIndex = 0;
    this.setState({
      disabled: true,
      serialNumberError: '',
      selectedIndex: 0,
      selectedType: 'Apple Laptop'
    })
  },
  handleChange(event, selectedIndex, menuItem){
    this.setState({
      selectedIndex: selectedIndex,
      selectedType: menuItem.text
    });
  },
  render() {
    return (
      <div>
        <h2> Add asset</h2>

        <form>
          <span className="create__asset__props">Type</span>
          <span>
            <DropDownMenu menuItems={menuItems}
                          ref='assetType'
                          onChange={this.handleChange}/>*
          </span>
          <span className="create__asset__props">SerialName</span>
          <span>
            <TextField
              ref='serialName'
              onInput={this.onInputed}/>* {this.state.serialNumberError}</span>

          <br/>

        <span className="create__asset__button">
        <RaisedButton label='Add'
                      secondary={true}
                      onClick={this._createAsset}
                      disabled={this.state.disabled}>
        </RaisedButton>
        <RaisedButton label='Cancel'
                      type='reset'
                      primary={true}
                      onClick={this._cancelCreateAsset}>
        </RaisedButton>
        </span>
        </form>
      </div>
    )
  },
  onInputed() {
    this.setState({
      disabled: !(this.refs.serialName.getValue())
    });
  }
});

export default CreateAsset