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
    console.log(this.state.selectedType)

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
      this.context.router.transitionTo('home');
    } else {
      this.context.router.transitionTo('home');
    }
  },
  _onCreateFailure(err) {
    this.setState({
      serialNumberError: 'Name should be made up of 8 numbers.'
    });
  },
  _cancelCreateAsset(){
    return {}
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

        <div>
          <span className="create__asset__props">Type</span>
          <span><DropDownMenu menuItems={menuItems} onChange={this.handleChange}/>*</span>
          <span className="create__asset__props">SerialName</span>
          <span>
            <TextField
              ref='serialName'
              onInput={this.onInputed}/>*</span>
          <span>{this.state.serialNumberError}</span>


        </div>

        <span className="create__asset__button">
        <RaisedButton label='Add' secondary={true} onClick={this._createAsset} disabled={this.state.disabled}>
        </RaisedButton>
        <RaisedButton label='Cancel' primary={true} onClick={this._cancelCreateAsset}>
        </RaisedButton>
        </span>
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