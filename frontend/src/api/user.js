import request from '@/utils/request'

// user homepage
export function getInfoByName(username, page, size) {
  return request({
    url: '/ums/user/' + username,
    method: 'get',
    params: {
      pageNo: page,
      size: size
    }
  })
}
// user info
export function getInfo() {
  return request({
    url: '/ums/user/info',
    method: 'get'
  })
}
// user update
export function update(user) {
  return request({
    url: '/ums/user/update',
    method: 'post',
    data: user
  })
}


