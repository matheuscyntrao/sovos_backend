package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.request.CreateUserRequest;
import org.junit.Assert;
import services.UserService;
import utils.CucumberUtils;

public class CreateUserStepDefinitions {

    CreateUserRequest user = new CreateUserRequest();
    Response response;

    @Given("i setup data to create an user:")
    public void i_setup_data_to_create_an_user(DataTable dataTable) throws JsonProcessingException {
        user = CucumberUtils.getObjectBody(dataTable, CreateUserRequest.class);
        System.out.println(user);
    }

    @When("i execute the request to create an user")
    public void i_execute_the_request() {
        this.response = UserService.createUser(this.user);
    }

    @Then("i verify if status code is {string} after create an user")
    public void i_verify_if_status_code_is_after_create_an_user(String statusCode) {
        Assert.assertTrue(response.statusCode() == Long.parseLong(statusCode));
    }

    @Then("i check if the {string} is correctly if an error exists after create an user")
    public void i_check_if_the_is_correctly_if_an_error_exists_after_create_an_user(String message) {
        if(this.response.statusCode() != 200 || this.response.statusCode() != 201) {
            this.response.getBody().asString().contains(message);
        }
    }

}
