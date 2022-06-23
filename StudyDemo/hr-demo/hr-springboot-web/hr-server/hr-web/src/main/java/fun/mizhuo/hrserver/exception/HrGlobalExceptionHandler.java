package fun.mizhuo.hrserver.exception;

import fun.mizhuo.hrserver.model.ResponseVo;
import fun.mizhuo.hrserver.util.ErrMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author: Mizhuo
 * @time: 2020/9/6 5:11 下午
 * @description:
 */
@RestControllerAdvice
public class HrGlobalExceptionHandler{

    /**
     * 抓取数据库异常
     * @param e
     * @return
     */
    @ExceptionHandler(SQLException.class)
    public ResponseVo sqlException(SQLException e){
        if(e instanceof SQLIntegrityConstraintViolationException){
            return ResponseVo.error(ErrMessage.POSITION_ERROR_MESSAGE1);
        }
        return ResponseVo.error(ErrMessage.SQL_ERROR_MESSAGE1);
    }

    /**
     * 抓取Hr自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(HrException.class)
    public ResponseVo hrException(HrException e){
        return ResponseVo.error(e.getMsg());
    }
}
