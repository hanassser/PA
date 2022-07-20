import request from '@/utils/request'

// search by keyword
export function searchByKeyword(query) {
  return request({
    url: `/search`,
    method: 'get',
    params: {
      keyword: query.keyword,
      pageNum: query.pageNum,
      pageSize: query.pageSize
    }
  })
}
