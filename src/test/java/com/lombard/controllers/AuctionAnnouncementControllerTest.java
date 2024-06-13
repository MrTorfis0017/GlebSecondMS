package com.lombard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lombard.dtos.AuctionAnnouncementDto;
import com.lombard.services.AuctionAnnouncementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AuctionAnnouncementController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class AuctionAnnouncementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuctionAnnouncementService auctionAnnouncementService;

    @Test
    public void createAuctionAnnouncementTest() throws Exception {
        AuctionAnnouncementDto expectedResult = AuctionAnnouncementDto.builder()
                .id(1L)
                .description("Some desc")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(expectedResult);
        when(auctionAnnouncementService.createAuctionAnnouncement(any())).thenReturn(expectedResult);
        ResultActions resultActions = mockMvc.perform(post("/lombard/site/auction/create").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
        assertEquals(objectMapper.writeValueAsString(expectedResult), resultActions.andReturn().getResponse().getContentAsString());
    }
}
