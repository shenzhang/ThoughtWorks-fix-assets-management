var React = require('react');

var Home = React.createClass({
  statics: {
    routeName: 'Home'
  },

  getDefaultProps() {
    return {
      routeName: 'Home'
    }
  },

  render() {
    return (
      <div block={this.$$block}>
        <header elem='header'>Header</header>
        <main elem='main'>Hello World</main>
        <footer elem='footer'>Footer</footer>
      </div>
    );
  }
});

module.exports = Home;
