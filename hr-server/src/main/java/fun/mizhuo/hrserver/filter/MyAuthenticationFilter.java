package fun.mizhuo.hrserver.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author: Mizhuo
 * @time: 2020/8/20 9:22 下午
 * @description: 自定义验证过滤器
 */
public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!"POST".equals(request.getMethod())) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
        if(request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)){
            //用户以Json的形式传递参数
            String username = null;
            String password = null;
            try {
                Map<String,String> map = new ObjectMapper().readValue(request.getInputStream(), Map.class);
                username = map.get("username");
                username = map.get("password");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (username == null) {
                username = "";
            }
            if (password == null) {
                password = "";
            }
            username = username.trim();
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                    username, password);
            // Allow subclasses to set the "details" property
            setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
        return super.attemptAuthentication(request, response);
    }
}
