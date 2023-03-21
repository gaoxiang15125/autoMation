package github.gx.automation;

import github.gx.automation.util.FileUtils;
import github.gx.automation.util.SeleniumUtils;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * @program: clawerlesson
 * @description:
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2023-03-15 18:41
 **/
public class Main {
    // 理论上 cookie 交由浏览器自己管理, 直接根据路径打开网页-下载 即可

    private static String getUrl() {
        return "https://www.educative.io/courses/grokking-modern-system-design-interview-for-engineers-managers";
    }

    public static void main(String[] args) {

        WebDriver webDriver = SeleniumUtils.getInstance().getDriver();
        // 跳转指定页面, 保存页面内容
        webDriver.get(getUrl());
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String pageSource = webDriver.getPageSource();

        FileUtils.writeToFile("/book","Introduction to Load Balancers", pageSource);
        System.out.println(pageSource);
    }
}
