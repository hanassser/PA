import request from '@/utils/request'

// get post list
export function getList(pageNo, size, tab) {
  return request(({
    url: '/post/list',
    method: 'get',
    params: { pageNo: pageNo, size: size, tab: tab }
  }))
}

// create post
export function post(topic) {
  return request({
    url: '/post/create',
    method: 'post',
    data: topic
  })
}

// get post by id
export function getTopic(id) {
  return request({
    url: `/post`,
    method: 'get',
    params: {
      id: id
    }
  })
}
// get recommend posts
export function getRecommendTopics(id) {
  return request({
    url: '/post/recommend',
    method: 'get',
    params: {
      topicId: id
    }
  })
}

export function update(topic) {
  return request({
    url: '/post/update',
    method: 'post',
    data: topic
  })
}

export function deleteTopic(id) {
  return request({
    url: `/post/delete/${id}`,
    method: 'delete'
  })
}

