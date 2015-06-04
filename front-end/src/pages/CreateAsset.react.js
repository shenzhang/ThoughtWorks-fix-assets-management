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

var ownerMenuItems = [
  {payload: '1', text: 'owner1'},
  {payload: '2', text: 'owner2'},
];
var modelMenuItems = [
  {payload: '1', text: 'model1'},
  {payload: '2', text: 'model2'},
];
var statusMenuItems = [
  {payload: '1', text: 'status1'},
  {payload: '2', text: 'status2'},
];
var locationMenuItems = [
  {payload: '1', text: 'location1'},
  {payload: '2', text: 'location2'},
];
var memoryMenuItems = [
  {payload: '1', text: 'memory1'},
  {payload: '2', text: 'memory2'},
];
var paymentLocationMenuItems = [
  {payload: '1', text: 'paymentLocation1'},
  {payload: '2', text: 'paymentLocation2'},
];
var vendorMenuItems = [
  {payload: '1', text: 'vendor1'},
  {payload: '2', text: 'vendor2'},
];
var encryptedMenuItems = [
  {payload: '1', text: 'encrypted1'},
  {payload: '2', text: 'encrypted2'},
];

var projectNameMenuItems = [
  {payload: '1', text: 'projectName1'},
  {payload: '2', text: 'projectName2'},
];

var HDDMenuItems = [
  {payload: '1', text: 'HDD1'},
  {payload: '2', text: 'HDD2'},
];

var serviceLevelMenuItems = [
  {payload: '1', text: 'serviceLevel1'},
  {payload: '2', text: 'serviceLevel2'},
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

          <span className="create__asset__props">Owner</span>
                    <span>
                      <DropDownMenu menuItems={ownerMenuItems}
                                    ref='assetOwner'
                                    onChange={this.handleChange}/>
                    </span>

          <span className="create__asset__props">Model</span>
                    <span>
                      <DropDownMenu menuItems={modelMenuItems}
                                    ref='assetModel'
                                    onChange={this.handleChange}/>
                    </span>

          <span className="create__asset__props">ContractID</span>
                    <span>
                      <TextField
                                ref='contractID'
                                />
                    </span>

           <br/>



          <span className="create__asset__props">Status</span>
                    <span>
                      <DropDownMenu menuItems={statusMenuItems}
                                    ref='assetStatus'
                                    onChange={this.handleChange}/>
                    </span>

          <span className="create__asset__props">SN</span>
                    <span>
                      <TextField
                                ref='SN'
                                />
                    </span>

          <span className="create__asset__props">PV_ID</span>
                    <span>
                      <TextField
                                ref='PV_ID'
                                />
                    </span>

           <br/>

          <span className="create__asset__props">Location</span>
                    <span>
                      <DropDownMenu menuItems={locationMenuItems}
                                    ref='assetLocation'
                                    onChange={this.handleChange}/>
                    </span>

          <span className="create__asset__props">AC_SN</span>
                    <span>
                      <TextField
                                ref='AC_SN'
                                />
                    </span>

          <span className="create__asset__props">Mac address</span>
                    <span>
                      <TextField
                                ref='Mac address'
                                />
                    </span>

           <br/>
          <span className="create__asset__props">Order Date</span>
          <span ><input type="date"/></span>
          <span className="create__asset__props">Memory</span>
                    <span>
                      <DropDownMenu menuItems={memoryMenuItems}
                                    ref='assetMemory'
                                    onChange={this.handleChange}/>
                    </span>
          <span className="create__asset__props">PaymentDate</span>
          <span ><input type="date"/></span>

           <br/>
          <span className="create__asset__props">Issue Date</span>
          <span ><input type="date"/></span>
          <span className="create__asset__props">Enc Key</span>
                    <span>
                      <TextField
                                ref='Enc Key'
                                />
                    </span>
          <span className="create__asset__props">PaymentLocation</span>
                    <span>
                      <DropDownMenu menuItems={paymentLocationMenuItems}
                                    ref='assetPaymentLocation'
                                    onChange={this.handleChange}/>
                    </span>
           <br/>

          <span className="create__asset__props">Vendor</span>
                    <span>
                      <DropDownMenu menuItems={vendorMenuItems}
                                    ref='assetVendor'
                                    onChange={this.handleChange}/>
                    </span>

          <span className="create__asset__props">SE/ACCP</span>
                    <span>
                      <TextField
                                ref='SE/ACCP'
                                />
                    </span>

          <span className="create__asset__props">AccountingPrice</span>
                    <span>
                      <TextField
                                ref='Mac address'
                                />
                    </span>


           <br/>

          <span className="create__asset__props">Price</span>
                    <span>
                      <TextField
                                ref='Price'
                                />
                    </span>
          <span className="create__asset__props">Encrypted</span>
                    <span>
                      <DropDownMenu menuItems={encryptedMenuItems}
                                    ref='assetEncrypted'
                                    onChange={this.handleChange}/>
                    </span>
          <span className="create__asset__props">ServiceDueDate</span>
          <span ><input type="date"/></span>

           <br/>
          <span className="create__asset__props">Project_name</span>
                    <span>
                      <DropDownMenu menuItems={projectNameMenuItems}
                                    ref='assetProject_name'
                                    onChange={this.handleChange}/>
                    </span>
          <span className="create__asset__props">HDD</span>
                    <span>
                      <DropDownMenu menuItems={encryptedMenuItems}
                                    ref='assetHDD'
                                    onChange={this.handleChange}/>
                    </span>
          <span className="create__asset__props">ServiceLevel</span>
                    <span>
                      <DropDownMenu menuItems={serviceLevelMenuItems}
                                    ref='assetServiceLevel'
                                    onChange={this.handleChange}/>
                    </span>
           <br/><br/>

        <span className="create__asset__button" >
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