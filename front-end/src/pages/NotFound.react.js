var React = require('react');

var NotFound = React.createClass({
  statics: {
    routeName: 'Page Not Found'
  },

  getDefaultProps() {
    return {
      routeName: 'Page Not Found'
    }
  },

  render() {
    return (
      <div block={this.$$block}>
        <header elem='header'>Header</header>
        <main elem='main'>Page Not Found</main>
        <footer elem='footer'>Footer</footer>
      </div>
    );
  }
});

module.exports = NotFound;
