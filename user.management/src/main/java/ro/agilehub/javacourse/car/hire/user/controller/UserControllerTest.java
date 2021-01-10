//package ro.agilehub.javacourse.car.hire.user.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import ro.agilehub.javacourse.car.hire.user.mapper.UserMapper;
//import ro.agilehub.javacourse.car.hire.user.service.UserService;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
//@ActiveProfiles("integrationtest")
//class UserControllerTest {
//
//    @Autowired
//    private ObjectMapper objectMapper;
////
//    @MockBean
//    private UserService userService;
//
//    @MockBean
//    private UserMapper userDTOMapper;
//
//    @org.junit.jupiter.api.Test
//    @WithMock
//    kUser("jack")
//    public void addUser_whenInputOk_return201() throws Exception {
//        final Integer ID = 123;
//        var input = new User().email("vladcarcu@email.com");
//
//        when(userService.createNewUser(any())).thenReturn(ID);
//
//        var result = mvc.perform(post("/user")
//                .contentType("application/json")
//                .content(objectMapper.writeValueAsString(input)))
//                .andExpect(status().isCreated())
//                .andReturn();
//
//        var createdDTO = objectMapper.readValue(result.getResponse().getContentAsString(), CreatedDTO.class);
//
//        assertEquals(ID, createdDTO.getId());
//    }
//
//    private Object any() {
//    }
//}