package fun.mizhuo.mailserver.config;

import fun.mizhuo.hrserver.exception.HrException;
import fun.mizhuo.hrserver.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author: Mizhuo
 * @time: 2020/10/19 10:02 下午
 * @description: 消息接收者
 */
@Component
public class MailReceiver {
   private static final Logger logger = LoggerFactory.getLogger(MailReceiver.class);

   @Autowired
   JavaMailSender mailSender;

   @Autowired
   MailProperties mailProperties;

   @Autowired
   TemplateEngine templateEngine;

   @RabbitListener(queues = "mizhuo.mail")
   public void handler(Employee employee) throws HrException {
      try {
         //收到消息，发送邮件
         MimeMessage message = mailSender.createMimeMessage();
         MimeMessageHelper helper = new MimeMessageHelper(message);
         helper.setFrom(mailProperties.getUsername());
         helper.setTo(employee.getEmail());
         helper.setSubject("欢迎入职");
         //设置页面参数
         Context context = new Context();
         context.setVariable("name",employee.getName());
         context.setVariable("posName",employee.getPosId());
         context.setVariable("jobName",employee.getJobLevelId());
         context.setVariable("depName",employee.getDepartmentId());
         String mail = templateEngine.process("mail", context);
         helper.setText(mail,true);
         mailSender.send(message);
         logger.info("发送邮件成功!收件人:" + employee.getEmail());
      }catch (MessagingException e) {
         logger.error("发送邮件失败!");
         throw new HrException("发送邮件失败!",e);
      }
   }
}
