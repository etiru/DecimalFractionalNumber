import DecimalFractiomalNumber.DecimalFractionalNumber;

public class Main {
    public static void main(String[] args) {
//        System.out.println(String.valueOf(123602540451561651265116521054619561231562110621653210.0));
        DecimalFractionalNumber dc = new DecimalFractionalNumber("5645454.15");
        DecimalFractionalNumber bc = new DecimalFractionalNumber("1008743678368736.15");

        System.out.println(dc.plus(bc));
        System.out.println(dc.getWholeNumber());
        System.out.println(dc.getFractionalNumber());
        System.out.println(bc.getWholeNumber());
        System.out.println(dc.plus(bc).getWholeNumber());
        System.out.println(bc.getFractionalNumber());
    }

}
