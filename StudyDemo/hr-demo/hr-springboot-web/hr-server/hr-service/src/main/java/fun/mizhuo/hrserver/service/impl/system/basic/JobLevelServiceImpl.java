package fun.mizhuo.hrserver.service.impl.system.basic;

import fun.mizhuo.hrserver.mapper.JobLevelMapper;
import fun.mizhuo.hrserver.model.JobLevel;
import fun.mizhuo.hrserver.service.system.basic.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/7 10:46 下午
 * @description: 职称服务实现类
 */
@Service
public class JobLevelServiceImpl implements JobLevelService {

    @Autowired
    JobLevelMapper jobLevelMapper;

    @Override
    public List<JobLevel> getAllJobTitle() {
        return jobLevelMapper.getAllJobTitle();
    }

    @Override
    public Integer addJobTitle(JobLevel jobTitle) {
        return jobLevelMapper.addJobTitle(jobTitle);
    }

    @Override
    public Integer updateJobTitle(JobLevel jobTitle) {
        return jobLevelMapper.updateJobTitle(jobTitle);
    }

    @Override
    public Integer deleteJobTitle(Integer id) {
        return jobLevelMapper.deleteJobTitle(id);
    }

    @Override
    public Integer deleteMoreJobTitle(List<JobLevel> jobTitles) {
        return jobLevelMapper.deleteMoreJobTitle(jobTitles);
    }
}
