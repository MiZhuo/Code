package fun.mizhuo.seckill.exception;

import fun.mizhuo.seckill.vo.ResponseVoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: GlobalException
 * @Author: MiZhuo
 * @Date: 2022/6/4 21:37
 * @Description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends RuntimeException{

    private ResponseVoEnum responseVoEnum;
}
