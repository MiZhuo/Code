package site.mizhuo.seatademobank2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan({"site.mizhuo.seatademobank2.mapper"})
public class SeataDemoBank2Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataDemoBank2Application.class, args);
    }

}
