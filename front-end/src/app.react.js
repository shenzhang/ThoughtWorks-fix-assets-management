import React from 'react'
import {
  Navigation,
  State,
  RouteHandler
  } from 'react-router'
import {
  AppBar,
  AppCanvas,
  LeftNav,
  IconButton,
  Icons
  } from 'material-ui'

import AppLeftNav from './LeftNav'
import ContentWithNav from './ContentWithNav'

import Header from './Header'
import Footer from './Footer'

var BasePage = React.createClass({

  mixins: [Navigation, State],

  getDefaultProps() {
    return {
      title: ''
    }
  },

  render() {
    return (
      <AppCanvas predefinedLayout={1}>
        <AppBar
          className="mui-dark-theme"
          onMenuIconButtonTouchTap={this._toggleLeftNav}
          showMenuIconButton={true}
          title={this.props.title}
          zDepth={0}>
        </AppBar>
        <AppLeftNav ref="leftNav"/>
        <ContentWithNav>
          <RouteHandler />
        </ContentWithNav>
        <Footer />
      </AppCanvas>
    );
  },
  _toggleLeftNav() {
    this.refs.leftNav.toggle()
  }
});

export default BasePage
