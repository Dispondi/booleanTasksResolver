public class Main {
    public static void main(String[] args) {
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
            if (resolve) System.out.println(1);
            else System.out.println(0);
        }
    }
    public static boolean stringToBool(String s) {
        if (s.equals("1"))
            return true;
        if (s.equals("0"))
            return false;
        throw new IllegalArgumentException(s+" is not a bool. Only 1 and 0 are.");
    }

    public static boolean booleanTask(boolean[] arr) {
        return arr[3] && arr[2] || !arr[0] && arr[1] || !arr[1] && !arr[2] || arr[0] && !arr[2];
    }
}