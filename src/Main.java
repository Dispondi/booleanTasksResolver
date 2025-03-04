import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Boolean> inputBoolean = new HashMap<>() {{ // вводить данные сюда
            put(0, true);
            put(1, true);
            put(2, null);
            put(3, true);
            put(4, false);
            put(5, false);
            put(6, true);
            put(7, false);
            put(8, null);
            put(9, true);
            put(10, false);
            put(11, false);
            put(12, null);
            put(13, null);
            put(14, true);
            put(15, null);
        }};

        boolean[][] inputArray = new boolean[16][4];
        for (int i = 0; i < 16; i++) {
            String binaryDigit = Integer.toBinaryString(i);
            if (binaryDigit.length() < 2) {
                binaryDigit = "000" + binaryDigit;
            } else if (binaryDigit.length() < 3) {
                binaryDigit = "00" + binaryDigit;
            } else if (binaryDigit.length() < 4) {
                binaryDigit = "0" + binaryDigit;
            }

            for (int j = 0; j < 4; j++) {
                inputArray[i][j] = stringToBool(String.valueOf(binaryDigit.charAt(3 - j)));
            }
        }

        for (int i = 0; i < 16; i++) {
            System.out.print(i + " ");
            for (boolean j : inputArray[i]) {
                if (j) System.out.print(1);
                else System.out.print(0);
            }
            System.out.print(" ");
            boolean resolve = booleanTask(inputArray[i]);
            String outputRow = "";
            if (resolve) outputRow += 1;
            else outputRow += 0;
            if (inputBoolean.get(i) == null) {
                System.out.println(outputRow);
                continue;
            }
            outputRow += inputBoolean.get(i) == resolve ? " Совпадает" : " Не совпадает";
            System.out.println(outputRow);
        }
    }
    public static boolean stringToBool(String s) {
        if (s.equals("1"))
            return true;
        if (s.equals("0"))
            return false;
        throw new IllegalArgumentException(s+" is not a bool. Only 1 and 0 are.");
    }

    public static boolean booleanTask(boolean[] arr) { // вводить функцию сюда
        return (arr[1] || !arr[2]) && (!arr[0] || !arr[2]) && (!arr[1] || arr[2] || !arr[3]);
    }
}