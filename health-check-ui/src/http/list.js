import request from '@/plugins/axios.config'

export function getBodyCheckList ({ pageNo, limit, hzmc, hzsfz, lrys, lrdw, startDate, endDate }) {
  return request({
    url: '/health/page/check',
    data: {
      pageNo, limit,
      entity: {
        hzmc, hzsfz, lrys, lrdw, startDate, endDate
      }
    }
  })
  
}

export function deleteBodyCheck ({ id}) {
  return request({
    url: `/health/delete/${id}`,
    type: 'delete'
  })
  
}

export function excelExport ({ hzmc, hzsfz, lrys, lrdw, startDate, endDate }) {
  return request({
    url: `/health/excel/export`,  
    type: 'download',
    data: {
      hzmc, hzsfz, lrys, lrdw, startDate, endDate
    }
  })
}