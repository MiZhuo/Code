package fun.mizhuo.seckill.aspect;

import cn.hutool.Hutool;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName: GlobalAspect
 * @Author: MiZhuo
 * @Date: 2022/6/13 20:49
 * @Description: 全局切面，用于校验登录以及记录日志
 */

@Slf4j
@Aspect
@Component
public class GlobalAspect {

    @Autowired
    HttpServletRequest request;

    /**
     * 接口调用进程代码
     */
    public static ThreadLocal<Long> currentThreadId = new ThreadLocal<>();

    /**
     * 调用接口路径
     */
    public static ThreadLocal<StringBuffer> apiUrl = new ThreadLocal<>();

    /**
     * 请求开始时间戳
     */
    public static ThreadLocal<Long> callTime = new ThreadLocal<>();

    @Value("${spring.profiles.active}")
    private String env;

    @Pointcut("execution(* fun.mizhuo.seckill.controller.*Controller.*(..))")
    protected void loginOperation() {
    }

    @Before("loginOperation()")
    @Order(1)
    public void logJoinPoint(JoinPoint joinPoint) {
        HttpServletRequest request = this.request; //获取request请求对象
        callTime.set(System.currentTimeMillis()); //开始时间戳
        apiUrl.set(request.getRequestURL()); //请求路径
        currentThreadId.set(System.currentTimeMillis()); //时间戳

        StringBuilder logger = new StringBuilder("\n" + "**************[" + currentThreadId.get() + "]请求内容开始了**************"
                + "\n" + "请求地址:" + request.getRequestURI() + "\n" + "请求方式:" + request.getMethod() + "\n" + "请求类方法:" + joinPoint.getSignature() + ":" + joinPoint.getSignature().getName()
        );

        try {
            if (RequestMethod.GET.name().equals(request.getMethod())) {
                logger.append("\n" + "请求类方法参数:");
                Map<String, String[]> map = request.getParameterMap();
                JSONObject jsonObject = new JSONObject();
                jsonObject.putAll(map);
                logger.append(jsonObject.toString());
            } else if (RequestMethod.POST.name().equals(request.getMethod())) {
                logger.append("\n" + "请求类方法参数:");
                String s = Arrays.toString(joinPoint.getArgs());
                logger.append(s);
            }
        } catch (Exception e) {
            logger.append("\n" + "      加载参数内容失败");
        }
        logger.append("\n" + "**************[").append(currentThreadId.get()).append("]请求内容结束**************");
        log.info(logger.toString());
    }

    @AfterReturning(pointcut = "loginOperation()", returning = "result")
    @Order(2)
    public void logAfter(JoinPoint joinPoint, Object result) {
        long costTime = System.currentTimeMillis() - callTime.get(); //计算耗时时间
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("args",result);
        log.info("\n" + "**************[" + currentThreadId.get() + "]返回内容开始了**************" + "\n" + "接口地址:" + apiUrl.get() + "\n" + "返回内容:" + jsonObject.toString() + "\n" + "请求耗时时间:" + costTime + "ms" + "" +
                "\n" + "**************[" + currentThreadId.get() + "]返回内容结束**************");
        remove();
    }

    @AfterThrowing(pointcut = "execution(* fun.mizhuo.seckill.controller.*Controller.*(..))", throwing = "e")
    @Order(3)
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        long costTime = System.currentTimeMillis() - callTime.get(); //计算耗时时间
        log.info("\n" + "**************[" + currentThreadId.get() + "]请求失败了**************" + "\n" + "接口地址:" + apiUrl.get() + "\n" + "请求失败:" + e.getMessage() + "\n" + "请求耗时时间:" + costTime + "ms" + "" +
                "\n" + "请求错误类方法:" + joinPoint.getSignature() + ":" + joinPoint.getSignature().getName() + "\n" + "Cause:" + e.getCause() + "\n" + "**************[" + currentThreadId.get() + "]返回内容结束**************");
        remove();
    }

    @Around("execution(* fun.mizhuo.seckill.controller.*Controller.*(..))")
    @Order(4)
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object result = joinPoint.proceed();
            log.info("The method " + joinPoint.getSignature().getName() + "() ends with " + result);
            return result;
        } catch (Exception e) {
            log.info("\n" + "**************[" + currentThreadId.get() + "]请求抛异常了**************" + "\n" + "接口地址:" + apiUrl.get() + "\n" + "请求参数:" + Arrays.toString(joinPoint.getArgs()) +
                    "\n" + "请求抛异常类方法:" + joinPoint.getSignature() + ":" + joinPoint.getSignature().getName() + "\n" + "**************[" + currentThreadId.get() + "]异常抛出内容结束**************");
            throw e;
        }
    }

    public static void remove() {
        currentThreadId.remove();
        apiUrl.remove();
        callTime.remove();
    }
}
