package top.itirfrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import top.itirfrd.camera.TestCamera;

@SpringBootApplication
public class VideoControllApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(VideoControllApplication.class, args);
        // TestCamera testCamera = new TestCamera("172.18.45.103", "23838", "admin", "1234qwer");
        TestCamera bean = run.getBean(TestCamera.class);
        bean.setIp("172.18.45.103");
        bean.setPort("23838");
        bean.setUsername("admin");
        bean.setPassword("1234qwer");
        bean.control(24,0);
    }

}
