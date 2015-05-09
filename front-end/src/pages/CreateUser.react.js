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
            <TextField hintText='User Name' ref='password' defaultValue='P@ss123456' onChange={this.onInputed}/>
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
      username: this.refs.username.getValue(),
      password: this.refs.password.getValue()
    }).then(this.onLogin, this.onLoginFail)
  },
  onLogin(msg) {
    alert('success message: '+msg.message);
  },
  onLoginFail(err) {
    alert('failure message: '+err.message);
  }
});

export default CreateUser;