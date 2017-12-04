package com.xebia.headerbuddy.e2e;

import com.xebia.headerbuddy.controllers.HeaderBuddyController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//So the annotations won't be ignored
@RunWith(SpringRunner.class)
//Auto-configure the Spring MVC infrastructure and limit the scanned beans this is purely for the main controller(s)
@WebMvcTest(HeaderBuddyController.class)
public class HeaderBuddyControllerTest {

    //Auto injects the class for me
    @Autowired
    private MockMvc mvc;

    private final String testedUrl = "http://andonoz.com";

    //Test for checking if there is a response with the given url (tested url)
    //In any case if the response type is in json there should be a url field with the given url
    @Test
    public void HeaderBuddyControllerTest() throws Exception {
        this.mvc.perform(get("/headerbuddy/api?url="+testedUrl).accept(MediaType.APPLICATION_JSON))
                //Response is status code 200
                .andExpect(status().isOk())
                //Expected response type is json
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                //Expected url in the url field is the tested url
                .andExpect(jsonPath("$.url").value(testedUrl));
    }
}
