import java.text.DecimalFormat;

public class Body implements Calculate {

    double WEIGHT;
    double HEIGHT;

    public Body(){}

    public Body(double weight,double height){
        this.HEIGHT = height;
        this.WEIGHT = weight;
    }


    @Override
    public String calculate(double weight, double height)throws IllegalArgumentException {

        if(weight < 0 | height < 0 && weight == 0 | height == 0) {
            new IllegalArgumentException();
        }
        double temp = weight / Math.pow(height / 100, 2);
        DecimalFormat f = new DecimalFormat("##.0");
        return f.format(temp);
    }
    @Override
    public String interpret(String bmi, String label) {
        return null;
    }
}
