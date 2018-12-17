package com.junda.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/applicationContext.xml",
        "classpath:spring/springmvc.xml"})
@WebAppConfiguration("src/main/resources")
public class UserControllerTest {

    private static final Logger LOG = LoggerFactory
            .getLogger(UserControllerTest.class);

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac; //4 注入WebApplicationContext

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void showUsersTest() throws Exception {

        mockMvc.perform(get("/user/list.do"))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    public void addUsersTest() throws Exception {
        String json = mockMvc.perform(post("/user/add.do")
                .param("newName", "junda.gui")
                .param("newSex", "男")
                .param("newAge", "18"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        LOG.info("json ====  {}", json);
    }

    @Test
    public void findUserTest() throws Exception {
        String json = mockMvc.perform(get("/user/find.do")
                .param("userId", "154485323263853"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        LOG.info("json ====  {}", json);
    }

    @Test
    public void updateUserTest() throws Exception {
        String json = mockMvc.perform(post("/user/update.do")
                .param("userId", "154485323263853")
                .param("newName", "junda.gui")
                .param("newSex", "男")
                .param("newAge", "18")
                .param("newStatus", "1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        LOG.info("json ====  {}", json);
    }

    @Test
    public void deleteUserTest() throws Exception {
        String json = mockMvc.perform(post("/user/delete.do")
                .param("userId", "154485323263853"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        LOG.info("json ====  {}", json);
    }

}
