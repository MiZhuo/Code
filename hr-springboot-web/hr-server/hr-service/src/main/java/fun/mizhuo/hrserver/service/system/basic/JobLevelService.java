package fun.mizhuo.hrserver.service.system.basic;

import fun.mizhuo.hrserver.model.JobLevel;

import java.util.List;

/**
 * @author: Mizhuo
 * @time: 2020/9/7 22:45 下午
 * @description: 职称服务接口类
 */
public interface JobLevelService {

    /**
     * 获取职位信息
     * @return
     */
    List<JobLevel> getAllJobTitle();

    Integer addJobTitle(JobLevel jobTitle);

    Integer updateJobTitle(JobLevel jobTitle);

    Integer deleteJobTitle(Integer id);

    Integer deleteMoreJobTitle(List<JobLevel> jobTitles);
}
