package step_definition;

import base_class.Base_class_cucu;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pom_package_page1.Page;

public class Step_Search extends Base_class_cucu{
	
Page obj;
	
	
	@Given("Open web browser")
	public void open_web_browser() {
		open_browser();
	   
	}

	@Then("User must be on the amazon home page by clicking URL")
	public void user_must_be_on_the_amazon_home_page_by_clicking_url() {
		initiate();
	    
	}
//SF_TC_65_Relevant product
	@Given("Enter valid product on the home page and search")
	public void enter_valid_product_on_the_home_page_and_search() {
		obj=new Page();
	   obj.searching(prop.getProperty("productname"));
	   
	}

	
	@Then("read the name of product and compare with name of product searched")
	public void read_the_name_of_product_and_compare_with_name_of_product_searched() throws InterruptedException {
	obj.relevant_product();
	}
	
//SF_TC_61_Description Text
	@Given("Enter Valid description of the product on home page and search")
	public void enter_valid_description_of_the_product_on_home_page_and_search() {
		obj=new Page();
		   obj.searching(prop.getProperty("productdescription"));
	
	}

	@Then("Compare the actual and expected description")
	public void compare_the_actual_and_expected_description() throws InterruptedException {
		obj.get_text();
	 
	}
//SF_TC_66_Product image
	@Then("Check the products displayed are with images")
	public void check_the_products_displayed_are_with_images() throws InterruptedException {
	 obj.img();
	}
//SF_TC_68_Product price
	@Then("Check the products displayed are with prices")
	public void check_the_products_displayed_are_with_prices() throws InterruptedException {
	   obj.price();
	}
	@After
	public void close_the_browser() {
		driver.quit();

}
}
