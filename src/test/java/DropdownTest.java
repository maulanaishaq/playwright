import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropdownTest {

    private Playwright playwright;
    private Page page;

    @BeforeClass
    public void setup(){
        this.playwright = Playwright.create();
        final Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setChannel("chrome"));
        this.page = browser.newPage();
        this.page.navigate("https://the-internet.herokuapp.com/dropdown");
    }

    @AfterClass
    public void tearDown(){
        this.playwright.close();
    }


    @Test
    public void testSelectByOption(){

        final Locator dropdownField = this.page.locator("#dropdown");

        dropdownField.selectOption("Option 2");

        final String dropdownFieldSelectValue = this.page.locator("#dropdown [selected = 'selected']").innerText();
        assertEquals(dropdownFieldSelectValue, "Option 2");
    }

    @Test
    public void testSelectLabel(){
        final Locator dropdownField = this.page.locator("#dropdown");
        dropdownField.selectOption(new SelectOption().setLabel("Option 1"));


        final String dropdownFieldSelectValue = this.page.locator("#dropdown [selected = 'selected']").innerText();
        assertEquals(dropdownFieldSelectValue, "Option 1");

    }

    @Test
    public void testSelectByIndex() {

        final Locator dropdownField = this.page.locator("#dropdown");

        dropdownField.selectOption(new SelectOption().setIndex(0));
        final String dropdownFieldSelectedValue1 = this.page.locator("#dropdown [selected='selected']").innerText();
        assertEquals(dropdownFieldSelectedValue1, "Please select an option");

        dropdownField.selectOption(new SelectOption().setIndex(1));
        final String dropdownFieldSelectedValue2 = this.page.locator("#dropdown [selected='selected']").innerText();
        assertEquals(dropdownFieldSelectedValue2, "Option 1");



        dropdownField.selectOption(new SelectOption().setIndex(2));
        final String dropdownFieldSelectedValue3 = this.page.locator("#dropdown [selected='selected']").innerText();
        assertEquals(dropdownFieldSelectedValue3, "Option 2");




    }




}
