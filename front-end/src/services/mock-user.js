export default [
  {
    pattern: 'http://localhost:8080/user/(login|logout)',
    // callback that returns the data
    fixtures: function () {
      return 'success'
    },
    // `match`: result of the resolution of the regular expression
    // `data`: data returns by `fixtures` attribute
    callback: function (match, data) {
      if (match[1]) {
        return data
      } else {
        return new Error('Do not match any urls!')
      }
    }
  },{
    pattern: 'http://localhost:8080/user/(assets)',
    // callback that returns the data
    fixtures: function () {
      return {
        data: [
          {
            name: 'Mac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: 'Mac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: 'Mac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          }
        ]
      }
    },
    // `match`: result of the resolution of the regular expression
    // `data`: data returns by `fixtures` attribute
    callback: function (match, data) {
      if (match[1]) {
        return data
      } else {
        return new Error('Do not match any urls!')
      }
    }
  }
];
