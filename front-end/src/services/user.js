import request from 'superagent'
import apisBuilder from '../../utils/apisBuilder'
import config from './config.json'

let mock
var endpoint = "http://localhost:8080"

// mock the http request if not production
if (process.env.NODE_ENV == 'development' || process.env.NODE_ENV == 'test') {
  mock = require('./mock-user')
}

if (process.env.NODE_ENV == 'production') {
  endpoint = "http://52.68.95.171:10000"
}

const userApis = {
  login: {
    method: 'post',
    url: '/auth/login'
  },
  reset: {
    method: 'post',
    url: '/reset'
  },
  logout: {
    method: 'post',
    url: '/auth/logout'
  },
  assets: {
    method: 'get',
    url: '/users/allassets'
  },
  create: {
    method: 'post',
    url: '/users/create'
  }
}

/**
 * build apis from the config or add mock apis
 */
export default apisBuilder(userApis, endpoint, mock)
