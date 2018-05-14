import DecimalFractiomalNumber.DecimalFractionalNumber;

public class Main {
    public static void main(String[] args) {
        DecimalFractionalNumber dc = new DecimalFractionalNumber("1000000000");
        DecimalFractionalNumber bc = new DecimalFractionalNumber("-9999999999");
        System.out.println(dc.plus(bc));
        System.out.println(dc.plus(bc).getWholeNumber());
        System.out.println(dc.getWholeNumber());
        System.out.println(dc.getFractionalNumber());
        System.out.println(dc);

    }

}
