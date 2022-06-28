import {getRequest} from "./api";

export const initMenu = (router,store)=>{
    if(store.state.routes.length > 0){
        return ;
    }
    getRequest("/sys/config/menu").then(res=>{
        if(res){
            let fmtRoutes = formatRoutes(res.result);
            router.addRoutes(fmtRoutes);
            store.commit('initRoutes',fmtRoutes);
        }
    })
}

export const formatRoutes = (routes)=>{
    let fmtRoutes = [];
    routes.forEach(router=>{
        let {
            url,
            path,
            component,
            name,
            meta,
            iconCls,
            children
        } = router;
        if(children && children instanceof Array){
            children = formatRoutes(children);
        }
        let fmRouter = {
            path : path,
            name : name,
            meta : meta,
            iconCls : iconCls,
            children : children,
            component(resolve){
                if(url != '/'){
                    require(['../views/' + component.substr(0, 3).toLowerCase() + '/' + component + '.vue'],resolve);
                }else {
                    require(['../views/' + component + '.vue'],resolve);
                }
            }
        }
        fmtRoutes.push(fmRouter);
    });
    return fmtRoutes;
}