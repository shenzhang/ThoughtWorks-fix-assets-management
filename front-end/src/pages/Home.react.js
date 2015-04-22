import React from 'react'
import {
  FlatButton
} from 'material-ui'
import {
  Navigation,
  State
} from 'react-router'

var Home = React.createClass({

  mixins: [Navigation, State],

  render() {
    return (
      <div>
        Hello World
        <FlatButton label="Click" primary={true}/>
      </div>
    );
  }
});

export default Home
