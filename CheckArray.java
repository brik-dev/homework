package lesson_f.homework;

public class CheckArray {

    public static int[] arrayTailAfterLastFour(int[] arr) {
        if (arr.length == 0)
            throw new RuntimeException("empty array");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                if (i == arr.length - 1) {
                    return(new int[]{});
                }
                int[] newArr = new int[arr.length - i - 1];
                System.arraycopy(arr, i+1,newArr, 0, arr.length-i-1);
                return newArr;
            }
        }
        throw new RuntimeException("couldn't find any digit 4 in input");
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
