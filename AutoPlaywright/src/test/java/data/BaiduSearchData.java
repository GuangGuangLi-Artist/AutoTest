package data;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BaiduSearchData {

    @DataProvider(name = "searchKeywords")
    public static Object[][] provideKeywords() {
        return new Object[][] {
                {"Playwright Java"},
                {"TestNG 教程"},
                {"自动化测试"},
                {"ChatGPT"},
                {"AI 搜索引擎"}
        };

    }
    @Test
    public void testGetPayh(){
        System.out.println(System.getProperty("user.dir"));

    }

    @DataProvider(name = "csvKeywords")
    public static Object[][] provideKeywordsFromCsv() throws Exception {
        List<Object[]> data = new ArrayList<>();
        String csvPath = "src/test/resources/data/keywords.csv";
        try (
                InputStreamReader isr = new InputStreamReader(new FileInputStream(csvPath),"UTF-8");
                CSVReader reader = new CSVReader(isr)

        ) {
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null){
                data.add(new Object[]{line[0]});
            }
        }
        return data.toArray(new Object[0][0]);

    }
}
