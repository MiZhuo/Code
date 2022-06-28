package site.mizhuo.stockserver.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName TimeFeignClient
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-10-08 10:37
 * @Version 1.0
 **/
@FeignClient(name = "time-server")
public interface TimeFeignClient {

    @GetMapping("/getTime")
    public String getTime();
}
