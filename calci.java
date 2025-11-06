import java.util.*;
import mycalc.Calculator;

public class calci {
    public static void main(String[] args) {
        System.out.println("------------ JAVA CALCULATOR -----------");
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter A : ");
        int a = sc.nextInt();
        System.out.print("Enter B : ");
        int b = sc.nextInt();

        System.out.println("Addition = " + Calculator.add(a, b));
        System.out.println("Substraction = " + Calculator.subtract(a, b));
        System.out.println("Multiplication = " + Calculator.multiply(a, b));
        System.out.println("Division = " + Calculator.division(a, b));
    }
    
}
