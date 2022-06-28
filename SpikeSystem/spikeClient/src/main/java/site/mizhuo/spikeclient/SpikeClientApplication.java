package site.mizhuo.spikeclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpikeClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpikeClientApplication.class, args);
    }

}
