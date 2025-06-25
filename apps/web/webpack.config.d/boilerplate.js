if(config.devServer) {
  config.devServer.historyApiFallback = {
    rewrites: [
      { from: /.*galgal-wasm.wasm/, to: '/galgal-wasm.wasm' },
    ]
  }
}
