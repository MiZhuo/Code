package fun.mizhuo.hrserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "fun.mizhuo.hrserver.mapper")
public class HrserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrserverApplication.class, args);
    }

}
