package com.zhuanget.estest.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class DownloadUtil {
    public static boolean downloadPicToLocal(String strUrl, String user) {
        boolean success = false;
        Random random = new Random();
        String fileName = System.currentTimeMillis() + "_" +(random.nextInt(89) + 10) + ".jpg";
        String path = "E:/jianshu/pics/" + user + "/";
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        InputStream is = null;
        try {
            URL url = new URL(strUrl);
            is = url.openStream();
            Files.copy(is, Paths.get(path, fileName));
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }
}
