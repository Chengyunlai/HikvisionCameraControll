package top.itirfrd;

import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.ptr.IntByReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName
 * @Description
 * @Author:chengyunlai
 * @Date
 * @Version 1.0
 **/
@Component
public class VideoControl {
    private static final Logger log = LoggerFactory.getLogger(VideoControl.class);
    private static HCNetSDK instance;
    int userID;
    private HCNetSDK.NET_DVR_DEVICEINFO_V40 m_strDeviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V40();
    private HCNetSDK.NET_DVR_USER_LOGIN_INFO m_strLoginInfo = new HCNetSDK.NET_DVR_USER_LOGIN_INFO();

    public VideoControl() {
    }

    public int init(String ip, String port, String sUserName, String sPassword) {
        instance.NET_DVR_SetConnectTime(2000, 1);
        instance.NET_DVR_SetReconnect(100000, true);
        this.m_strLoginInfo.sDeviceAddress = new byte[129];
        System.arraycopy(ip.getBytes(), 0, this.m_strLoginInfo.sDeviceAddress, 0, ip.length());
        this.m_strLoginInfo.sUserName = new byte[64];
        System.arraycopy(sUserName.getBytes(), 0, this.m_strLoginInfo.sUserName, 0, sUserName.length());
        this.m_strLoginInfo.sPassword = new byte[64];
        System.arraycopy(sPassword.getBytes(), 0, this.m_strLoginInfo.sPassword, 0, sPassword.length());
        this.m_strLoginInfo.wPort = Short.parseShort(port);
        this.m_strLoginInfo.bUseAsynLogin = false;
        this.userID = instance.NET_DVR_Login_V40(this.m_strLoginInfo, this.m_strDeviceInfo);
        log.info("用户注册设备：userID = " + this.userID);
        if (this.userID < 0) {
            log.info("-----------注册设备失败-----------\n错误码为：" + instance.NET_DVR_GetLastError() + "\n错误信息：" + instance.NET_DVR_GetErrorMsg((IntByReference)null));
        } else {
            log.info("-----------注册设备成功-----------");
        }

        log.info("设备连接end,用户ID:{}", this.userID);
        return this.userID;
    }

    public void controlVedio(int userID, int code, int dwstop) {
        instance.NET_DVR_PTZControl_Other(userID, 1, code, dwstop);
    }

    static {
        String path = System.getProperty("user.dir") + "\\lib\\libhcnetsdk.so";
        log.info("===输出路径===" + path);
        if (Platform.isWindows()) {
            instance = (HCNetSDK) Native.loadLibrary(path, HCNetSDK.class);
        }

        if (!instance.NET_DVR_Init()) {
            log.info("-----------SKD初始化失败-----------");
        } else {
            log.info("-----------SKD初始化成功-----------");
        }

    }
}
