package fun.mizhuo.hrserver.service.system.basic;

import fun.mizhuo.hrserver.model.Position;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/6 3:17 下午
 * @description: 职位服务接口类
 */
public interface PositionService {
    /**
     * 获取职位信息
     * @return
     */
    List<Position> getAllPosition();

    Integer addPosition(Position position);

    Integer updatePosition(Position position);

    Integer deleteMorePosition(List<Position> positions);

    Integer deletePosition(Integer id);
}
