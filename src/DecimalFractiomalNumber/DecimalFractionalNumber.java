package DecimalFractiomalNumber;


import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class DecimalFractionalNumber {
    private final  ArrayList<Integer> wholeNumber;
    private final  ArrayList<Integer> fractionalNumber;

    public DecimalFractionalNumber(String number){
        this.wholeNumber = new ArrayList<>();
        this.fractionalNumber= new ArrayList<>();
        int numLength = number.length();
        int commonIndex = number.indexOf(",");

        for (int i = 0; i < commonIndex; i += 9){
            if (!((commonIndex - i) < 18)) {
                String part = number.substring(i, i + 9);
                Integer partToInt = Integer.parseInt(part);
                wholeNumber.add(partToInt);
            }
            else {
                Integer residue = commonIndex - i * 2;
                String lastPart = number.substring(i + 9, (i + 9) + residue);
                Integer lastPartToInt = Integer.parseInt(lastPart);
                wholeNumber.add(lastPartToInt);
                break;
            }
        }

//        for (int i = commonIndex + 1; i < numLength; i += 9){
//            String part = number.substring(i, i + 9);
//            Integer partToInt = Integer.parseInt(part);
//            fractionalNumber.add(partToInt);
//            System.out.println("i"+i);
//            System.out.println("comonIndex" + commonIndex);

//            if (numLength - (commonIndex + 1) - i < 18){
//
//                String lastPart =
//
//
//
//
//                fractionalNumber.add(lastPartToInt);
//            }
//        }

    }


    public ArrayList<Integer> getWholeNumber() {return wholeNumber;}
    public ArrayList<Integer> getFractionalNumber(){return fractionalNumber;}

    public DecimalFractionalNumber plus(DecimalFractionalNumber other){
        return new DecimalFractionalNumber(
                if (wholeNumber.size() >= other.wholeNumber.size()){

        }

        );
    }
}
