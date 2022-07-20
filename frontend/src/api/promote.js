import request from '@/utils/request'

// get promotion 
export function getList() {
  return request(({
    url: '/promotion/all',
    method: 'get'
  }))
}
