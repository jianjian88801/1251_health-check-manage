import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    userInfo: {}
  },
  mutations: {
    SET_USER_INFO(state, userInfo) {
      localStorage.setItem('USER_INFO', userInfo && JSON.stringify(userInfo))
      state.userInfo = userInfo
    }
  },
  actions: {
  },
  modules: {
  }
})
