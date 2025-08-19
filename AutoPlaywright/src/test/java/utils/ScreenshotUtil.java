package utils;

import com.microsoft.playwright.Page;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtil {
    public static byte[] captureScreenshot(Page page, String fileName) {
        Path path = Paths.get("screenshots",fileName);
        page.screenshot(new Page.ScreenshotOptions().setPath(path).setFullPage(true));
        try {
            return Files.readAllBytes(path);
        }catch (IOException e){
            throw new RuntimeException("无法读取截图文件: " + path, e);
        }
    }
}
