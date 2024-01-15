import request from '@/plugins/axios.config'

export function Login ({ userName, password }) {
  return request({
    url: '/auth/login',
    data: {
      userName, password
    }
  })
  
}