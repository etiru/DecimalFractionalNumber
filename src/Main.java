import DecimalFractiomalNumber.DecimalFractionalNumber;

public class Main {
    public static void main(String[] args) {
        DecimalFractionalNumber a = new DecimalFractionalNumber("100000000");
        DecimalFractionalNumber b = new DecimalFractionalNumber("1");
        System.out.println(a.minus(b));
    }

}
