import React from 'react';
import {
    RaisedButton,
    Paper,
    TextField
    } from 'material-ui';
import {
    Navigation,
    State
    } from 'react-router';
import userApi from './../services/user'

var Reset = React.createClass({
    mixins: [State,Navigation],

    getInitialState() {
        return {
            disabled: true,
            newPasswordError: '',
            confirmPasswordError: ''
        };
    },

    render() {
        return (
            <Paper zDepth={1}>
                <div className='page-login'>
                    <p className='title'>Reset your password</p>
                    <form>
                        <div className='content'>
                            <TextField ref='newPassword' type='password'
                                       floatingLabelText="New Password" onInput={this.onInputed} pattern='.{8,}' />
                            <span>{this.state.newPasswordError}</span>
                        </div>
                        <div className='content'>
                            <TextField ref='confirmPassword' type='password'
                                       floatingLabelText="Confirm Password" onInput={this.onInputed} pattern='.{8,}' />
                            <span>{this.state.confirmPasswordError}</span>
                        </div>
                        <RaisedButton className='button' label='Submit' primary={true} onClick={this._reset} disabled={this.state.disabled} ></RaisedButton>
                    </form>
                </div>
            </Paper>
        );
    },
    onInputed() {
        var regx = new RegExp(".{8,}");
        var name = this.refs.newPassword.getValue();
        var password = this.refs.confirmPassword.getValue();
        this.setState({disabled: !(regx.test(name)&&regx.test(password))});
    },
    _reset() {
        if (this.refs.newPassword.getValue()!=this.refs.confirmPassword.getValue()) {
            this.setState({
                confirmPasswordError: 'The confirm password should be equal to new password.'
            });
        } else {
            userApi.reset({
                newPassword: this.refs.newPassword.getValue(),
                accessToken: 'accessToken'//需要考虑修改
            }).then(this.onSuccess, this.onFailure);
        }
    },
    onSuccess(msg) {
        console.log(msg);
        this.context.router.transitionTo('home');
    },
    onFailure(err) {
        console.log(err);
    }
});

export default Reset;