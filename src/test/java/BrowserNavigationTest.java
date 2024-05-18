import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BrowserNavigationTest {


    @Test
    public void goBack(){
        final Playwright playwright = Playwright.create();
        final Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(5));

        final Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com/");
        /*
        page.goBack();
        page.goBack(new Page.GoBackOptions().setTimeout(50));
        page.goBack(new Page.GoBackOptions().setWaitUntil(WaitUntilState.LOAD));
        page.goForward();
        page.goForward(new Page.GoForwardOptions().setTimeout(50));
        page.goForward(new Page.GoForwardOptions().setWaitUntil(WaitUntilState.LOAD));
        page.reload();
        page.reload(new Page.ReloadOptions().setTimeout(3));
        page.reload(new Page.ReloadOptions().setWaitUntil(WaitUntilState.LOAD));
        */
    }

    @Test
    public void testBrowserNavigation() {
        final Playwright playwright = Playwright.create();
        final Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        final Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/");

        final String homePageHeader = page.locator("h2").textContent();
        assertEquals(homePageHeader, "Available Examples");

        page.navigate("https://the-internet.herokuapp.com/challenging_dom");
        final String challengingDomPageHeader = page.locator("h3").textContent();
        assertEquals(challengingDomPageHeader, "Challenging DOM");

        page.goBack();
        assertEquals(homePageHeader, "Available Examples");

        page.goForward();
        assertEquals(challengingDomPageHeader, "Challenging DOM");

        page.reload();
        assertEquals(challengingDomPageHeader, "Challenging DOM");

        final String currentPageUrl = page.url();
        final String websiteLink = "https://the-internet.herokuapp.com/challenging_dom";
        assertEquals(currentPageUrl, websiteLink);

        browser.close();

    }



}
