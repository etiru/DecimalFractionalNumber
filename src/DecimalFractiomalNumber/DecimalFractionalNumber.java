package DecimalFractiomalNumber;


import java.util.ArrayList;

public final class DecimalFractionalNumber {
    private final ArrayList<Integer> wholeNumber;
    private final ArrayList<Integer> fractionalNumber;

    public DecimalFractionalNumber(String number) {
        this.wholeNumber = new ArrayList<>();
        this.fractionalNumber = new ArrayList<>();
        int numLength = number.length();
        int commonIndex = number.indexOf(",");

        if(commonIndex == -1){
            commonIndex = numLength;
        }

        for (int i = 0; i < commonIndex; i += 9) {
            if (((commonIndex - i) > 9)) {
                String part = number.substring(i, i + 9);
                Integer partToInt = Integer.parseInt(part);
                wholeNumber.add(partToInt);

            } else {
                String lastPart = number.substring(i, commonIndex);
                Integer lastPartToInt = Integer.parseInt(lastPart);
                wholeNumber.add(lastPartToInt);
                break;
            }
        }

        if(commonIndex != numLength){
            for (int i = commonIndex + 1; i < numLength; i += 9) {
                if (((numLength - i) > 9)) {
                    String part = number.substring(i, i + 9);
                    Integer partToInt = Integer.parseInt(part);
                    fractionalNumber.add(partToInt);
                } else {
                    String lastPart = number.substring(i, numLength);
                    Integer lastPartToInt = Integer.parseInt(lastPart);
                    fractionalNumber.add(lastPartToInt);
                    break;
                }
            }
        }
    }


    public ArrayList<Integer> getWholeNumber() {
        return wholeNumber;
    }

    public ArrayList<Integer> getFractionalNumber() {
        return fractionalNumber;
    }

    public StringBuilder plus(DecimalFractionalNumber other){
        ArrayList<Integer> resultWholeNumber = new ArrayList<Integer>();
        ArrayList<Integer> resultFractionalNumber = new ArrayList<Integer>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < wholeNumber.size(); i++ ){
            Integer sum = wholeNumber.get(i) + other.wholeNumber.get(i);
            resultWholeNumber.add(sum);
            result.append(resultWholeNumber);
            }
        for (int i = 0; i < fractionalNumber.size(); i++ ){
            Integer sum = fractionalNumber.get(i) + other.fractionalNumber.get(i);
            resultFractionalNumber.add(sum);
            result.append(resultFractionalNumber);
        }

        return result;
    }
}
