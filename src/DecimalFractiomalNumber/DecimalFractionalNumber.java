package DecimalFractiomalNumber;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.pow;

public final class DecimalFractionalNumber {
    private  ArrayList<Integer> wholeNumber;
    private  ArrayList<Integer> fractionalNumber;

    private DecimalFractionalNumber(List<Integer> wholePart, List<Integer> fractionalPart)
    {
        if (wholePart == null || fractionalPart == null)
            throw new NullPointerException("Unitialized");

        wholeNumber = new ArrayList<>(wholePart);
        fractionalNumber = new ArrayList<>(fractionalPart);
    }


    public DecimalFractionalNumber(){
        wholeNumber = new ArrayList<Integer>();
        wholeNumber.add(0);
        fractionalNumber = new ArrayList<Integer>();
        fractionalNumber.add(0);
    }
//    public DecimalFractionalNumber(String wholeNumber, String fractionalNumber){
//
//    }
    public DecimalFractionalNumber(String number) {
        this.wholeNumber = new ArrayList<Integer>();
        this.fractionalNumber = new ArrayList<Integer>();
        int numLength = number.length();
        int commonIndex = number.indexOf(".");


        if (commonIndex == -1) {
            commonIndex = numLength;
        }


        if (commonIndex % 9 != 0) {
            String lastPart = number.substring(0, commonIndex % 9);
            int lastPartToInt = Integer.parseInt(lastPart);
            wholeNumber.add(lastPartToInt);
        }

        for (int i = commonIndex % 9; i < commonIndex; i += 9) {   //1244 (65646466) ()   55464565456654.654545
            String part = number.substring(i, i + 9);
            int partToInt = Integer.parseInt(part);
            wholeNumber.add(partToInt);
        }

        for (int i = commonIndex + 1; i < numLength; i += 9) {
            if (((numLength - i) > 9)) {
                String part = number.substring(i, i + 9);
                int partToInt = Integer.parseInt(part);
                fractionalNumber.add(partToInt);
            } else {
                String lastPart = number.substring(i, numLength);
                int lastPartToInt = Integer.parseInt(lastPart);
                lastPartToInt *= (int) pow(10, 9 - lastPart.length());
                fractionalNumber.add(lastPartToInt);
            }
        }
    }


    public List<Integer> getWholeNumber() {
        return wholeNumber;
    }
    public List<Integer> getFractionalNumber() {
        return fractionalNumber;
    }

    public void addZero(int expectedCount){
        if (expectedCount < wholeNumber.size())
            throw new IllegalArgumentException("");
        if (expectedCount == wholeNumber.size())
            return;
        ArrayList<Integer> newWholeNumber = new ArrayList<>();
        int difference = expectedCount - wholeNumber.size();

        for (int i = 0; i < difference; i++){
            newWholeNumber.add(0);
        }
        newWholeNumber.addAll(wholeNumber);
        wholeNumber = newWholeNumber;
    }

    public DecimalFractionalNumber plus(DecimalFractionalNumber other){

        ArrayList<Integer> resultWholeNumber = new ArrayList<Integer>();
        ArrayList<Integer> resultFractionalNumber = new ArrayList<Integer>();

        StringBuffer resultBuffer = new StringBuffer();

        int maxWholeNumberSize = max(wholeNumber.size(), other.wholeNumber.size());
        this.addZero(maxWholeNumberSize);
        other.addZero(maxWholeNumberSize);

        for (int i = 0; i < maxWholeNumberSize; i++ ){
            int sum = wholeNumber.get(i) + other.wholeNumber.get(i);

            resultWholeNumber.add(sum);
            resultBuffer.append(sum);
            }
        for (int i = 0; i < fractionalNumber.size(); i++ ){
            int sum = fractionalNumber.get(i) + other.fractionalNumber.get(i);
            resultFractionalNumber.add(sum);
            resultBuffer.append(resultFractionalNumber);
        }

        DecimalFractionalNumber resultNumber = new DecimalFractionalNumber(resultWholeNumber, resultFractionalNumber);
//        resultNumber.wholeNumber = resultWholeNumber;
//        resultNumber.fractionalNumber = resultFractionalNumber;
        return resultNumber;
    }

    @Override
    public String toString(){
        StringBuffer resultStr = new StringBuffer();
        resultStr.append(wholeNumber.get(0));
        for(int i = 1; i < wholeNumber.size(); i++){
            resultStr.append(String.format("0%09d", wholeNumber.get(i)));
        }
        resultStr.append('.');

        for(int i = 0; i < fractionalNumber.size(); i++){
            resultStr.append(fractionalNumber.get(i));
        }
        return resultStr.toString();
    }
    @Override
    public boolean equals(Object object){
        if(this == object)
            return  true;
        if(object instanceof DecimalFractionalNumber){
            return this.wholeNumber.equals(((DecimalFractionalNumber) object).wholeNumber) &&
                    this.fractionalNumber.equals(((DecimalFractionalNumber) object).fractionalNumber);
        }
        return false;
    }





//    public DecimalFractionalNumber unaryMinus(){
//          String resultString = "+" + number;
//        return new DecimalFractionalNumber(-wholeNumber, );
//    }
}
