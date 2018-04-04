package com.cefalo.oopcourse.experiment;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

public class JsonFormatterSecondTest {

    @Mock
    DataService dataServiceMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Captor
    private ArgumentCaptor<String> argumentCaptor;

    @Test
    public void testNotifyJobComplete() throws Exception {
        JsonFormatter formatter = new JsonFormatter(dataServiceMock);
        formatter.execute();

        verify(dataServiceMock, timeout(1)).notifyJobComplete();
    }
}