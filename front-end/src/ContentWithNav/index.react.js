import React from 'react'
import {
  RouteHandler,
  Navigation,
  State
} from 'react-router'

var ContentWithNav = React.createClass({

  mixins: [Navigation, State],

  render: function() {
    return (
      <div className="mui-app-content-canvas page-with-nav">
        <div className="page-with-nav-content">
          <RouteHandler />
        </div>
      </div>
    );
  }
});

export default ContentWithNav
