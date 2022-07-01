package site.mizhuo.springtransaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("site.mizhuo.springtransaction.mapper")
public class SpringTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionApplication.class, args);
    }

}
