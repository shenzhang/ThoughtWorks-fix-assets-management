import _ from 'lodash'

import lodashDeep from 'lodash-deep'
_.mixin(lodashDeep);

import React from 'react'

import {
  Home,
  NotFound
} from './pages'

import {
  run,
  Route,
  NotFoundRoute,
  DefaultRoute,
  RouteHandler
} from 'react-router'

const App = React.createClass({
  render() {
    return (
      <RouteHandler/>
    );
  }
});

const rootRoutes = (
  <Route name='app' path="/" handler={App} alt='Home'>
    <DefaultRoute handler={Home}/>
    <NotFoundRoute handler={NotFound}/>
  </Route>
);

run(rootRoutes, function (Handler, state) {
  React.render(<Handler />, document.body);
});
