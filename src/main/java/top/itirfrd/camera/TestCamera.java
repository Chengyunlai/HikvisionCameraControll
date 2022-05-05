package top.itirfrd.camera;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName
 * @Description
 * @Author:chengyunlai
 * @Date
 * @Version 1.0
 **/
@Component
@NoArgsConstructor
public class TestCamera extends BaseCamera{
    public TestCamera(String ip,String port,String username,String password){
        super(ip,port,username,password);
    }
}
