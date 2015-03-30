package cn.ucloud.sdk.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import cn.ucloud.sdk.enums.MsgEnum;
import cn.ucloud.sdk.exception.UcloudException;

public class LogUtil {

    private static final Logger logutil = Logger.getLogger(LogUtil.class);

    public static void exception(Class<?> clazz, Throwable e) {
        StringWriter sw = new StringWriter();
        try {
            e.printStackTrace(new PrintWriter(sw));
            if (e instanceof UcloudException) {
                logutil.warn(clazz.getName() + " occured " + e.getClass().getSimpleName() + " " + MsgEnum.getByCode(((UcloudException) e).getCode()));
            } else {
                logutil.warn(clazz.getName() + " occured " + e.getClass().getSimpleName() + " " + e.getMessage());
            }
            logutil.warn(sw.toString());
        } finally {
            try {
                sw.close();
            } catch (IOException e1) {
                logutil.error(e1);
            }
        }
    }
}
