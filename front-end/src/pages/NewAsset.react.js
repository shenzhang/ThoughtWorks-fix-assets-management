import React from 'react'
import {
  RaisedButton,
  FontIcon,
  Paper
  } from 'material-ui'
import {
  Navigation,
  State
  } from 'react-router'

import userApi from '../services/user'

var newAsset = React.createClass({

  mixins: [Navigation, State],

  getInitialState() {
    return {
      title: 'Hello World!'
    }
  },

  render() {
    return (
      <h1>newAsset</h1>
    );
  }

});

export default newAsset
