import java.text.DecimalFormat;

public class BMI_Calculator implements Calculate<String> {
    double weight;
    double height;

    public BMI_Calculator(){}

    public BMI_Calculator(double weight,double height){
        this.height = height;
        this.weight = weight;
    }


    @Override
    public String calculate(double ...params) {
        double weight = params[0];
        double height = params[1];
        double temp = weight / Math.pow(height / 100, 2);
        DecimalFormat f = new DecimalFormat("##.0");
        return f.format(temp);
}





    @Override
    public String interpret(String bmi) throws IllegalArgumentException {
        String [][] array = {
                {"0","Very severely underweight"},
                {"15.01","Severely underweight"},
                {"16.01","Underweight"},
                {"18.501","Normal"},
                {"25.01","Overweight"},
                {"30.01","Obese Class I"},
                {"35.01","Obese Class II"},
                {"40.01","Obese Class III"},
                {"45.01","Obese Class IV"},
                {"50.01","Obese Class V"},
                {"60.01","Obese Class VI"},
                {"1000.0","Obese Class VI"},
                {"1000.0","Obese Class VI"}
                };

        double numbBmi = Double.valueOf(bmi);
        if(numbBmi < 0){
            throw new  IllegalArgumentException();
        }
        for (int i = 0; i < (array.length - 1); i++) {
               double temp = Double.valueOf(array[i][0]);
               double tempNext = Double.valueOf(array[i + 1][0]);
               if(temp > numbBmi && numbBmi < tempNext ){
                       return array [i - 1][1];
                   }
            }
            return null;
        }
    }

//Very severely underweight                         15
//Severely underweight                      15      16
//Underweight                               16      18.5
//Normal (healthy weight)                  18.5     25
//Overweight                                25      30
//Obese Class I (Moderately obese)          30      35
//Obese Class II (Severely obese)           35      40
//Obese Class III (Very severely obese)     40      45
//Obese Class IV (Morbidly Obese)           45      50
//Obese Class V (Super Obese)               50      60
//Obese Class VI (Hyper Obese)              60