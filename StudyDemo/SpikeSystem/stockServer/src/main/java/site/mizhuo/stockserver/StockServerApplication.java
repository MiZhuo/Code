package site.mizhuo.stockserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mizhuo
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class StockServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockServerApplication.class, args);
    }

}
