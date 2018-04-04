package com.cefalo.oopcourse.experiment;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class JsonFormatterTest {

    @Mock
    DataService dataServiceMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Captor
    private ArgumentCaptor<String> argumentCaptor;

    @Test
    public void testJson() throws Exception {
        JsonFormatter formatter = new JsonFormatter(dataServiceMock);
        when(dataServiceMock.readData()).thenReturn(DataService.createDummyItems());

        formatter.execute();

        verify(dataServiceMock, times(1)).openConnection();

        verify(dataServiceMock).exportData(argumentCaptor.capture());
        String jsonString = argumentCaptor.getValue();
        verifyJson(jsonString);

        verify(dataServiceMock, times(1)).closeConnection();
    }

    private void verifyJson(String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(jsonString);
        Assert.assertTrue(jsonNode.has("result"));

        JsonNode resultNode = jsonNode.get("result");
        Assert.assertTrue(resultNode.isArray());

        Assert.assertEquals(4, resultNode.size());

        //further verifications todo
    }
}