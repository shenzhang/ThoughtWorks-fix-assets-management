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

var Reset = React.createClass({
    mixins: [State,Navigation],

    getInitialState() {
        return {
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
                                       floatingLabelText="New Password" required pattern='.{8,}' />
                        </div>
                        <div className='content'>
                            <TextField ref='confirmPassword' type='password'
                                       floatingLabelText="Confirm Password" required pattern='.{8,}' />
                            <span>{this.state.confirmPasswordError}</span>
                        </div>
                        <RaisedButton className='button' label='Submit' primary={true} onClick={this._reset} ></RaisedButton>
                    </form>
                </div>
            </Paper>
        );
    },
    _reset() {
        if (this.refs.newPassword.getValue()!=this.refs.confirmPassword.getValue()) {
            this.setState({
                confirmPasswordError: 'The confirm password should be equal to new password.'
            });
            return ;
        }
        userApi.reset({
            newPassword: this.refs.newPassword.getValue(),
            confirmPassword: this.refs.confirmPassword.getValue()
        }).then(this.onSuccess, this.onFailure)
    },
    onSuccess(msg) {
        console.log(msg);
        if (msg.isNewUser) {
            this.context.router.transitionTo('user');
        } else {
            this.context.router.transitionTo('home');
        }
    },
    onFailure(err) {
        var messageJson = {};
        var fieldName = err.response.body.message ==='The user is not exist.'?
            'userError' : 'confirmPasswordError'
        messageJson[fieldName] = err.response.body.message;
        this.setState(messageJson);
    }
});

export default Reset;