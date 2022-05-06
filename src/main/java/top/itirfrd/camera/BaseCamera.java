package top.itirfrd.camera;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import top.itirfrd.VideoControl;

/**
 * @ClassName
 * @Description
 * @Author:chengyunlai
 * @Date
 * @Version 1.0
 **/
@Component
@Data
@NoArgsConstructor
@ToString
public class BaseCamera {
    private String ip;
    private String port;
    private String username;
    private String password;
    // private VideoControl videoControl = null;

    public BaseCamera(String ip, String port, String username, String password) {
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    // public void control(int code, int style) {
    //     this.videoControl = new VideoControl();
    //     int userId = this.videoControl.init(this.getIp(), this.getPort(), this.getUsername(), this.getPassword());
    //     this.videoControl.controlVedio(userId, code, style);
    // }


}

