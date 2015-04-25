import request from 'superagent'
import apisBuilder from '../../utils/apisBuilder'

let mock

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
  assets: {
    method: 'post',
    url: '/user/assets'
  }
}

// mock the http request if not production
if (process.env.NODE_ENV == 'development' || process.env.NODE_ENV == 'test') {
  mock = require('./mock-user')
}

/**
 * build apis from the config or add mock apis
 */
export default apisBuilder(userApis, endpoint, mock)
