import DecimalFractiomalNumber.DecimalFractionalNumber;


public class Main {
    public static void main(String[] args) {
//        System.out.println(String.valueOf(123602540451561651265116521054619561231562110621653210.0));
        DecimalFractionalNumber dc = new DecimalFractionalNumber("1000000000");
                                                                                    //151000000000010000
                                                                                    //01500000000000010000
        DecimalFractionalNumber bc = new DecimalFractionalNumber("-9999999999");
        System.out.println(dc.plus(bc));
        System.out.println(dc.plus(bc).getWholeNumber());
        System.out.println(dc.getWholeNumber());
        System.out.println(dc.getFractionalNumber());
        System.out.println(dc);

        // [0001] [9999] [0000] [9999]
        //-[0001] [1111] [9999] [0000]//        System.out.println(dc.plus(bc));
    }

}
