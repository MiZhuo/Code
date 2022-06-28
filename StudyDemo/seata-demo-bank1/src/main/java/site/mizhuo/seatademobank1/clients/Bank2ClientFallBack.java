package site.mizhuo.seatademobank1.clients;

import org.springframework.stereotype.Component;

/**
 * @author: Mizhuo
 * @time: 2021/3/29 10:50 下午
 * @description:
 */
@Component
public class Bank2ClientFallBack implements Bank2Client {
    @Override
    public String transfer(double amount) {
        return "fallBack";
    }
}
