import axios from 'axios';
// eslint-disable-next-line no-unused-vars
import qs from 'qs';

import { Message } from "element-ui";
import router from '@/router/index';
import { TIME_OUT, BASE_URL, HOST } from '@/constant';
import { getAuthority } from '@/utils/authority';

const noPermission = [10003]
const noLogin = [401]
const isSuccess = [200]
export const code = {
  noPermission, noLogin, isSuccess
}

// axios 配置
axios.defaults.timeout = TIME_OUT;
axios.defaults.headers['Content-Type'] = 'application/json';

// POST传参序列化
axios.interceptors.request.use((config) => {

  if (!config.params) {
    config.params = {}
  }

  const authority = getAuthority();
  authority && (config.headers['check-token'] = authority);

  // if (config.method === 'post') {
  //   config.data = qs.stringify(config.data);
  // }
  return config;
}, (error) => {
  return console.log(error);
});

// 返回状态判断
axios.interceptors.response.use((res) => {
  const data = res.data || {}
  const msg = GetErrMsg(res);
  const code = data.code;
  const isDownload = res.headers['content-type'].indexOf('document') !== -1

  if (res.status != 200) {
    loginInvalid(res.status)
    if (res.status === 403) {
      router.push('/403');
    }
    MessagError({ msg });
    return null
  } else {
    if (isSuccess.indexOf(code) !== -1) {
      data.success = true
      return res;
    } else if(isDownload) {
      res.success = true
      download(res)
      return res;
    } else if (!loginInvalid(code)) {
      if (!(res.config.params && res.config.params.noErrorMsg)) {
        MessagError({ msg, code, res });
      }
      data.msg = msg
      data.success = false
      return res
    }
  }
}, (error) => {
  let msg = '';
  let code = '';

  const isCancel = error && error.__CANCEL__

  if (error.response && error.response.status) {
    code = error.response.status;
    msg = error.response.data.message;
    MessagError({ msg });
  } else {
    if (isCancel) {
      msg = '请求已取消'
    } else {
      msg = error.message || '网络连接异常'
      MessagError({ msg });
    }
  }
  return Promise.resolve({ data: { success: false, msg, code } })
});

function MessagError({ msg, code }) {
  Message({
    message: code + ': ' + msg,
    type: 'error',
    duration: 2 * 1000
  })
}

// 检查登录失效
export function loginInvalid(code) {
  if (noLogin.indexOf(code) !== -1) {
    router.push('/login')
    return true
  }
  return false
}

// upload也引入了这个函数 统一 errormsg 获取方式
export function GetErrMsg(respone) {
  const data = respone.code ? respone : respone.data;
  const msg = data && data.tips || data.msg || data.message;
  return msg
}


export default function request({ type = 'post', params, data, url }) {

  const config = {
    method: type,
    url: HOST + BASE_URL + url,
    params,
    data,
  }
  if (type === 'download') {
    config.responseType = 'arraybuffer'
    config.method = 'post'
  }

  return axios(config).then(response => {
    return response && response.data
  }, err => {
    return err
  })
  .catch((error) => {
    return error
  });
}

import moment  from 'moment';


function download(res) {
  if (res.success) {
    // 触发下载
    const headers = res.headers
    const format = "YYYY-MM-DD";
    const name = `体检信息表-${ moment().format(format)}-${Math.round(Math.random() * 100000)}.xls`
    console.log(name);
    const disposition = headers['Content-Disposition'] || `filename=` + name
    const url = window.URL.createObjectURL(new Blob([res.data]))
    const link = document.createElement('a')
    link.style.display = 'none'
    link.href = url
    link.setAttribute('download', disposition.split('=')[1].replace(/"/g, ''))
    document.body.appendChild(link)
    link.click()
    document.body.removeChild(link)
  }
}
