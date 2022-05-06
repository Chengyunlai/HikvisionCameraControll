package top.itirfrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import top.itirfrd.camera.TestCamera;

@SpringBootApplication
public class VideoControllApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(VideoControllApplication.class, args);
    }
}
