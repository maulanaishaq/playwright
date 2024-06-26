import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PlaywrightDemoTest {




    @Test
    public void testOnChromeHeadless(){
        final Playwright playwright = Playwright.create();
        final Browser browser = playwright.chromium().launch();
        final Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com");
        final String pageTitle = page.title();
        assertEquals(pageTitle, "Swag Labs");
        browser.close();
    }

    @Test
    public void testOnChrome()  {
        final Playwright playwright = Playwright.create();
        final Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome"));
        final Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com");
        final String pageTitle = page.title();

        assertEquals(pageTitle, "Swag Labs");
        browser.close();

    }


    @Test
    public void testOnFirefoxHeadless()  {
        final Playwright playwright = Playwright.create();
        final Browser browser = playwright.firefox().launch();
        final Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com");
        final String pageTitle = page.title();
        assertEquals(pageTitle, "Swag Labs");
        browser.close();

    }

    @Test
    public void testOnFirefox() throws InterruptedException {
        final Playwright playwright = Playwright.create();
        final Browser browser = playwright.firefox()
                .launch(new BrowserType
                        .LaunchOptions()
                        .setHeadless(false));

        final Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com");
        Thread.sleep(5000);

        final String pageTitle = page.title();
        assertEquals(pageTitle, "Swag Labs");
        browser.close();

    }


    @Test
    public void testOnEdge(){
        final Playwright playwright = Playwright.create();
        final Browser browser = playwright.chromium()
                .launch(new BrowserType
                        .LaunchOptions()
                        .setHeadless(false));

        final Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com");


        final String pageTitle = page.title();
        assertEquals(pageTitle, "Swag Labs");
        browser.close();
    }

    @Test
    public void testOnChromeSlowMo()  {
        final Playwright playwright = Playwright.create();
        final Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
                        .setSlowMo(5000));

        final Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com");
        final String pageTitle = page.title();

        assertEquals(pageTitle, "Swag Labs");
        browser.close();

    }



}
