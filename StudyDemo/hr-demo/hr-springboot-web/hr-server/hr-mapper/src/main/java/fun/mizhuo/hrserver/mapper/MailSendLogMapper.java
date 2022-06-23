package fun.mizhuo.hrserver.mapper;

import fun.mizhuo.hrserver.model.MailSendLog;

public interface MailSendLogMapper {
    int insert(MailSendLog record);

    int insertSelective(MailSendLog record);
}