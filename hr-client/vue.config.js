let prodEnv = require('.env.prod');  // 生产环境
let devEnv = require('.env.dev');  // 开发环境
const env = process.env.NODE_ENV;
let target = '';
let socket_target = '';
// 默认是本地环境
if(env==='production'){  // 生产环境
    target = prodEnv.VUE_SERVER_URL;
    socket_target = prodEnv.VUE_SOCKET_URL;
}else {  // 开发环境
    target = devEnv.VUE_SERVER_URL;
    socket_target = devEnv.VUE_SOCKET_URL;
}

let proxyObj = {}

proxyObj['/ws'] = {
    ws : true,
    target : socket_target,
    changeOrigin : true,
    pathRewrite : {
        '^/ws' : '/ws'
    }
}

proxyObj['/'] = {
    ws : false,
    target : target,
    changeOrigin : true,
    pathRewrite : {
        '^/api' : ''
    }
}

module.exports={
    devServer:{
        host : 'localhost',
        port : '8081',
        proxy : proxyObj
    },
    outputDir: 'dist-' + env
}