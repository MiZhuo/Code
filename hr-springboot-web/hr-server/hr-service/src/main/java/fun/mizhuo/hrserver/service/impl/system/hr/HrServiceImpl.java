package fun.mizhuo.hrserver.service.impl.system.hr;

import fun.mizhuo.hrserver.mapper.HrMapper;
import fun.mizhuo.hrserver.mapper.HrRoleMapper;
import fun.mizhuo.hrserver.model.Hr;
import fun.mizhuo.hrserver.service.system.hr.HrService;
import fun.mizhuo.hrserver.util.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/9/13 11:08 上午
 * @description: Hr服务实现类
 */
@Service
public class HrServiceImpl implements HrService {

    @Autowired
    HrMapper hrMapper;

    @Autowired
    HrRoleMapper hrRoleMapper;

    @Override
    public List<Hr> getAllHrs() {
        Map<String, Object> params = new HashMap<>();
        params.put("id",HrUtils.getCurrentHr().getId());
        return hrMapper.getAllHrsWithOutCurrentHr(params);
    }

    @Override
    public Integer enabledHrById(Hr hr) {
        return hrMapper.enabledHrById(hr);
    }

    @Override
    @Transactional
    public List<fun.mizhuo.hrserver.model.Role> updateRolesById(Integer id, Integer[] roles) {
        hrRoleMapper.deleteRolesById(id);
        if(roles.length > 0) {
            Map<String, Object> params = new HashMap<>();
            params.put("id", id);
            params.put("roles", roles);
            hrRoleMapper.addRolesById(params);
        }
        List<fun.mizhuo.hrserver.model.Role> roleList = hrRoleMapper.getRolesById(id);
        return roleList;
    }

    @Override
    public Integer deleteHrById(Integer id) {
        return hrMapper.deleteHrById(id);
    }

    @Override
    public List<Hr> searchHrByKeyWord(String keyWord) {
        Map<String, Object> params = new HashMap<>();
        params.put("id",HrUtils.getCurrentHr().getId());
        params.put("keyWord",keyWord);
        return hrMapper.getAllHrsWithOutCurrentHr(params);
    }

}
