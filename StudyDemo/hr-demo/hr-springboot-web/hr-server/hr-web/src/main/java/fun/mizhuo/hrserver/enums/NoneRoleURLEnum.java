package fun.mizhuo.hrserver.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: Mizhuo
 * @time: 2020/10/14 20:08 下午
 * @description: 直接放行的url枚举类
 */
public enum NoneRoleURLEnum{
    SWAGGER_URLS("Swagger相关路径",new String[]{"/v2/api-docs","/swagger-resources","/swagger-resources/configuration/security","/swagger-ui.html","/webjars"});

    private String desc;
    private String[] urls;

    public String[] getUrls() {
        return urls;
    }

    NoneRoleURLEnum(String desc,String[] urls){
        this.desc = desc;
        this.urls = urls;
    }

    public static boolean checkRole(String checkUrl){
        if(StringUtils.isEmpty(checkUrl)){
            return false;
        }
        for(NoneRoleURLEnum e : NoneRoleURLEnum.values()){
            for(String url : e.getUrls()){
                if(checkUrl.equals(url) || checkUrl.startsWith(url)){
                    return true;
                }
            }
        }
        return false;
    }
}
