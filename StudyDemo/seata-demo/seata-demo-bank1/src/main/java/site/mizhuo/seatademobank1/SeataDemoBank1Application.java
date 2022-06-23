package site.mizhuo.seatademobank1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = {"site.mizhuo.seatademobank1.clients"})
@MapperScan({"site.mizhuo.seatademobank1.mapper"})
public class SeataDemoBank1Application {

    public static void main(String[] args) {
        SpringApplication.run(SeataDemoBank1Application.class, args);
    }

}
