package com.course.code.seleniumLearn;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumFindElement {

    String path = System.getProperty("user.dir");
    String driverPath = path + "\\src\\main\\java\\com\\course\\code\\utils\\drivers\\chromedriver.exe";
    String URL_test = "https://liushilive.github.io/html_example/index.html";


    @Test
    public void testFindByCss() {
        System.setProperty("webdriver.chrome.driver", "F:/ideaWorkspace/AutoTest/WebAutoTest/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://liushilive.github.io/html_example/index.html");
        driver.close();
    }

    /**
     * 隐式等待 隐式等待的理解，就是我们通过代码设置一个等待时间，如果在这个等待时间内，网页加载完成后就执行下一步，否则一直等待到时间截止。
     * driver.manage.timeouts.implicitlyWait(long time, TimeUtil unit);
     * 显式等待 显示等待是等待指定元素设置的等待时间，在设置时间内，默认每隔0.5s检测一次当前的页面这个元素是否存在，如果在规定的时间内找到了元素
     * 则执行相关操作，如果超过设置时间检测不到则抛出异常。默认抛出异常为：NoSuchElementException。推荐使用显示等待。
     * WebDriberWait wait = new WebDriverWait(dirver, timeOutInSeconds);
     * wait.nutil(expectCondition);
     */


    @Test
    public void testWaitDunction() {//隐式等待
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        //隐式等待
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://liushilive.github.io/html_example/index.html");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.xpath("//div[@id='D1']/div"));
        String string = element.getText();
        Assert.assertEquals(string, "我出来啦");
        driver.close();

    }

    @Test
    public void testWaitShow() {//显示等待
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.get("https://liushilive.github.io/html_example/index.html");
        driver.manage().window().maximize();
        WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='D1']/div")));
        String text = until.getText();
        Assert.assertEquals(text, "我出来啦");
        driver.close();

    }

    @Test
    public void testFindElement() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(URL_test);
        driver.manage().window().maximize();
        driver.findElement(By.id("uid")).sendKeys("liguang");
        driver.findElement(By.id("pwd")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.close();


    }

    @Test
    public void testSelected() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(URL_test);
        driver.manage().window().maximize();

        //下拉框定位
        WebElement selectId = driver.findElement(By.id("s1Id"));
        Select select = new Select(selectId);
        // 获取所有的下拉值
        List<WebElement> options = select.getOptions();

        // 按照下拉索引选择值
        select.selectByIndex(2);
        Thread.sleep(5000);
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        WebElement selectIdDra = driver.findElement(By.id("s3Id"));
        Select selectDra = new Select(selectIdDra);
        selectDra.selectByIndex(4);
        Thread.sleep(5000);
        driver.close();


    }

    //弹出框
    @Test
    public void testAlert() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(URL_test);
        driver.manage().window().maximize();
        //弹出框
        WebElement alertId1 = driver.findElement(By.id("b1"));
        alertId1.click();
        Alert alert = driver.switchTo().alert();
        //获取弹出框内容
        String alertText = alert.getText();
        Thread.sleep(5000);
        System.out.println(alertText);
        Assert.assertEquals(alertText, "有警告?");
        //接受弹出框
        alert.accept();

        // 弹出提问框
        WebElement alertId2 = driver.findElement(By.id("b2"));
        alertId2.click();
        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(5000);
        alert2.sendKeys("liguang");
        alert2.accept();

        // 弹出模态框
        WebElement alertId3 = driver.findElement(By.id("b3"));
        alertId3.click();
        Thread.sleep(5000);
        WebElement motaiInput = driver.findElement(By.id("basic-addon1"));
        motaiInput.sendKeys("模态框");
        WebElement alertId5 = driver.findElement(By.id("b5"));
        alertId5.click();
        Thread.sleep(5000);

        driver.close();


    }

    //双击元素
    @Test
    public void doubleClick() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(URL_test);
        driver.manage().window().maximize();

        //双击  鼠标Actions 方法
        WebElement doubleClick = driver.findElement(By.id("dblclick"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick);
        actions.perform();
        Thread.sleep(5000);
        driver.close();

    }

    //悬浮 - 多级下拉菜单

    @Test
    public void testXuanfu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(URL_test);
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        //定位到  悬浮多级下拉菜单
        WebElement menu = driver.findElement(By.xpath("//ul[@id='menu']/li"));
        //跳转到第一层
        actions.moveToElement(menu).perform();
        //等待第二级出现
        WebElement menu_gpu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='menu']/li/ul/li[1]/a")));
        //跳转到第二层
        actions.moveToElement(menu_gpu).perform();

        //等待第三层出现并点击
        WebElement xuanfu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='menu']/li/ul/li[1]/ul[1]/li[2]/a")));
        actions.moveToElement(xuanfu).click().perform();
        driver.close();

    }

    @Test
    public void testSlideBlock() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(URL_test);
        driver.manage().window().maximize();
