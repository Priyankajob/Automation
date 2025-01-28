package StepDefination;

import POJO.POJO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RestBDD {

   WebDriver driver = new ChromeDriver();
    int id;
    private Properties properties = new Properties();
    private Response response;

  @Given("Lets Start background")
  public void background() {
      System.out.println("Background");



  }
    @Test(priority=1)
    @Given("Load Property File")
    public void LoadProperty() {  // Changed to non-static method
        {
            try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/Config.properties")) {
                properties.load(fileInputStream);  // Load the properties file
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test(priority=2)
    @Given("Get User")
     public void getUser() {
        String baseUrl = properties.getProperty("base.uri1");
       // String url = baseUrl + "/api/users?page=2";
        String url = baseUrl + Hook.apiVersion + "/users?page=2";// Changed to non-static method
        given()
                 .when()
                .get(url)
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();


    }
    @Test(priority=3)
    @When("Create User")
    public void createUser() {

        HashMap<String,String> usr = new HashMap<>();
        usr.put("name", "morpheus");
        usr.put("job", "leader");
        // Changed to non-static method
        id =given()
                .contentType("application/json")
                .body(usr)
                .when()
                .post("https://reqres.in/api/users/")
                 .jsonPath().getInt("id");






    }
    @Test(priority=4)
  @Then("Update user")
    public void updateUser() {

        HashMap<String,String> usr = new HashMap<>();
        usr.put("name", "Priya");
        usr.put("job", "Influencer");
        // Changed to non-static method
        given()
                .contentType("application/json")
                .body(usr)
                .when()
                .put("https://reqres.in/api/users/"+id)
                .then()
                .statusCode(200)
                .log().all();



    }

    @Test(enabled=false)
    @Then("Get user by id")
    public void GetbyID() {

        HashMap<String,String> usr = new HashMap<>();
        usr.put("name", "Priya");
        usr.put("job", "Influencer");
        // Changed to non-static method
        given()
                .contentType("application/json")
                .queryParam("id",2)
                .when()
                .get("https://reqres.in/api/users/1")
                .then()
                .statusCode(200)
                .log().all();



    }
    @Test(priority=5)
    @Then("validate Json")
    public void validatejson()
    {
        response = given()
                .when()
                .get("https://reqres.in/api/users/")
                .then()
                .extract()
                      .response();






        System.out.println("Response Body: " + response.getBody().asString());
        POJO users = response.as(POJO.class);


        System.out.println("Page: " + users.getPage());
        System.out.println("First User Email: " + users.getData().get(0).getEmail());
        System.out.println("Support URL: " + users.getSupport().getUrl());

        Assert.assertEquals(users.getPage(), 1);

        // Validate the first user's email in the response
        Assert.assertEquals(users.getData().get(0).getEmail(), "george.bluth@reqres.in");

        // Validate other user details if required (e.g., first name, last name)
        Assert.assertEquals(users.getData().get(0).getfirst_name(), "George");
        Assert.assertEquals(users.getData().get(0).getlast_name(), "Bluth");
    }
    @Test(priority=6)
    @Then("Delete user")
     public void deleteuser()
    {
        given()
                .when()
                .delete("https://reqres.in/api/users/"+id)
                .then()
                .statusCode(204)
                .log().all();
    }




}