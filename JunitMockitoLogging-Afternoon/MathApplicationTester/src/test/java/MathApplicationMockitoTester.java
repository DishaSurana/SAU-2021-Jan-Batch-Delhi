import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationMockitoTester {

    @InjectMocks
    MathApplicationMockito mockitoApplication = new MathApplicationMockito();

    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd(){

        when(calcService.add(10.0,20.0)).thenReturn(30.0);
        when(calcService.add(20.0,30.0)).thenReturn(50.0);

        assertEquals(mockitoApplication.add(10.0,20.0),30.0,0);
        assertEquals(mockitoApplication.add(20.0,30.0),50.0,0);

        verify(calcService,atLeast(1)).add(10.0,20.0);
    }

    @Test
    public void testSubtract(){

        when(calcService.subtract(30.0,20.0)).thenReturn(10.5);
        when(calcService.subtract(10.0,30.0)).thenReturn(-20.0);

        assertEquals(mockitoApplication.subtract(30.0,20.0),10.0,0.5);
        assertEquals(mockitoApplication.subtract(10.0,30.0),-20.0,0.5);

        verify(calcService,atLeast(1)).subtract(10.0,30.0);
    }

    @Test
    public void testMultiply(){

        when(calcService.multiply(30.0,20.0)).thenReturn(600.0);
        when(calcService.multiply(10.0,30.0)).thenReturn(300.0);

        assertEquals(mockitoApplication.multiply(30.0,20.0),600.0,0.5);
        assertEquals(mockitoApplication.multiply(10.0,30.0),300.0,0.5);

        verify(calcService,atLeast(1)).multiply(30.0,20.0);
    }

    @Test(expected = Exception.class)
    public void testDivide() throws Exception {

        when(calcService.divide(40.0,20.0)).thenReturn(2.0);
        when(calcService.divide(10.0,0.0)).thenThrow(ArithmeticException.class).thenReturn(-1.0);

        assertEquals(mockitoApplication.divide(40.0,20.0),2.0,0.5);
        assertEquals(mockitoApplication.divide(10.0,0.0),-1.0,0.5);

        verify(calcService,atLeast(1)).divide(40.0,20.0);
    }

}

