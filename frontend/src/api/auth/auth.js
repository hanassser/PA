import request from '@/utils/request'

// register
export function userRegister(userDTO) {
  return request({
    url: '/ums/user/register',
    method: 'post',
    data: userDTO
  })
}

// user login frontend
export function login(data) {
  return request({
    url: '/ums/user/login',
    method: 'post',
    data
  })
}
// get frontend user information after login
export function getUserInfo() {
  return request({
    url: '/ums/user/info',
    method: 'get'
  })
}
// frontend user log out
export function logout() {
  return request({
    url: '/ums/user/logout'
  })
}