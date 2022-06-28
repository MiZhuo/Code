package fun.mizhuo.hrserver.controller.system.basic;

import fun.mizhuo.hrserver.model.JobLevel;
import fun.mizhuo.hrserver.model.ResponseVo;
import fun.mizhuo.hrserver.service.system.basic.JobLevelService;
import fun.mizhuo.hrserver.service.system.basic.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/7 22:42 下午
 * @description: 职称Controller
 */
@Api(value = "职称Controller",tags = {"职称管理接口"})
@RestController
@RequestMapping("/system/basic/jobTitle")
public class JobTitleController {

    @Autowired
    JobLevelService jobLevelService;

    @ApiOperation(value = "获取所有职称信息")
    @GetMapping("/")
    public ResponseVo getAllJobTitle(){
        List<JobLevel> jobTitles = jobLevelService.getAllJobTitle();
        return ResponseVo.ok("",jobTitles);
    }

    @ApiOperation(value = "添加职称信息")
    @PostMapping("/")
    public ResponseVo addJobTitle(@RequestBody JobLevel jobTitle){
        if(jobLevelService.addJobTitle(jobTitle) == 1){
            return ResponseVo.ok("添加成功!");
        }
        return ResponseVo.error("添加失败!");
    }

    @ApiOperation(value = "更新职称信息")
    @PutMapping("/")
    public ResponseVo updateJobTitle(@RequestBody JobLevel jobTitle){
        if(jobLevelService.updateJobTitle(jobTitle) == 1){
            return ResponseVo.ok("更新成功!");
        }
        return ResponseVo.error("更新失败!");
    }

    @ApiOperation(value = "删除职称信息")
    @DeleteMapping("/{id}")
    public ResponseVo deleteJobTitle(@PathVariable Integer id){
        if(jobLevelService.deleteJobTitle(id) == 1){
            return ResponseVo.ok("删除成功!");
        }
        return ResponseVo.error("删除失败!");
    }

    @ApiOperation(value = "批量删除职称信息")
    @DeleteMapping("/deleteMore")
    public ResponseVo deleteMoreJobTitle(@RequestBody List<JobLevel> jobTitles){
        if(jobLevelService.deleteMoreJobTitle(jobTitles) > 0){
            return ResponseVo.ok("删除成功!");
        }
        return ResponseVo.error("删除失败!");
    }

    @ApiOperation(value = "启用/禁用当前职称")
    @PutMapping("/{id}/{enabled}")
    public ResponseVo updateJobTitle(@PathVariable Integer id, @PathVariable Boolean enabled){
        JobLevel jobTitle = new JobLevel();
        jobTitle.setId(id);
        jobTitle.setEnabled(enabled);
        if(jobLevelService.updateJobTitle(jobTitle) == 1){
            if(enabled){
                return ResponseVo.ok("启用成功!");
            }else{
                return ResponseVo.ok("禁用成功!");
            }
        }
        return ResponseVo.error("更新失败!");
    }
}
