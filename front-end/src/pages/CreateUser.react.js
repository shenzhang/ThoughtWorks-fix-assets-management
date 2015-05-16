import React from 'react';
import {
  RaisedButton,
  Paper,
  TextField,
  FlatButton
  } from 'material-ui';
import {
  State
  } from 'react-router';
import userApi from './../services/user'

var CreateUser = React.createClass({
  mixins: [State],

  getInitialState() {
    return {
      disabled: true,
      user: ''
    };
  },

  render() {
    return (
      <Paper zDepth={1}>
        <div className='page-login'>
          <FlatButton className='title'></FlatButton>
          <div className='content'>
            <p>User name</p>
            <TextField hintText='User Name' ref='username' onChange={this.onInputed}/>
          </div>
          <div className='content'>
            <p>Password</p>
            <TextField hintText='User Name' ref='password' defaultValue='P@ss123456' onChange={this.onInputed} disabled/>
          </div>
          <RaisedButton className='button' label='Create User' primary={true} onClick={this._createUser} disabled={this.state.disabled}></RaisedButton>
        </div>
      </Paper>
    );
  },
  onInputed() {
    this.setState({disabled: !(this.refs.username.getValue())});
  },
  _createUser() {
    userApi.create({
      name: this.refs.username.getValue(),
      email:this.refs.username.getValue() + "@thoughtworks.com",
      password:this.refs.password.getValue()
    }).then(this.onCreate, this.onCreateFail)
  },
  onCreate(msg) {
    console.log('success message: '+msg.message);
  },
  onCreateFail(err) {
    console.log('failure message: '+err);
  }
});

export default CreateUser;