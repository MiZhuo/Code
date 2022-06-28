package fun.mizhuo.genbatis;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenbatisApplication {

    public static void main(String[] args) {
        List<String> war=new ArrayList<>();
        Boolean ovr=true;
        File file=new File("src/main/resources/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(war);
        try {
            Configuration config = cp.parseConfiguration(file);
            DefaultShellCallback back = new DefaultShellCallback(ovr);
            MyBatisGenerator my = new MyBatisGenerator(config, back, war);
            my.generate(null);
            for(String s:war) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
