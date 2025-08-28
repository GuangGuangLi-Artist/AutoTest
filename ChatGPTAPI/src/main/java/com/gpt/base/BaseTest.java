
package com.gpt.base;

import org.testng.annotations.*;
import utils.YamlUtils;
import utils.DataInitUtils;

import java.util.Map;

public class BaseTest {
    public static Map<String, Object> config;

    @BeforeSuite
    public void loadConfig() {
        Map<String, Object> defaultConfig = YamlUtils.loadYaml("config.yaml");
        String env = defaultConfig.getOrDefault("env", "dev").toString();
        config = YamlUtils.loadYaml("config-" + env + ".yaml");
    }

    @BeforeMethod
    @Parameters("initSql")
    public void beforeMethod(@Optional("") String initSql) {
        if (!initSql.isEmpty()) {
            DataInitUtils.initData(initSql);
        }
    }

    @AfterMethod
    @Parameters("clearSql")
    public void afterMethod(@Optional("") String clearSql) {
        if (!clearSql.isEmpty()) {
            DataInitUtils.clearData(clearSql);
        }
    }
}
