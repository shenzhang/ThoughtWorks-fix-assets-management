import React from 'react';
import {
    RaisedButton,
    Paper
    } from 'material-ui';
import State from 'react-router';
import userApi from './../services/user'

var Login = React.createClass({
    mixins: [State],

    getInitialState() {
        return {
            disabled: true
        };
    },

    render() {
        return (
            <Paper zDepth={1}>
                <p>Log in</p>
                <div>
                    <p>User name</p>
                    <input type='text' id='username' onInput={this.onInputed}/>
                </div>
                <div>
                    <p>Password</p>
                    <input type='password' id='password' onInput={this.onInputed}/>
                </div>
                <RaisedButton label='Log in' primary={true} onClick={this._login} disabled={this.state.disabled}></RaisedButton>
            </Paper>
        );
    },
    onInputed() {
        this.setState({disabled: !(document.getElementById('username').value && document.getElementById('password').value)});
    },
    _login() {
        userApi.login(this.state.user, this.state.password)
            .then(this.onLogin, this.onLoginFail)
    },
    onLogin(msg) {
        alert('success');
    },
    onLoginFail(err) {
        alert('failure');
    }
});

export default Login;