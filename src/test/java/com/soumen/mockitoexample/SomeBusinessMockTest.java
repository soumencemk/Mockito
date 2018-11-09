package com.soumen.mockitoexample;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Soumen Karmakar
 * 11/9/2018
 */
public class SomeBusinessMockTest {

    @Test
    public void testFindTheGreatestFromAllData() {
        DataService dataServiceMock = Mockito.mock(DataService.class);
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{24, 15, 3});
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceMock);
        int theGreatestFromAllData = someBusiness.findTheGreatestFromAllData();
        Assert.assertEquals(theGreatestFromAllData, 24);

    }

    @Test
    public void testFindTheGreatestFromAllData_ForOneValue() {
        DataService dataServiceMock = Mockito.mock(DataService.class);
        Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{15});
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = businessImpl.findTheGreatestFromAllData();
        Assert.assertEquals(15, result);
    }
}
