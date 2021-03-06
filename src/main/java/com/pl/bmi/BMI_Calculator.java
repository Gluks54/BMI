import java.text.DecimalFormat;

public class BMI_Calculator implements Calculate {

    private double WEIGHT;
    private double HEIGHT;

    public BMI_Calculator() {
    }

    public BMI_Calculator(double weight, double height) {
        if (weight < 0 | height < 0 | weight == 0 | height == 0) {
            throw new IllegalArgumentException();
        } else {
            this.HEIGHT = height;
            this.WEIGHT = weight;
        }
    }

    @Override
    public String calculate(double weight, double height) {
        double temp = weight / Math.pow(height / 100, 2);
        DecimalFormat f = new DecimalFormat("##.0");
        return f.format(temp);
    }

    @Override
    public String interpret(String bmi) throws IllegalArgumentException {
        String[][] array = {
                {"0", "Very severely underweight"},
                {"15.01", "Severely underweight"},
                {"16.01", "Underweight"},
                {"18.501", "Normal"},
                {"25.01", "Overweight"},
                {"30.01", "Obese Class I"},
                {"35.01", "Obese Class II"},
                {"40.01", "Obese Class III"},
                {"45.01", "Obese Class IV"},
                {"50.01", "Obese Class V"},
                {"60.01", "Obese Class VI"},
                {"1000.0", "Obese Class VI"},
                {"1000.0", "Obese Class VI"}
        };

        double numbBmi = Double.valueOf(bmi);
        if (numbBmi < 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < (array.length - 1); i++) {
            double temp = Double.valueOf(array[i][0]);
            double tempNext = Double.valueOf(array[i + 1][0]);
            if (temp > numbBmi && numbBmi < tempNext) {
                return array[i - 1][1];
            }
        }
        return null;
    }
}
