package com.cefalo.oopcourse.experiment;


import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * Test case for testing the csv formatter
 */
public class CSVFormatterTest {

    @Mock
    DataService dataServiceMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testCsv() throws Exception {
        CSVFormatter t = new CSVFormatter(dataServiceMock);
        when(dataServiceMock.readData()).thenReturn(DataService.createDummyItems());

        t.execute();

        verify(dataServiceMock, times(1)).openConnection();

        String expectedText = getExpectedFormat();
        verify(dataServiceMock).exportData(eq(expectedText));

        verify(dataServiceMock, times(1)).closeConnection();
    }

    private String getExpectedFormat() {
        return "1, First Test item, 100.0\n" +
                "2, second Test item, 210.0\n" +
                "3, third Test item, 200.0\n" +
                "4, fourth Test item, 300.0\n";
    }
}