package com.anz.sb.component.controller;

import com.anz.sb.component.ComponentTest;
import com.anz.sb.model.SbRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.ResourceUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ComponentTest
@AutoConfigureMockMvc
public class StackingBlocksControllerTest {

    private static String STACKING_BLOCKS_PATH = "/v1/anz/stackingBlocks";

    private static String EXAMPLE_1_SUCCESS = "src/test/resources/testFiles/example1_success.json";

    private static String EXAMPLE_2_ERROR = "src/test/resources/testFiles/example2_error.json";

    private static String EXAMPLE_3_ERROR = "src/test/resources/testFiles/example3_error.json";

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setup(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testPerformStackingBlocksExample1() throws Exception {
        mockMvc.perform(post(STACKING_BLOCKS_PATH)
                .content(objectMapper.writeValueAsString(objectMapper.
                        readValue(ResourceUtils.getFile(EXAMPLE_1_SUCCESS).getAbsoluteFile(), SbRequest.class)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testPerformStackingBlocksExample2() throws Exception {
        mockMvc.perform(post(STACKING_BLOCKS_PATH)
                        .content(objectMapper.writeValueAsString(objectMapper.
                                readValue(ResourceUtils.getFile(EXAMPLE_2_ERROR).getAbsoluteFile(), SbRequest.class)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testPerformStackingBlocksExample3() throws Exception {
        mockMvc.perform(post(STACKING_BLOCKS_PATH)
                        .content(objectMapper.writeValueAsString(objectMapper.
                                readValue(ResourceUtils.getFile(EXAMPLE_3_ERROR).getAbsoluteFile(), SbRequest.class)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError());
    }

}
