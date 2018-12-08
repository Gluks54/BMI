import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.security.PublicKey;
@RunWith(JUnitParamsRunner.class)
public class BodyTest {

    Body tempBody;
    @Before
    public void setUp(){

    }
                            //TestCalculateMethod
    @Test
    @Parameters(method = "paramCorTest")
    public void testCorArgCal(double weight, double height, String exp){
            Body body = new Body(weight,height);
            assertEquals(exp,body.calculate(weight,height));
    }

    private Object [] paramCorTest(){
        return new Object[][]{
                {40, 120, "27.8"},
                {50, 120, "34.7"}
        };
    }

    @Test
    @Parameters(method = "uncorMethod")
    public void testUnCorArgCal(double weight,double height){
       try {
           Body body = new Body(weight, height);
           //fail();
       }catch (IllegalArgumentException ex){
           assertTrue(true);
       }
    }
    private  Object[][] uncorMethod(){
        return new Object[][]{
                {-1, 170},
                { 1,  -1},
                {0, 120},
                {50,  -1}
        };
    }


                        //TestInterpretMethod
    @Test
    @Parameters(method = "corArgInt")
    public void testCorArgInt(String bmi, String label){
        Body body = new Body();
        body.interpret(bmi,label);
    }
    private Object [] corArgInt(){
        return new Object[][]{
                {"15, very severely underweight"},
                {"15.5, severely underweight"},
                {"18.5, underweight"}
        };
    }

    @Test
    @Parameters(method = "unCrArgInt")
    public  void testUnCorArgInt(String bmi, String label){
            Body body = new Body();
           try {
               body.interpret(bmi, label);
           }catch (IllegalArgumentException ex){
               assertTrue(true);
           }
    }

    private Object [] unCrArgInt(){
        return new Object[][]{
                {"1,0, very severely underweight"},
                {"14g, severely underweight"},
                {".25, underweight"}
        };
    }
}
