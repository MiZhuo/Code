import request from '@/utils/request'
import Qs from "qs";

//搜索日志信息
export function searchWorklogs(offset, pageNum,pageSize,startDate,endDate,status,creator,creatorName,keyword) {
  return request({
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded; charset=lUTF-8'
    },
    transformRequest: [function(data) {
      data = Qs.stringify(data);
      return data
    }],
    url: '/worklog/global/search.json',
    method: 'post',
    data: {
      offset,
      pageNum,
      pageSize,
      startDate,
      endDate,
      status,
      creator,
      creatorName,
      keyword
    }
  })
}

//保存到草稿
export function addWorkLog(data){
  return request({
    url: '/worklog/add.json',
    method: 'post',
    data: data
  })
}

//获取某天的日志信息
export function getWorkLog(workDate) {
  return request({
    url: '/worklog/add.json?workDate=' + workDate,
    method: 'get'
  })
}


export function getAllWorkLogs(pageNum,pageSize,sortOrder,creator,type,startDate,endDate,level,status) {
  return request({
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded; charset=lUTF-8'
    },
    transformRequest: [function(data) {
      data = Qs.stringify(data);
      return data
    }],
    url: '/worklog/employee/list.json',
    method: 'post',
    data: {
      pageNum,
      pageSize,
      sortOrder,
      creator,
      type,
      startDate,
      endDate,
      level,
      status
    }
  })
}

export function updateWorklog(data) {
  return request({
    url: '/worklog/update.json',
    method: 'post',
    data: data
  })
}

export function deleteWorkLog(itemId) {
  return request({
    url: '/worklogItem/delete.json?itemId=' + itemId,
    method: 'get'
  })
}

export function submitWorkLog(data) {
  return request({
    url: '/worklog/submit.json',
    method: 'post',
    data: data
  })
}
