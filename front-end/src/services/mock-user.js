export default [
  {
    pattern: 'http://localhost:8080/auth/(login|logout)',
    // callback that returns the data
    fixtures: function (data) {
      if (data && data.name === 'ncmao') {
        if (data.password === 'P@ss123456') {
          // login success
          return {
            isNewUser: true,
            message: 'Success!'
          }
        } else {
          // password incorrect
          throw new function AuthException() {
            return {
              response: {
                body: {
                  message: 'The password is not correct, please input again.'
                }
              }
            }
          };
        }
      } else {
        throw new function AuthException() {
          return {
            response: {
              body: {
                message: 'The user is not exist.'
              }
            }
          }
        }
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
  },
  {
    pattern: 'http://localhost:8080/asset/(create)',
    fixtures: function (data) {
      if (data.serialName.length === 8 && !isNaN(data.serialName)) {
        if (data.serialName === '12345678') {
          return {
            message: 'The name already exist, please use another one.',
            isNewSerialNumber: false
          }
        } else {
          return {
            message: 'success',
            isNewSerialNumber: true
          }
        }
      } else {
        //return new Error('Name should be made up of 8 numbers.')
        throw new function () {
          this.err = 'Name should be made up of 8 numbers.';
        };
      }
    },
    callback: function (match, data) {
      if (match[1] == "create") {
        return data
      } else {
        return new Error('Do not match any urls!')
      }
    }
  },
  {
    pattern: 'http://localhost:8080/asset/(newAsset)',
    fixtures: function () {
      return {
        assetType: 'MAC Mini',
        assetSerialName: 87654321
      }
    },
    callback: function (match, data) {
      if (match[1] == "newAsset") {
        return data
      } else {
        return new Error('Do not match any urls!')
      }
    }
  },
  {
    pattern: 'http://localhost:8080/users/(allassets)',
    // callback that returns the data
    fixtures: function () {
      return [
        {
          ownerName: "JimmyLv",
          assetName: 'Nokia',
          number: '17006011',
          assignDate: '2015-4-25',
          type: 'Mobile'
        }, {
          ownerName: "JimmyLv",
          assetName: 'Mac Book Pro',
          number: '17005800',
          assignDate: '2015-4-22',
          type: 'Laptop'
        }, {
          ownerName: "JimmyLv",
          assetName: 'Screen',
          number: '17006036',
          assignDate: '2014-2-15',
          type: 'Others'
        }, {//should be returned by back-end, should not mock in front-end
          ownerName: "SiyuYan",
          assetName: 'Mac Book Air',
          number: '17004032',
          assignDate: '2015-8-15',
          type: 'Laptop'
        }
      ]
    },
    // `match`: result of the resolution of the regular expression
    // `data`: data returns by `fixtures` attribute
    callback: function (match, data) {
      if (match[1] == "allassets") {
        return data
      } else {
        return new Error('Do not match any urls!')
      }
    }
  },
  {
    pattern: 'http://localhost:8080/users/(create)',
    // callback that returns the data
    fixtures: function (data) {
      if (data.username === 'jtao1') {
        return {
          message: 'success'
        }
      } else {
        throw new function () {
          this.message = 'Error when create new user!';
        };
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
  },
  {
    pattern: 'http://localhost:8080/(reset)',
    // callback that returns the data
    fixtures: function (data) {
      if (data && data.accessToken == 'accessToken') {
        return {
          message: 'Reset your password success!'
        };
      } else {
        throw new function AuthException() {
          return {
            response: {
              body: {
                message: 'Reset your password failure.'
              }
            }
          }
        }
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