//        Actions actions = new Actions(driver);
//        WebDriverWait wait = new WebDriverWait(driver, 60);
//        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@id='drag']/div[3]")));
//
//        actions.clickAndHold(menu)
//                .moveByOffset(2400,0)
//                .release()
//                .perform();


        //将页面拖动到最下方
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(100,450);");
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement menu = driver.findElement(By.xpath("//p[@id='drag']/div[3]"));
        js.executeScript(
                "var slider = arguments[0];" +
                        "slider.style.left = '250px';", // 直接修改 CSS left 属性
                menu
        );

        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mousemove', {clientX: 250}));", menu);

        WebElement rightElement = driver.findElement(By.xpath("//p[@id='drag']/div[3]"));
        String menuValue = rightElement.getAttribute("style");
        System.out.println(menuValue);

        // 截图验证
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("slidercreenshot.png"));

        driver.close();
    }


    //切换iframe

    @Test
    public void testChangeIframe() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(URL_test);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        WebElement frame1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@name='frame1']")));
        WebElement frame2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@name='frame2']")));

        //切到第二个frame
        driver.switchTo().frame(frame2);
        WebElement untiled = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='settings']/table/tbody/tr[1]")));
        System.out.println(untiled.getText());
        driver.close();


    }
    //浏览器导航操作
    @Test
    public void testNavigation() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get(URL_test);
        WebElement advanceUrl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='nav-item'][3]/a")));
        advanceUrl.click();

        // 2. 获取所有窗口句柄并切换到第二个标签页
        String originalWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }



        driver.close();


    }


    //使用javaScript 操作日期控件 更新日期
    @Test
    public void testDateAdd() throws IOException {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://liushilive.github.io/html_example/index1.html#");
        WebElement today = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='today']")));

//        ((JavascriptExecutor) driver).executeScript("window.scrollTo({x: 0, y: document.body.scrollHeight, behavior: 'smooth'});");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(100,4500)");

//        today.sendKeys("2018-01-02");
//        today.sendKeys("2018-01-02");

        //添加javaScript操作
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "document.getElementsByClassName('today').value=2011-01-02";
        js.executeScript(script);

        //截图
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("date.png"));

        driver.close();


    }

    //css定位元素

    /**
     * id选择器，通过id属性定位
     *      driver.find_element_by_css_selector(‘#su’)
     * class选择器，通过class属性定位
     *      driver.find_element_by_css_selector(‘.bg s_btn’)
     * 元素选择器，通过元素定位
     *      driver.find_element_by_css_selector(‘input’)
     * 属性选择器，通过属性定位
     *      driver.find_element_by_css_selector(‘[name='ie']’)
     * 层级选择器，用空格或者大于号表示层级关系
     *      driver.find_element_by_css_selector(‘div > [name='ie']’)
     * css延伸
     *      input[type^=’P’]  找一个input元素，type属性的值以P开头
     *      input[type$=’d’]  找一个input元素，type属性的值以d结尾
     *      input[type*=’w’]  找一个input元素，type属性的值包含w
     */
    @Test
    public void testCssById() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
        driver.get("https://liushilive.github.io/html_example/index1.html#");
        WebElement uidElement = wait.until(ExpectedConditions.elementToBeClickable(new By.ByCssSelector("input#uid")));//id选择器，通过id属性定位
        uidElement.sendKeys("test");
        WebElement passElement = wait.until(ExpectedConditions.elementToBeClickable(new By.ByCssSelector("[name=password]")));//属性选择器，通过属性定位
        passElement.sendKeys("123");

        WebElement checkBox = wait.until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector("input[value='cv2']")));//属性值选择器
        checkBox.click();

        File su = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(su,new File("submit.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.close();


    }






}
