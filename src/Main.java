import DecimalFractiomalNumber.DecimalFractionalNumber;

public class Main {
    public static void main(String[] args) {
        DecimalFractionalNumber dc = new DecimalFractionalNumber("-15155456445645654");
        DecimalFractionalNumber bc = new DecimalFractionalNumber("30");
        System.out.println(dc.getWholeNumber());
        System.out.println(dc.getFractionalNumber());
        System.out.println(dc.plus(bc));

    }

}
