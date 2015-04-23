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

var BasePage = React.createClass({

  mixins: [Navigation, State],

  getDefaultProps() {
    return {
      title: 'Title',
    }
  },

  render() {
    var menuTitle = <div className="menu__title">Menu Title</div>;

    return (
      <AppCanvas predefinedLayout={1}>
        <AppBar
          className="mui-dark-theme"
          onMenuIconButtonTouchTap={this._toggleLeftNav}
          showMenuIconButton={true}
          title={this.props.title}
          zDepth={0}>
        </AppBar>
        <AppLeftNav ref="leftNav" />
        <ContentWithNav>
          <RouteHandler />
        </ContentWithNav>
      </AppCanvas>
    );
  },
  _toggleLeftNav() {
    this.refs.leftNav.toggle()
  }
});

export default BasePage
