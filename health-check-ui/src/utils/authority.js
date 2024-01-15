
import Cookies from 'js-cookie';
import { TOKEN, TOKEN_PREFIX } from '@/constant';

// 获取登录验证
export function getAuthority(token) {
  token = token || Cookies.get(TOKEN)
  return token ? TOKEN_PREFIX + token : '';
}

// 存token
export function setAuthority(authority, expires = 4) {
  return Cookies.set(TOKEN, authority, { expires });
}
// 移除token
export function removeAuthority() {
  return Cookies.remove(TOKEN);
}