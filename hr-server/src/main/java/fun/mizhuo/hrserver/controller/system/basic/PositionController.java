package fun.mizhuo.hrserver.controller.system.basic;

import fun.mizhuo.hrserver.model.Position;
import fun.mizhuo.hrserver.model.ResponseVo;
import fun.mizhuo.hrserver.service.system.basic.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/6 3:09 下午
 * @description: 职位Controller
 */
@Api(value = "职位Controller",tags = {"职位管理接口"})
@RestController
@RequestMapping("/system/basic/position")
public class PositionController {

    @Autowired
    PositionService positionService;

    @ApiOperation(value = "获取所有职位信息")
    @GetMapping("/")
    public ResponseVo getAllPosition(){
        List<Position> positions = positionService.getAllPosition();
        return ResponseVo.ok("",positions);
    }

    @ApiOperation(value = "添加职位信息")
    @PostMapping("/")
    public ResponseVo addPosition(@RequestBody Position position){
        if(positionService.addPosition(position) == 1){
            return ResponseVo.ok("添加成功!");
        }
        return ResponseVo.error("添加失败!");
    }

    @ApiOperation(value = "更新职位信息")
    @PutMapping("/")
    public ResponseVo updatePosition(@RequestBody Position position){
        if(positionService.updatePosition(position) == 1){
            return ResponseVo.ok("更新成功!");
        }
        return ResponseVo.error("更新失败!");
    }

    @ApiOperation(value = "删除职位信息")
    @DeleteMapping("/{id}")
    public ResponseVo deletePosition(@PathVariable Integer id){
        if(positionService.deletePosition(id) == 1){
            return ResponseVo.ok("删除成功!");
        }
        return ResponseVo.error("删除失败!");
    }

    @ApiOperation(value = "批量删除职位信息")
    @DeleteMapping("/deleteMore")
    public ResponseVo deleteMorePosition(@RequestBody List<Position> positions){
        if(positionService.deleteMorePosition(positions) > 0){
            return ResponseVo.ok("删除成功!");
        }
        return ResponseVo.error("删除失败!");
    }

    @ApiOperation(value = "启用/禁用当前职位")
    @PutMapping("/{id}/{enabled}")
    public ResponseVo updatePosition(@PathVariable Integer id, @PathVariable Boolean enabled){
        Position position = new Position();
        position.setId(id);
        position.setEnabled(enabled);
        if(positionService.updatePosition(position) == 1){
            if(enabled){
                return ResponseVo.ok("启用成功!");
            }else{
                return ResponseVo.ok("禁用成功!");
            }
        }
        return ResponseVo.error("操作失败!");
    }
}
