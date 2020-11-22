package lesson_f.homework;

public class CheckArray {

    public static int[] arrayAfterLast4(int[] arr) {
        int count = 0;
        for (int j : arr) {
            if (j == 4) {
                count++;
            }
        }
        int[] result = new int[0];
        if (count >= 1) {
            int countAgain = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 4) {
                    countAgain++;
                }
                if (count == countAgain) {
                    result = new int[arr.length - i - 1];
                    for (int j = i + 1, k = 0; j < arr.length; j++, k++)
                        result[k] = arr[j];
                }
            }
        } else {
            throw new RuntimeException();
        }
        return result;
    }

    public static boolean checkArrayFor1And4(int[] arr) {
        for (int j : arr) {
            if (j == 1 || j == 4) {
                return true;
            }
        }
        return false;
    }
}
