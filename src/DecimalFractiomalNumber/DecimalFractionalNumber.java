package DecimalFractiomalNumber;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.pow;

public final class DecimalFractionalNumber {
    private ArrayList<Integer> wholeNumber;
    private ArrayList<Integer> fractionalNumber;

    private DecimalFractionalNumber(List<Integer> wholePart, List<Integer> fractionalPart) {
        if (wholePart == null || fractionalPart == null)
            throw new NullPointerException("Unitialized");

        wholeNumber = new ArrayList<>(wholePart);
        fractionalNumber = new ArrayList<>(fractionalPart);
    }


    public DecimalFractionalNumber() {
        wholeNumber = new ArrayList<Integer>();
        wholeNumber.add(0);
        fractionalNumber = new ArrayList<Integer>();
        fractionalNumber.add(0);
    }

    //    public DecimalFractionalNumber(String wholeNumber, String fractionalNumber){
//
//    }

    /**
     * Основной конструктор, который обрабатывает строку
     * строчка разбивается на части по 9 цифр, и каждая часть добавляется в лист wholeNumber и fractionalNumber
     * Пояснение к нулям, при разбивке числа может возникнуть ситуация, что часть 000001452 будет добавлена в лист как
     * [1452], при дальнейшей обработке в методах нули будут добавлены вперед до достижения размера каждого элеманта
     * листа 9
     */
    public DecimalFractionalNumber(String number) {
        this.wholeNumber = new ArrayList<Integer>();
        this.fractionalNumber = new ArrayList<Integer>();
        int numLength = number.length();
        int commonIndex = number.indexOf(".");

        /**
         * если точки нету
         */
        if (commonIndex == -1) {
            commonIndex = numLength;
        }

        /**
         * В этом условии мы ищем (лишние) цифры, которые не войдут в группу по 9 и ставим в листе wholeNumber на первое
         * (нулевое место)
         */
        if (commonIndex % 9 != 0) {
            String lastPart = number.substring(0, commonIndex % 9);
            int lastPartToInt = Integer.parseInt(lastPart);
            wholeNumber.add(lastPartToInt);
        }

        /**
         * заполняем лист wholeNumber
         */
        for (int i = commonIndex % 9; i < commonIndex; i += 9) {   //1244 (65646466) ()   55464565456654.654545
            String part = number.substring(i, i + 9);
            int partToInt = Integer.parseInt(part);
            wholeNumber.add(partToInt);
        }

        /**
        * заполнение fractionalNumber
        */
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

    public void addZero(int expectedCount) {
        if (expectedCount < wholeNumber.size())
            throw new IllegalArgumentException("");
        if (expectedCount == wholeNumber.size())
            return;
        ArrayList<Integer> newWholeNumber = new ArrayList<>();
        int differenceWhole = expectedCount - wholeNumber.size();

        for (int i = 0; i < differenceWhole; i++) {
            newWholeNumber.add(0);
        }
        newWholeNumber.addAll(wholeNumber);
        wholeNumber = newWholeNumber;
    }

    public void addZeroFractional(int expectedCount) {
        if (expectedCount < fractionalNumber.size())
            throw new IllegalArgumentException("");
        if (expectedCount == fractionalNumber.size())
            return;
        ArrayList<Integer> newFractionalNumber = new ArrayList<>();
        int difference = expectedCount - fractionalNumber.size();

        for (int i = 0; i < difference; i++) {
            fractionalNumber.add(0);
        }
//        newWholeNumber.addAll(fractionalNumber);
//        fractionalNumber = newWholeNumber;

    }

    /**
     *
     */
    private List<Integer> addition(List<Integer> partNumber, List<Integer> otherPartNumber) {
        ArrayList<Integer> resultPartNumber = new ArrayList<Integer>();
        int partNumberSize = partNumber.size();
        int transfer = 0;

        for (int i = partNumberSize - 1; i >= 0; i--) {
            int sum = partNumber.get(i) + otherPartNumber.get(i) + transfer;
            if (Math.abs(sum) >= 1000000000) {
                transfer = sum / 1000000000;
                int newSum = sum % 1000000000;
                resultPartNumber.add(newSum);
            } else {
                transfer = sum / 1000000000;
                resultPartNumber.add(sum);
            }
        }
        if(transfer != 0) resultPartNumber.add(transfer);
        Collections.reverse(resultPartNumber);
        System.out.println("TRANSFER " + transfer);
        return resultPartNumber;
    }

    /**
     * Метод plus
     */
    public DecimalFractionalNumber plus(DecimalFractionalNumber other) {
        int maxWholeNumberSize = max(wholeNumber.size(), other.wholeNumber.size());
        int maxFractionalSize = max(fractionalNumber.size(), other.fractionalNumber.size());

        this.addZero(maxWholeNumberSize);
        other.addZero(maxWholeNumberSize);
        this.addZeroFractional(maxFractionalSize);
        other.addZeroFractional(maxFractionalSize);

        List<Integer> resultFractionalNumber = addition(fractionalNumber, other.fractionalNumber);
        List<Integer> resultWholeNumber = addition(wholeNumber, other.wholeNumber);


        DecimalFractionalNumber resultNumber = new DecimalFractionalNumber(resultWholeNumber, resultFractionalNumber);
        return resultNumber;
    }


    @Override
    public String toString() {
        StringBuffer resultStr = new StringBuffer();
        resultStr.append(wholeNumber.get(0));
        for (int i = 1; i < wholeNumber.size(); i++) {
            resultStr.append(String.format("%09d", wholeNumber.get(i)));
        }
        resultStr.append('.');
        for (int i = 0; i < fractionalNumber.size(); i++) {
            resultStr.append(String.format("%09d", fractionalNumber.get(i)));
        }
        return resultStr.toString();
    }


    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object instanceof DecimalFractionalNumber) {
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
