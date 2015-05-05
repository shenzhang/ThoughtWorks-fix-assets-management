import React from 'react';
import {
    RaisedButton,
    Paper
    } from 'material-ui';
import State from 'react-router';

var Login = React.createClass({
    mixins: [State],

    render() {
        return (
            <Paper zDepth={1}>
                <p>Log in</p>
                <div></div>
                <div></div>
                <RaisedButton label='Log in' primary='true'></RaisedButton>
            </Paper>
        );
    }
});

export default Login;