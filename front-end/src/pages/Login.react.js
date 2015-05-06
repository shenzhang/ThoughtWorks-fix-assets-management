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
                <div className='page-login'>
                    <p className='title'>Log in</p>
                    <div className='content'>
                        <p>User name</p>
                        <input type='text' id='username' onInput={this.onInputed}/>
                    </div>
                    <div className='content'>
                        <p>Password</p>
                        <input type='password' id='password' onInput={this.onInputed}/>
                        <a href='http://www.baidu.com'>Forget your password?</a>
                    </div>
                    <RaisedButton className='button' label='Log in' primary={true} onClick={this._login} disabled={this.state.disabled}></RaisedButton>
                </div>
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
        alert('success message: '+msg);
    },
    onLoginFail(err) {
        alert('failure message: '+err);
    }
});

export default Login;