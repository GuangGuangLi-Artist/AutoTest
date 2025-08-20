package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DataProviderUtil {


    //用数据加载器：根据文件类型自动识别并返回多组数据（List<Map>）
    public static List<Map<String, Object>> load(String filepath) {
        if (filepath.endsWith(".csv")) {
            return loadCSV(filepath);
        } else if (filepath.endsWith(".json")) {
            return List.of(loadJSON(filepath));
        } else if (filepath.endsWith(".yaml") || filepath.endsWith(".yml")) {
            return List.of(loadYAML(filepath));
        } else if (filepath.endsWith(".properties")) {
            return List.of(loadProperties(filepath));
        } else {
            throw new IllegalArgumentException("不支持的文件类型: " + filepath);
        }

    }

    public static Object[][] loadAsDataProvider(String filepath) {
        List<Map<String, Object>> dataList = load(filepath);
        Object[][] data = new Object[dataList.size()][1];
        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i);
        }
        return data;

    }

    private static List<Map<String, Object>> loadCSV(String filepath) {
        List<Map<String, Object>> dataList = new ArrayList<>();
        try (
                InputStreamReader reader = new InputStreamReader(new FileInputStream(filepath), StandardCharsets.UTF_8);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] headers = csvReader.readNext();// 读取标题
            if (headers == null) {
                throw new IllegalStateException("CSV文件为空：" + filepath);
            }

            String[] line;
            while ((line = csvReader.readNext()) != null) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    row.put(headers[i], i < line.length ? line[i] : "");
                }
                dataList.add(row);
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return dataList;
    }


    //从 JSON 文件中读取所有数据为 Map
    private static Map<String, Object> loadJSON(String filePath) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }

    // 从 YAML 文件中读取所有数据为 Map
    private static Map<String, Object> loadYAML(String filePath) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(new File(filePath), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }

    //PROPERTIES 只支持一组 Map 数据
    private static Map<String, Object> loadProperties(String filePath) {
        Properties props = new Properties();
        Map<String, Object> map = new HashMap<>();
        try (InputStream is = new FileInputStream(filePath)) {
            props.load(new InputStreamReader(is, StandardCharsets.UTF_8));
            for (String key : props.stringPropertyNames()) {
                map.put(key, props.getProperty(key));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;

    }


}
