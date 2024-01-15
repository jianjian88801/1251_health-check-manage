
import request from '@/plugins/axios.config'

export function saveBodyCheckForm (data) {
  return request({
    url: '/health/save/info',
    data: data
  })
}


export function getBodyCheck ({ id}) {
  return request({
    url: `/health/detail/${id}`,
    type: 'get'
  })
}
export function getAbnormalInfo (data) {
  return request({
    url: `/health/getAbnormalInfo`,
    data: data
  })
}