require("babelify/polyfill")

import React from 'react'
import injectTapEventPlugin from "react-tap-event-plugin"

import { run } from 'react-router'

import appRoutes from './app-routes.react'

//browser
window.React = React;

// enable touch event
injectTapEventPlugin();

run(appRoutes, function (Handler, state) {
  React.render(<Handler />, document.body);
});
