import DecimalFractiomalNumber.DecimalFractionalNumber;

public class Main {
    public static void main(String[] args) {
        DecimalFractionalNumber dc = new DecimalFractionalNumber("15,458");
        DecimalFractionalNumber bc = new DecimalFractionalNumber("15,457");
        System.out.println(dc.getWholeNumber());
        System.out.println(dc.getFractionalNumber());
        System.out.println(dc.plus(bc));

    }

}
