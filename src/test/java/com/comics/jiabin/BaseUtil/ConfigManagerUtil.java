package com.comics.jiabin.BaseUtil;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class ConfigManagerUtil {

    private static Properties defaultProperties = null;

    static {
        defaultProperties = new Properties();
        try {
            defaultProperties.load(new FileReader("config/default.properties"));
            File customConfigFile = new File("config/custom.properties");
            if (customConfigFile.exists()) {
                defaultProperties.load(new FileReader(customConfigFile));
            }
        } catch (IOException exception) {
            System.err.println("未找到配置文件");
        }

        if (!defaultProperties.isEmpty()) {
            for (Object key : defaultProperties.keySet()) {
                if (System.getProperty((String)key) != null) {
                    defaultProperties.setProperty((String)key, System.getProperty((String)key));
                }
            }
        }

    }

    public ConfigManagerUtil() {

    }

    public String get(String key) {
        return defaultProperties.getProperty(key);
    }

    public static void main(String[] args){

        ConfigManagerUtil config = new ConfigManagerUtil();
        String url = config.get("youth_desktop_test_base_path");
        System.out.println(url);

    }
}
