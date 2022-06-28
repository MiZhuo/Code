package fun.mizhuo.hrserver;

import com.wf.captcha.ArithmeticCaptcha;
import fun.mizhuo.hrserver.model.Employee;
import fun.mizhuo.hrserver.service.employee.basic.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class HrserverApplicationTests {

    @Test
    void contextLoads() throws ParseException {
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date begin=dfs.parse("2022-01-02");

        java.util.Date end = dfs.parse("2022-12-26");

        long between=(end.getTime()-begin.getTime())/ (1000 * 60 * 60 *24);//除以1000是为了转换成秒

        System.out.println(between * 1.00 / 365);
    }

    @Autowired
    EmployeeService employeeService;

    @Test
    void test2() {
        List<?> employees = employeeService.getAllEmp();
        Class clazz = employees.get(0).getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if( Modifier.isStatic(fields[i].getModifiers())) {
                continue;
            }
            fun.mizhuo.hrserver.anno.Field annotation = fields[i].getAnnotation(fun.mizhuo.hrserver.anno.Field.class);
            System.out.println(annotation.value());
        }
    }

    @Test
    void test3() throws IllegalAccessException {
        Employee employee = new Employee();
        employee.setWorkState("111");
        employee.setId(222);
        employee.setAddress("dsadda");
        Class clazz = employee.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if( Modifier.isStatic(fields[i].getModifiers())) {
                continue;
            }
            fun.mizhuo.hrserver.anno.Field annotation = fields[i].getAnnotation(fun.mizhuo.hrserver.anno.Field.class);
            fields[i].setAccessible(true);
            System.out.println(annotation.value());
            System.out.println(fields[i].get(employee));
            System.out.println(fields[i].getType());
        }
    }

    @Test
    void test4(){
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(100,30);
        // 几位数运算，默认是两位
        captcha.setLen(3);
        // 获取运算的公式：3+2=?
        captcha.getArithmeticString();
        // 获取运算的结果：5
        String result = captcha.text();
        // 输出验证码
        Map<String,Object> imgResult = new HashMap<String,Object>(2){{
            put("img", captcha.toBase64());
        }};
        System.out.println(imgResult);
    }

}
