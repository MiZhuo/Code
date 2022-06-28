package fun.mizhuo.hrserver.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/9/19 9:29 下午
 * @description:
 */
public interface CommonMapper {
    @Select("select distinct id,name from ${code}")
    List<Map<String,String>> getDropDownList(@Param("code") String code);
}
