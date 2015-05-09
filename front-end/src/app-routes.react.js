import React from 'react'
import {
  run,
  Route,
  NotFoundRoute,
  DefaultRoute
} from 'react-router'

import {
  Home,
  User,
  Assets,
  Login,
  NotFound,
  CreateUser
} from './pages'

import App from './app.react'

const appRoutes = (
  <Route name='root' path="/" handler={App}>
    <DefaultRoute name='home' handler={Home}/>
    <Route name='user' handler={User}/>
    <Route name='assets' handler={Assets}/>
    <Route name='login' handler={Login}/>
    <Route name='user/create' handler={CreateUser}/>
    <NotFoundRoute handler={NotFound}/>
  </Route>
)

export default appRoutes
