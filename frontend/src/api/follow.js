import request from '@/utils/request'

// subscribe
export function follow(id) {
  return request(({
    url: `/relationship/subscribe/${id}`,
    method: 'get'
  }))
}

// stop subscribe
export function unFollow(id) {
  return request(({
    url: `/relationship/unsubscribe/${id}`,
    method: 'get'
  }))
}

// valide if subscribed
export function hasFollow(topicUserId) {
  return request(({
    url: `/relationship/validate/${topicUserId}`,
    method: 'get'
  }))
}
