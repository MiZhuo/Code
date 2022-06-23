import axios from 'axios'
import {Message} from 'element-ui'
import store from "../store";
import { getToken } from '@/utils/auth'

// 创建axios实例
const service = axios.create({
  baseURL: 'api',//process.env.BASE_API, // api的base_url
  headers: {'Content-Type': 'application/json;charset=utf-8'},// 设置传输内容的类型和编码
  withCredentials: true,
  timeout: 15000 // 请求超时时间
});

service.interceptors.request.use(config => {
  if (store.getters.token) {
    config.headers['Authorization'] = getToken() // 让每个请求携带自定义token 请根据实际情况自行修改
  }
  return config;
}, err => {
  Message.error({message: '请求超时!'});
  // return Promise.resolve(err);
});

service.interceptors.response.use(response => {
  if (response.status && response.status == 200 && response.data.status == 500) {
    Message.error({message: response.data.msg});
    return;
  }
  if (response.data.msg) {
    Message.success({message: response.data.msg});
  }
  return response;
}, err => {
  if (err.response.status == 504 || err.response.status == 404) {
    Message.error({message: '连接服务器失败,请稍后重试!'});
  } else if (err.response.status == 403) {
    Message.error({message: '权限不足,请联系管理员!'});
  } else if (err.response.status == 401) {
    Message.error({message: err.response.data.msg});
  } else {
    if (err.response.data.msg) {
      Message.error({message: err.response.data.msg});
    }else{
      Message.error({message: '未知错误!'});
    }
  }
  //return Promise.resolve(err);
});

export default service
