import React from 'react'
import {
  Navigation,
  State
} from 'react-router'

import {
  LeftNav
} from 'material-ui'

const menuItems =  [{
  text: 'Home',
  route: 'home'
},{
  text: 'User',
  route: 'user'
},{
  text: 'User Assets',
  route: 'assets'
}]

const AppLeftNav = React.createClass({

  mixins: [Navigation, State],

  render() {
    const menuTitle = <div className="menu__title" onClick={this._onHeaderClick}>Menu Title</div>;

    return (
        <LeftNav
          ref="leftNav"
          docked={false}
          isInitiallyOpen={true}
          header={menuTitle}
          menuItems={menuItems}
          selectedIndex={this._getSelectedIndex()}
          onChange={this._onLeftNavChange}/>
    );
  },

  toggle() {
    this.refs.leftNav.toggle();
  },

  _getSelectedIndex: function() {
    if (!this.context.router) {
      return 0
    }
    return menuItems.findIndex(menuItem => {
      menuItem.route && this.context.router.isActive(menuItem.route)
    })
  },

  _onLeftNavChange: function(e, key, payload) {
    this.context.router &&
    this.context.router.transitionTo(payload.route);
    this.refs.leftNav.toggle();
  },

  _onHeaderClick: function() {
    this.context.router &&
    this.context.router.transitionTo('root');
    this.refs.leftNav.close();
  }
});

export default AppLeftNav
