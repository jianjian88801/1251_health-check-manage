// 定义常量

// 请求超时时间毫秒

export const IS_PROD = process.env.NODE_ENV === 'production'

export const HOST = IS_PROD ? 'http://localhost:8800' : ''
// export const HOST = 'http://ojbk.redsonw.com/api/admin';
// export const HOST = '';
export const TIME_OUT = 60 * 1000;
export const BASE_URL = '/api/check';
// export const BASE_URL = '/api/admin';
// token 键
export const TOKEN = 'check-token'; // 更新登录状态
export const TOKEN_PREFIX = ' '; // 更新登录状态
export const Array_Prefix = 'array_prefix_'; // 更新登录状态