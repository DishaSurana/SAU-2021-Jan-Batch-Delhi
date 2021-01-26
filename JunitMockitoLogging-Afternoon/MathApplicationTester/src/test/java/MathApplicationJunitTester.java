import org.junit.Test;
import static junit.framework.TestCase.*;

public class MathApplicationJunitTester {

    MathApplicationJunit junitApplication = new MathApplicationJunit();;

    @Test
    public void addTest(){

        Double ans = junitApplication.add(10.0,20.0);
        assertEquals(30.0, ans);
    }

    @Test
    public void subtractTest(){

        Double ans = junitApplication.subtract(20.0,10.0);
        assertEquals(10.0, ans);
    }

    @Test
    public void multiplyTest(){

        Double ans = junitApplication.multiply(10.0,20.0);
        assertEquals(200.0, ans);
    }

    @Test(expected = Exception.class)
    public void divideTest() throws Exception{

        Double ans;
        ans = junitApplication.divide(30.0, 10.0);
        assertFalse(throwException());
        assertEquals(ans, 3.0);

    }

    private boolean throwException() throws Exception {
        throw new Exception();
    }

}
