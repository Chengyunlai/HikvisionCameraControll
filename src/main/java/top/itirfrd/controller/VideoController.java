package top.itirfrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.itirfrd.VideoControl;
import top.itirfrd.camera.BaseCamera;


/**
 * @ClassName
 * @Description
 * @Author:chengyunlai
 * @Date
 * @Version 1.0
 **/
@RequestMapping("/controller")
@RestController
public class VideoController {
    private VideoControl videoControl;
    private Integer userId = -11;

    // static {
    //     videoControl = new VideoControl();
    // }
    @Autowired
    public VideoController(VideoControl videoControl) {
        this.videoControl = videoControl;
    }

    @PostMapping("/init")
    public void init(@RequestBody BaseCamera camera){
        userId = videoControl.init(camera.getIp(), camera.getPort(), camera.getUsername(), camera.getPassword());
        System.out.println(userId);
    }


    @GetMapping("/tapUp")
    public void tapUp(){
        this.videoControl.controlVedio(userId, 21,0);
    }

    @GetMapping("/releaseUp")
    public void releaseUp(){
        this.videoControl.controlVedio(userId, 21,1);
    }

    @GetMapping("/tapDown")
    public void tapDown(){
        this.videoControl.controlVedio(userId, 22,0);
    }

    @GetMapping("/releaseDown")
    public void upDown(){
        this.videoControl.controlVedio(userId, 22,1);
    }

    @PostMapping("/tapLeft")
    public void tapLeft(){
        this.videoControl.controlVedio(userId, 23,0);
    }

    @GetMapping("/releaseLeft")
    public void releaseLeft(){
        this.videoControl.controlVedio(userId, 23,1);
    }

    @GetMapping("/tapRight")
    public void tapRight(){
        this.videoControl.controlVedio(userId, 24,0);
    }

    @GetMapping("/releaseRight")
    public void releaseRight(){
        this.videoControl.controlVedio(userId, 24,1);
    }
}
