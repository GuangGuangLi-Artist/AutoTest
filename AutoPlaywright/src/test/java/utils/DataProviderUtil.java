package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
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
            //List<Map<String, Object>> jsonMapList = List.of(loadJSON(filepath));
            List<Map<String, Object>> jsonMapList = loadMultiEntryJSON(filepath);
            return jsonMapList;
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

    /**
     * 将指定 key 的 JSON 子对象包装为单条测试数据
     */
    public static Object[][] loadFromJsonKey(String filepath,String key) {
        Map<String,Object> singleCase = loadDataKey(filepath,key);
        return new Object[][]{{singleCase}};
    }


    /**
     * 加载指定 JSON 文件中指定 key 的子对象
     * @param filePath JSON 文件路径
     * @param targetKey 想要读取的 key（如 rightUser）
     * @return Map<String, Object> 子对象映射
     */
    public static Map<String,Object> loadDataKey(String filePath,String targetKey) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String,Map<String,Object>> allData = mapper.readValue(
                    new File(filePath),
                    new TypeReference<>(){});
            return allData.getOrDefault(targetKey,Collections.emptyMap());
        }catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
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

    //根据指定的key获取CSV 中第一个匹配的值
    public static String getValueFromCSVByKey(String key, String filepath) {
        List<Map<String, Object>> dataList = loadCSV(filepath);
        for (Map<String, Object> row : dataList) {
            if (row.containsKey(key)) {
                return row.get(key).toString();
            }
        }
        return null;
    }


    //从 JSON 文件中读取所有数据为 Map
    private static Map<String, Object> loadJSON(String filePath) {
        Map<String, Object> mapJson = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File(filePath));
            mapJson = mapper.convertValue(root, Map.class);
            return mapJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }

    public static List<Map<String,Object>> loadMultiEntryJSON(String filepath) {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            //读取为 Map<String, Map<String, Object>>
            Map<String,Map<String,Object>> outerMap =
                    mapper.readValue(new File(filepath), new TypeReference<>(){});
            for (Map.Entry<String,Map<String,Object>> entry : outerMap.entrySet()) {
                // 每个 entry.value 是一组用户信息
                result.add(entry.getValue());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //根据Key获取对应用户数据
    public static  Map<String, Object> getValueByJsonKey(String filePath, String keyName){
        Map<String, Object> mapJson = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File(filePath));
            if(root.has(keyName)){
                JsonNode node = root.get(keyName);
                mapJson =   mapper.convertValue(node, Map.class);
                return mapJson;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return Collections.emptyMap();
    }

    //从Json文件中根据key获取值(支持嵌套 key，如 user.name)
    public static String getValueFromJsonKey(String filepath, String key) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(new File(filepath));
            String[] parts = key.split("\\.");
            for(String part : parts) {
                if (node.has(part)) {
                    node = node.get(part);
                }else {
                    return null;
                }
            }
            return node.asText();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
