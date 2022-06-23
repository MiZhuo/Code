import request from '@/utils/request'
import Qs from 'qs'
export function login(loginName, password) {
  return request({
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    transformRequest: [function(data) {      //在请求之前对data传参进行格式转换
      data = Qs.stringify(data);
      return data
    }],
    url: '/logon',
    method: 'post',
    data: {
     loginName,
     password
    }
  })
}

export function getInfo() {
  return request({
    url: '/info',
    method: 'get',
  })
}

export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}
