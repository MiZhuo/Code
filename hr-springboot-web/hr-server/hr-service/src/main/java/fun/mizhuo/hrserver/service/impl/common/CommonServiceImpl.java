package fun.mizhuo.hrserver.service.impl.common;

import fun.mizhuo.hrserver.mapper.CommonMapper;
import fun.mizhuo.hrserver.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/9/19 9:20 下午
 * @description: 公共服务实现类
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    CommonMapper commonMapper;

    @Override
    public List<Map<String,String>> getDropDownList(String code) {
        return commonMapper.getDropDownList(code);
    }
}
