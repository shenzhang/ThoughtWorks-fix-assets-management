import React from 'react';
import {
    RaisedButton,
    Paper,
    TextField
    } from 'material-ui';
import {
    Link,
    State
    } from 'react-router';
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
                    <TextField id='username' className='content'
                        floatingLabelText="User Name" onInput={this.onInputed} />
                    <TextField id='password' className='content' type='password'
                               floatingLabelText="Password" onInput={this.onInputed} >
                        <Link to='/notFound'>Forget your password?</Link>
                    </TextField>
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