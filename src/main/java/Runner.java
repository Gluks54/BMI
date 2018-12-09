import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        BMI_Calculator calcul = new BMI_Calculator();
        Scanner scanner = new Scanner(System.in);
        double weight = 0.0;
        double height = 0.0;
        System.out.println("Type your weight");
        while (weight <= 0.0){
            try{
                weight = scanner.nextDouble();
                if(weight <= 0.0){
                    System.out.println("Incorrect weight, try again");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Incorrect weight, try again");
                scanner.nextDouble();
            }
            System.out.println("Type your height");
            while (height <= 0.0) {
                try {
                    height = scanner.nextDouble();
                    if (height <= 0.0) {
                        System.out.println("Incorrect height, try again");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Incorrect height, try again");
                    scanner.nextDouble();
                }
            }

        String temp =  calcul.calculate(weight,height);
        String rezult = calcul.interpret(temp);
        System.out.println(rezult);

        }

    }
}
