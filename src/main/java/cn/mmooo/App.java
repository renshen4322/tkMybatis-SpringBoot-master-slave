package cn.mmooo;

import cn.mmooo.dao.UserMapper;
import lombok.extern.slf4j.Slf4j;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("cn.mmooo.dao")
//@MapperScan(basePackageClasses = UserMapper.class)
@Slf4j
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}
