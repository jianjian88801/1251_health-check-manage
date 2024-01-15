module.exports = {
  devServer: {
    open: true,
    hot: true,
    proxy: {
      '/api/check': {
        // target: 'http://test.xunmaw.com:8800',
        target: 'http://localhost:8800',
        ws: true,
        changeOrigin: true,
      },
    }
  }
}