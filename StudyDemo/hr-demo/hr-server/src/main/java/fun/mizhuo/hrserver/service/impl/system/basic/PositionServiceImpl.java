package fun.mizhuo.hrserver.service.impl.system.basic;

import fun.mizhuo.hrserver.mapper.PositionMapper;
import fun.mizhuo.hrserver.model.Position;
import fun.mizhuo.hrserver.service.system.basic.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/6 3:18 下午
 * @description: 职位服务实现类
 */
@Service
public class PositionServiceImpl implements PositionService {

    private Logger logger = LoggerFactory.getLogger(PositionServiceImpl.class);

    @Autowired
    PositionMapper positionMapper;

    @Override
    public List<Position> getAllPosition() {
        return positionMapper.getAllPosition();
    }

    @Override
    public Integer addPosition(Position position) {
        return positionMapper.addPosition(position);
    }

    @Override
    public Integer updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }

    @Override
    public Integer deletePosition(Integer id) {
        return positionMapper.deletePosition(id);
    }

    @Override
    public Integer deleteMorePosition(List<Position> positions) {
        return positionMapper.deleteMorePosition(positions);
    }
}
