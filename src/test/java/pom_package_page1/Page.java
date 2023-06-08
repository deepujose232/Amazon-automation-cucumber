package pom_package_page1;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import base_class.Base_class_cucu;


public class Page extends Base_class_cucu  {

	@FindBy(xpath="//input[@id='twotabsearchtextbox']") WebElement search;
	@FindBy(xpath="//input[@id='nav-search-submit-button']")WebElement searchbtn;
	//List-"total_count" is for storing description of all the products displayed
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal' or @class='a-size-base-plus a-color-base a-text-normal']")List<WebElement> total_count;
	//List-"image" is for storing all the products with image
	@FindBy(xpath="//img[contains(@src,'.jpg') and @class='s-image']") List<WebElement> image;
	//List-"image" is for storing all the products with price
	@FindBy(xpath="//span[@class='a-price-whole']") List<WebElement> price;
	
	public Page () {
			PageFactory.initElements(driver,this);
}
	
	public void searching(String name)  {
		
		search.sendKeys(name);
		searchbtn.click();
}
	
	public void get_text() throws InterruptedException {
		
		String des=prop.getProperty("productdescription");
		int j=0;
		//using for loop and equalsignorecase method, we compare the web element with the product description-
		//till the matching found
		for(WebElement i:total_count) {
			j++;
			
			if (des.equalsIgnoreCase(i.getText())) {
				System.out.println("Product with matching description found--> "+(i.getText()));
				i.click();
				screenshots("SF_TC_61_Description Text");
				break;
			}
			else 
			{
				if(j==total_count.size()) {
					System.out.println("Product with matching description not found");		
					}
				}
		}
}
	
public void relevant_product() throws InterruptedException {
	
	//using for loop and contains method, we compare the web element with the product name to confirm that product name-
	//is displayed in all products
	String product = (prop.getProperty("productname")).toLowerCase();
	int j = 0;
	int counter=0;
	for (WebElement i : total_count) {
		j++;
		String actual = i.getText().toLowerCase();
		//System.out.println(actual);	
		//System.out.println("**************************");
		if (actual.contains(product)) {
			if (j == total_count.size()) {
				//System.out.println(j);
			}
		}		
			else {
			counter++;	
			js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,1000)");
			js.executeScript("arguments[0].scrollIntoView(true);",i);
			Thread.sleep(1000);
			screenshots("SF_TC_65_Relevant product_"+counter);
			
				}
	}
	if(counter==0) {
		System.out.println("All Products with relevant information is displayed");
	}
	else {
		System.out.println("Not All Products with relevant information are displayed");
		System.out.println("No of products with irrelevant information are "+counter);
		Assert.assertEquals(true, false);
	}
}

public void img() throws InterruptedException {
	int counter=0;
	//Using for loop and isDisplayed method we are checking images are displayed for all products
	for(WebElement i : image) {
		if(i.isDisplayed())
		{
		
		
	}
		else {
			counter++;
			Thread.sleep(2000);
			js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,1000)");
			js.executeScript("arguments[0].scrollIntoView(true);",i);
			Thread.sleep(1000);
			screenshots("SF_TC_66_Product image_"+counter);
			
		}
	}
	if(counter==0) {
		System.out.println("All products are displayed with images");
	}
	else {
		System.out.println("No of products without images are "+counter);
		Assert.assertEquals(true,false );
	}
	
	
}

public void price() throws InterruptedException {
	//Using for loop and isDisplayed method we are checking prices are displayed for all products	
	int counter=0;
	for(WebElement i : price) {
		if(i.isDisplayed())
		{
		
		}
		else {
			counter++;
			Thread.sleep(2000);
			js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,1000)");
			js.executeScript("arguments[0].scrollIntoView(true);",i);
			screenshots("SF_TC_68_Product price_"+counter);
					
				}
	}
	if(counter==0) {
		System.out.println("All products are displayed with prices");
		
	}
	else {
		System.out.println("No of products without price are "+counter);
		Assert.assertEquals(true,false );
	}
	}

}
	