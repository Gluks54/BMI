import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class BodyTest {

    BMI_Calculator tempBMICalculator;
    @Before
    public void setUp(){

    }
                            //TestCalculateMethod
    @Test
    @Parameters(method = "paramCorTest")
    public void testCorArgCal(double weight, double height, String exp){
            BMI_Calculator BMICalculator = new BMI_Calculator(weight,height);
            assertEquals(exp, BMICalculator.calculate(weight,height));
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
           BMI_Calculator BMICalculator = new BMI_Calculator(weight, height);

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
        BMI_Calculator bmi_calculator = new BMI_Calculator();
        bmi_calculator.interpret(bmi);
        assertEquals(label,bmi_calculator.interpret(bmi));
    }
    private Object [] corArgInt(){
        return new Object[][]{
                {"15","Very severely underweight"},
                {"15.5","Severely underweight"},
                {"18.5","Underweight"}
        };
    }

    @Test
    @Parameters(method = "unCrArgInt")
    public  void testUnCorArgInt(String bmi){
            BMI_Calculator BMICalculator = new BMI_Calculator();
           try {
               BMICalculator.interpret(bmi);
           }catch (IllegalArgumentException ex){
               assertTrue(true);
           }
    }

    private Object [] unCrArgInt(){
        return new Object[][]{
                {"1,0"},
                {"14g"},
                {".25"}
        };
    }
}
