package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.request.CreateUserRequest;
import models.request.UpdateUserRequest;
import models.response.CreateUserResponse;
import org.junit.Assert;
import services.UserService;
import utils.CucumberUtils;

public class EditUserStepDefs {

    CreateUserRequest createUserRequest = new CreateUserRequest();
    UpdateUserRequest updateUserRequest = new UpdateUserRequest();
    CreateUserResponse userResponse = new CreateUserResponse();
    Response response;

    @Given("i setup data to create and edit an user:")
    public void i_setup_data_to_create_and_edit_an_user(DataTable dataTable) throws JsonProcessingException {
        createUserRequest = CucumberUtils.getObjectBody(dataTable, CreateUserRequest.class);
        System.out.println(createUserRequest);
    }

    @When("i execute the request to create and edit an user")
    public void i_execute_the_request_to_create_and_edit_an_user() {
        this.response = UserService.createUser(this.createUserRequest);
    }

    @When("i setup data to edit an user:")
    public void i_setup_data_to_edit_an_user(DataTable dataTable) throws JsonProcessingException {
        this.userResponse = CucumberUtils.getObjectBody(this.response.getBody().asString(), CreateUserResponse.class);
        this.updateUserRequest.setEmail(createUserRequest.getEmail());
        this.updateUserRequest.setName(createUserRequest.getName());
        this.updateUserRequest.setStatus(createUserRequest.getStatus());
        this.response = UserService.updateUser(this.userResponse.getId(), this.updateUserRequest);
        System.out.println(this.response.getBody().asString());
    }

    @Then("i verify if status code is {string} after edit an user")
    public void i_verify_if_status_code_is_after_edit_an_user(String statusCode) {
        Assert.assertTrue(response.statusCode() == Long.parseLong(statusCode));
    }

    @Then("i check if the {string} is correctly if an error exists after update user")
    public void i_check_if_the_is_correctly_if_an_error_exists_after_update_user(String message) {
        if(this.response.statusCode() != 200 || this.response.statusCode() != 201) {
            Assert.assertTrue(this.response.getBody().asString().contains(message));
        }
    }

}
