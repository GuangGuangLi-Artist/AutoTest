
package com.gpt.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YamlUtils {
    public static Map<String, Object> loadYaml(String fileName) {
        Yaml yaml = new Yaml();
        InputStream in = YamlUtils.class.getClassLoader().getResourceAsStream(fileName);
        return yaml.load(in);
    }
}
