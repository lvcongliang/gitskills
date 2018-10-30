package com.imooc.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenUploadSuccess() throws Exception {
        String content=mockMvc.perform(MockMvcRequestBuilders.fileUpload("/fileupload")
        .file(new MockMultipartFile("file","test.txt","multipart/form-data","hello upload".getBytes("UTF-8"))))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println("filePath"+content);
    }

    @Test
    public void whenQuerySuccess() throws Exception {
         String result=mockMvc.perform(MockMvcRequestBuilders.get("/user")
                 .param("username","jojo")
                 .param("age","22")
//                 .param("page","3")
//                 .param("size","15")
//                 .param("sort","age,desc")
                 .contentType(MediaType.APPLICATION_JSON_UTF8))
                 .andExpect(MockMvcResultMatchers.status().isOk())
                 .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                 .andReturn().getResponse().getContentAsString();

        System.out.println("result:"+result);
    }

    @Test
    public void whenGenInfoSuccess() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
//        .contentType(MediaType.APPLICATION_JSON_UTF8)
//        ).andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tom"));

        String result=mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn().getResponse().getContentAsString();
        System.out.println("result2:"+result);
    }

    @Test
    public void whenCreateSuccess() throws Exception {
        Date date=new Date();
        String content="{\"username\":\"tom\",\"password\":null,\"birthday\":"+date.getTime()+"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
        .contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    public void whenUpdateSuccess() throws Exception {
        Date date=new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        String content="{\"id\":\"21\",\"username\":\"tom\",\"password\":null,\"birthday\":"+date.getTime()+"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    public void whenDeleteSuccess() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
        .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
