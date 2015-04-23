import request from 'superagent'

const endpoint = 'http://localhost:8080'

const userApis = {
  login: {
    method: 'post',
    url: '/user/login'
  },
  logout: {
    method: 'post',
    url: '/user/logout'
  },
}

/**
 * userApiInterface
 * provide all the api interface for user
 */
const userApiInterface = Object.keys(userApis).reduce(function(apis, name) {
  const api = userApis[name]
  if (api) {
    apis[name] = function() {
      const args = arguments
      return new Promise(function(resolve, reject) {
        if (validMethod(api.method)) {
          request[api.method](endpoint + api.url)
            .send(args[0])
            .end(function(err, data) {
              if (err) {
                return reject(err)
              }
              resolve(data)
            })
        } else {
          reject(new Error('invalid method!'))
        }
      })
    }
  }
  return apis
}, {})

// for mocking the http requests
userApiInterface._request = request;

export default userApiInterface

function validMethod(method) {
  if (typeof method !== 'string')
    return new Error('invalid method type!')
  return [
    'post',
    'get',
    'put',
    'delete',
    'head',
    'update'].find(item => method.toLowerCase() === item)
}
