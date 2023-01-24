package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PreconfigLibrary 
{
	public static WebDriver driver;
	
	@Given("^i open browser with url = \"([^\"]*)\"$")
	public void i_open_browser_with_url(String url)
	{
	   System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   driver.get(url);
	}

	@Then("^i should see login page$")
	public void i_should_see_login_page()
	{
	    if(driver.getCurrentUrl().contains("sign-in"))
	    {
	    	System.out.println("Application launched Sucessfully");
	    }else
	    {
	    	System.out.println("Application launch Failed");
	    }
	}

	@When("^i enter usrname as \"([^\"]*)\"$")
	public void i_enter_usrname_as(String uid) throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(uid);
	}
	
	@When("^i enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String pwd) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
		Thread.sleep(3000);
	}

	@When("^i click on login$")
	public void i_click_on_login() throws InterruptedException
	{
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(3000);
	}

	@Then("^i should see homepage$")
	public void i_should_see_homepage()
	{
		boolean flag = false;
		List<WebElement> tag_p = driver.findElements(By.tagName("p"));
		for(int i=0;i<tag_p.size();i++)
		{
			System.out.println(tag_p.get(i).getText());
			if(tag_p.get(i).getText().toLowerCase().contains("verticals"))
			{
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);
	}

	@When("^i click logout$")
	public void i_click_logout() throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.id("menu-button-:rh:")).click();
		driver.findElement(By.id("menu-list-:rh:-menuitem-:ri:")).click();
		Thread.sleep(2000);
	}

	@When("^i close browser$")
	public void i_close_browser()
	{
		driver.close();
	}
	@When("^i click on add vertical$")
	public void i_click_on_add_vertical()
	{
		driver.findElement(By.xpath("//button[contains(@class,'css-1zb9ui')]")).click();
	}

	@When("^i enter vertical name \"([^\"]*)\"$")
	public void i_enter_vertical_name(String vname)
	{
		driver.findElement(By.id("vertical__name")).sendKeys(vname);
	}

	@When("^i enter short text \"([^\"]*)\"$")
	public void i_enter_short_text(String short_text) 
	{
		driver.findElement(By.id("vertical__shortText")).sendKeys(short_text);
	}

	@When("^i enter description \"([^\"]*)\"$")
	public void i_enter_description(String desc) 
	{
		driver.findElement(By.id("vertical__description")).sendKeys(desc);
	}

	@When("^i select time range and click save \"([^\"]*)\"$")
	public void i_select_time_range_and_click_save(String range) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='vertical__range']/div/div[1]/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("react-select-2-input")).sendKeys(range);
		driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[@type ='submit']")).click();
		Thread.sleep(3000);
	}

	@Then("^i should see new vertical \"([^\"]*)\"$")
	public void i_should_see_new_vertical(String verticalName) throws InterruptedException 
	{
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(verticalName);
		boolean flag = false;
		List<WebElement> v_name = driver.findElements(By.xpath("//*[@role='row']"));
		for(int i =0;i<v_name.size();i++)
		{
			if(v_name.get(i).getText().contains(verticalName))
			{
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);	
	}
	
	@When("^i click on edit vertical \"([^\"]*)\"$")
	public void i_click_on_edit_vertical(String verticalname) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(verticalname);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button//i[@class='fas fa-pen']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}

	@When("^i enter new vertical name \"([^\"]*)\"$")
	public void i_enter_new_vertical_name(String verticalName1) throws Throwable 
	{
		Thread.sleep(3000);
		WebElement vname = driver.findElement(By.id("vertical__name"));
		String s1 = Keys.chord(Keys.CONTROL, "a");
		vname.sendKeys(s1);
		vname.sendKeys(Keys.DELETE);
		vname.sendKeys(verticalName1);
	}

	@When("^i enter new short text \"([^\"]*)\"$")
	public void i_enter_new_short_text(String short_text) throws Throwable 
	{
		WebElement s_text = driver.findElement(By.id("vertical__shortText"));
		String s2 = Keys.chord(Keys.CONTROL, "a");
		s_text.sendKeys(s2);
		s_text.sendKeys(Keys.DELETE);
		s_text.sendKeys(short_text);
	}

	@When("^i enter new description \"([^\"]*)\"$")
	public void i_enter_new_description(String vdesc)
	{
		WebElement desc = driver.findElement(By.id("vertical__description"));
		String s3 = Keys.chord(Keys.CONTROL, "a");
		desc.sendKeys(s3);
		desc.sendKeys(Keys.DELETE);
		desc.sendKeys(vdesc);
	}

	@When("^i select time ranges and click save$")
	public void i_select_time_ranges_and_click_save() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id("react-select-2-input")).sendKeys("Hour");
		driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);
		
		Select value_range = new Select(driver.findElement(By.id("feature__value")));
		Thread.sleep(2000);
		value_range.selectByVisibleText("MONTHLY");
		Thread.sleep(2000);
		
		Select data_range = new Select(driver.findElement(By.id("feature__dataRange")));
		Thread.sleep(2000);
		data_range.selectByVisibleText("MONTHLY");
		Thread.sleep(2000);
		
		Select trend_range = new Select(driver.findElement(By.id("feature__trend")));
		Thread.sleep(2000);
		trend_range.selectByVisibleText("MONTHLY");
		Thread.sleep(2000);
		
		Select context_range = new Select(driver.findElement(By.id("feature__context")));
		Thread.sleep(2000);
		context_range.selectByVisibleText("MONTHLY");
		Thread.sleep(2000);
		
		Select contributors_range = new Select(driver.findElement(By.id("feature__contributors")));
		Thread.sleep(2000);
		contributors_range.selectByVisibleText("MONTHLY");
		Thread.sleep(2000);
		
		Select actions_range = new Select(driver.findElement(By.id("feature__recommended_actions")));
		Thread.sleep(2000);
		actions_range.selectByVisibleText("MONTHLY");
		Thread.sleep(2000);
		
		Select predictions_range = new Select(driver.findElement(By.id("feature__prediction")));
		Thread.sleep(2000);
		predictions_range.selectByVisibleText("MONTHLY");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@type ='submit']")).click();
	}

	@Then("^i should see modified vertical \"([^\"]*)\"$")
	public void i_should_see_modified_vertical(String verticalName) throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(verticalName);
		boolean flag = false;
		List<WebElement> v_name = driver.findElements(By.xpath("//*[@role='row']"));
		for(int i =0;i<v_name.size();i++)
		{
			if(v_name.get(i).getText().contains(verticalName))
			{
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);
	}
	@When("^i click on delete vertical \"([^\"]*)\"$")
	public void i_click_on_delete_vertical(String verticalName) throws InterruptedException
	{
			
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(verticalName);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button//i[@class='fas fa-trash']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}

	@Then("^i should see the vertical deleted \"([^\"]*)\"$")
	public void i_should_see_the_vertical_deleted(String verticalName) throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(verticalName);
		boolean flag = false;
		List<WebElement> v_name = driver.findElements(By.xpath("//*[@role='row']"));
		for(int i =0;i<v_name.size();i++)
		{
			if(v_name.get(i).getText().contains(verticalName))
			{
				flag = true;
				break;
			}
		}
		Assert.assertFalse(flag);
		driver.navigate().refresh();
	}
	@When("^i enter function name \"([^\"]*)\"$")
	public void i_enter_function_name(String fun_name)
	{
		driver.findElement(By.xpath("//a[@href='/app/functions']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'css-1zb9ui')]")).click();
		driver.findElement(By.id("function__name")).sendKeys(fun_name);
	}

	@When("^i enter function short text \"([^\"]*)\"$")
	public void i_enter_function_short_text(String fun_short_text)
	{
		driver.findElement(By.id("function__shortText")).sendKeys(fun_short_text);
	}

	@When("^i enter function description \"([^\"]*)\"$")
	public void i_enter_function_description(String fun_desc)
	{
		driver.findElement(By.id("function__description")).sendKeys(fun_desc);
	}

	@When("^i click on save function$")
	public void i_click_on_save_function()
	{
		driver.findElement(By.xpath("//button[@type ='submit']")).click();
		driver.navigate().refresh();
	}

	@Then("^i should see new function \"([^\"]*)\"$")
	public void i_should_see_new_function(String fun_name) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(fun_name);
		boolean flag = false;
		List<WebElement> v_name = driver.findElements(By.xpath("//*[@role='row']"));
		for(int i =0;i<v_name.size();i++)
		{
			if(v_name.get(i).getText().contains(fun_name))
			{
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);
	}
	@When("^i click on edit function \"([^\"]*)\"$")
	public void i_click_on_edit_function(String function_name) throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@href='/app/functions']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(function_name);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button//i[@class='fas fa-pen']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	@When("^i enter new function name \"([^\"]*)\"$")
	public void i_enter_new_function_name(String fun_Name)
	{
		WebElement fname = driver.findElement(By.id("function__name"));
		String s1 = Keys.chord(Keys.CONTROL, "a");
		fname.sendKeys(s1);
		fname.sendKeys(Keys.DELETE);
		fname.sendKeys(fun_Name);
	}
	@When("^i enter new function short text \"([^\"]*)\"$")
	public void i_enter_new_function_short_text(String fun_Short_Text)
	{
		WebElement shorttext = driver.findElement(By.id("function__shortText"));
		String s2 = Keys.chord(Keys.CONTROL, "a");
		shorttext.sendKeys(s2);
		shorttext.sendKeys(Keys.DELETE);
		shorttext.sendKeys(fun_Short_Text);
	}
	@When("^i enter new function description \"([^\"]*)\"$")
	public void i_enter_new_function_description(String fun_desc)
	{
		WebElement f_desc = driver.findElement(By.id("function__description"));
		String s3 = Keys.chord(Keys.CONTROL, "a");
		f_desc.sendKeys(s3);
		f_desc.sendKeys(Keys.DELETE);
		f_desc.sendKeys(fun_desc);
	}

	@When("^i click save new function$")
	public void i_click_save_new_function()
	{
		driver.findElement(By.xpath("//button[@type ='submit']")).click();
		driver.navigate().refresh();
	}
	@Then("^i should see modified function \"([^\"]*)\"$")
	public void i_should_see_modified_function(String function_Name) throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(function_Name);
		boolean flag = false;
		List<WebElement> v_name = driver.findElements(By.xpath("//*[@role='row']"));
		for(int i =0;i<v_name.size();i++)
		{
			if(v_name.get(i).getText().contains(function_Name))
			{
				flag = true;
				break;
			}
		}
		Assert.assertTrue(flag);
	}
}
