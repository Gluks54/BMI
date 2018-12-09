
//public interface Calculate {
//public String calculate(double weight, double height);
//public String interpret(String bmi);
//}
public interface Calculate<T> {
    T calculate(double ...a);
    String interpret(T paramToInterpret);
}
