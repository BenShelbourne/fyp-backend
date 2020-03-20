package org.shelbourne.ben.scc300.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import lombok.Data;
import org.shelbourne.ben.scc300.generated.controller.ApiUtil;
import org.shelbourne.ben.scc300.generated.controller.StudentApi;
import org.shelbourne.ben.scc300.generated.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Data
public class StudentController implements StudentApi {


    @ApiOperation(value = "Student Profile", nickname = "studentGet", notes = "The User Profile endpoint returns information about the student that has authorised with the application.", response = Student.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags = {"User",})
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Profile information for a student", response = Student.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class)})
    @RequestMapping(value = "/student",
        produces = {"application/json"},
        method = RequestMethod.GET)
    public ResponseEntity<Student> studentGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"last_name\" : \"last_name\", \"id\" : \"id\", \"first_name\" : \"first_name\", \"email\" : \"email\", \"picture\" : \"picture\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
