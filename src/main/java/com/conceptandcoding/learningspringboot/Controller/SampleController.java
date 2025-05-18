package com.conceptandcoding.learningspringboot.Controller;

import com.conceptandcoding.learningspringboot.Entity.User;
import org.springframework.beans.factory.parsing.PassThroughSourceExtractor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class SampleController {

    @GetMapping(path = "/fetchuser")
    public String getUserDetails(){
        return "Fetching and returning user details...";
    }

    @PostMapping(path = "/saveuser")
    public String saveUserDetails(){
        return "Successfully saved the user details!";
    }

    @GetMapping(path = "/fetchparamuser")
    public String getParamUser(@RequestParam(value = "firstName") String firstName,
                               @RequestParam(value = "lastName", required = false) String lastName){

        return "Fetched user details of " + firstName + " " + lastName;
    }

    @PostMapping(path = "/saveuserentity")
    public String saveUserDetailsEntity(@RequestBody User user){
        return "User created " + user.getUsername() + " : " + user.getEmail();
    }

    @GetMapping(path = "/fetchuserresponse" )
    public ResponseEntity<String> fetchUserdetails(@RequestParam(value = "firstName") String firstname){
        String output = "Fetched User details of " + firstname;
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}
