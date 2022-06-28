package fun.mizhuo.hrserver.mapper;

import fun.mizhuo.hrserver.model.JobLevel;

import java.util.List;

public interface JobLevelMapper {
    List<JobLevel> getAllJobTitle();

    Integer addJobTitle(JobLevel jobTitle);

    Integer updateJobTitle(JobLevel jobTitle);

    Integer deleteJobTitle(Integer id);

    Integer deleteMoreJobTitle(List<JobLevel> jobTitles);
}