package fun.mizhuo.hrserver.mapper;

import fun.mizhuo.hrserver.model.Position;

import java.util.List;

/**
 * @author mizhuo
 */
public interface PositionMapper {

    List<Position> getAllPosition();

    Integer addPosition(Position position);

    Integer updatePosition(Position position);

    Integer deletePosition(Integer id);

    Integer deleteMorePosition(List<Position> positions);
}