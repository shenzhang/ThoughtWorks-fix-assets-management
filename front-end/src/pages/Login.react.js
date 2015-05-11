import React from 'react';
import {
    RaisedButton,
    Paper,
    TextField
    } from 'material-ui';
import {
    Link,
    Navigation,
    State
    } from 'react-router';
import userApi from './../services/user'

var Login = React.createClass({
    mixins: [State,Navigation],

    getInitialState() {
        return {
            disabled: true,
            userError: '',
            passwordError: ''
        };
    },

    render() {
        return (
            <Paper zDepth={1}>
                <div className='page-login'>
                    <p className='title'>Log in</p>
                    <div className='content'>
                        <TextField ref='username'
                            floatingLabelText="User Name" onInput={this.onInputed} />
                        <span>{this.state.userError}</span>
                    </div>
                    <div className='content'>
                        <TextField ref='password' className='content' type='password'
                                   floatingLabelText="Password" onInput={this.onInputed} />
                        <span>{this.state.passwordError}</span>
                    </div>
                    <Link to='/notFound'>Forget your password?</Link>
                    <RaisedButton className='button' label='Log In' primary={true} onClick={this._login} disabled={this.state.disabled}></RaisedButton>
                </div>
            </Paper>
        );
    },
    onInputed() {
        this.setState({disabled: !(this.refs.username.getValue() && this.refs.password.getValue())});
    },
    _login() {
        this.setState({
            userError: '',
            passwordError: ''
        });
        userApi.login({
            username: this.refs.username.getValue(),
            password: this.refs.password.getValue()
        }).then(this.onLogin, this.onLoginFail)
    },
    onLogin(msg) {
        this.context.router.transitionTo('home');
    },
    onLoginFail(err) {
        if (err.errorMessage==='The user is not exist.') {
            this.setState({userError: err.errorMessage});
        } else {
            this.setState({passwordError: err.errorMessage});
        }
    }
});

export default Login;