package fun.mizhuo.seckill.exception;

import fun.mizhuo.seckill.vo.ResponseVo;
import fun.mizhuo.seckill.vo.ResponseVoEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.validation.BindException;

import java.util.stream.Collectors;

/**
 * @ClassName: GlobalExceptionHandler
 * @Author: MiZhuo
 * @Date: 2022/6/4 21:38
 * @Description: 全局异常处理
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseVo<Object> ExceptionHandler(Exception e){
        String message = null;
        if(e instanceof GlobalException){
            GlobalException ex = (GlobalException) e;
            log.error(ex.getMessage());
            return ResponseVo.error(ex.getResponseVoEnum());
        }else if(e instanceof MethodArgumentNotValidException){
            //处理请求参数格式错误 @RequestBody上使用@Valid 实体上使用@NotNull等，验证失败后抛出的异常是MethodArgumentNotValidException异常
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            message = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        }else if(e instanceof BindException) {
            //处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
            BindException ex = (BindException) e;
            message = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        }else if(e instanceof ConstraintViolationException) {
            //处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是ConstraintViolationException
            ConstraintViolationException ex = (ConstraintViolationException) e;
            message = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        }else if(e instanceof HttpMessageNotReadableException){
            HttpMessageNotReadableException ex = (HttpMessageNotReadableException) e;
            log.error(ex.getMessage());
            return ResponseVo.error(ResponseVoEnum.BIND_ERROR);
        }else {
            return ResponseVo.error(ResponseVoEnum.ERROR);
        }
        return ResponseVo.error(message);
    }

}
