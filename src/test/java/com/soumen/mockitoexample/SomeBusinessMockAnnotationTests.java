package com.soumen.mockitoexample;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

/**
 * @author Soumen Karmakar
 * 11/9/2018
 */
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockAnnotationTests {

    @Mock
    private DataService dataServiceMock;
    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Test
    public void testFindTheGreatestFromAllData() {
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{24, 15, 3});
        int theGreatestFromAllData = someBusiness.findTheGreatestFromAllData();
        Assert.assertEquals(theGreatestFromAllData, 24);
    }

    @Test
    public void testSize() {
        List mock = Mockito.mock(List.class);
        Mockito.when(mock.size()).thenReturn(10).thenReturn(20);
        Mockito.when(mock.get(Mockito.anyInt())).thenReturn("SAME");
        Assert.assertEquals(10, mock.size());
        Assert.assertEquals(20, mock.size());
        Assert.assertEquals("SAME", mock.get(100));
    }
}
