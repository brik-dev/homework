

public class Main {

    /**
     * 1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
     *  10 3 1 2
     *  2 3 2 2
     *  5 6 7 1
     *  300 3 1 0
     *  Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
     *  2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
     *  3. Ваши методы должны бросить исключения в случаях:
     *     Если размер матрицы, полученной из строки, не равен 4x4;
     *     Если в одной из ячеек полученной матрицы не число; (например символ или слово)
     *  4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
     *  5. * Написать собственные классы исключений для каждого из случаев
     * @param args
     */
    public static void main(String[] args) {
        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        //4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.

        String [][] stringArray = convertStringToArray(str);
        for(int i = 0; i < stringArray.length; i++){
            for(int j = 0; j < stringArray.length; j++){
                System.out.println(stringArray[i][j]);
            }
        }
        System.out.println(calculate(stringArray));

        /*String[][] stringArray = {{"10", "20"},{"2", "2"}};
        int[][] newArray = new int[stringArray.length][stringArray.length];
        for(int i = 0; i < stringArray.length; i++){
            for (int j = 0; j < stringArray.length; j++){
                newArray[i][j] = Integer.parseInt(stringArray[i][j]);
                System.out.println(newArray[i][j]);
            }
        }*/
    }

    static String [][] convertStringToArray(String s){
        int length = s.split("\n").length;
        //3. Если размер матрицы, полученной из строки, не равен 4x4;


        int i = 0;
        int j = 0;

        String[] strArr = new String[length];
        for(String returnValue : s.split("\n")){
            strArr[i] = returnValue;
            i++;
        }

        String[][] strDoubleArr = new String[length][length];
        for(i = 0; i < length; i++){
            for(String returnValue : strArr[i].split(" ")){
                strDoubleArr[i][j] = returnValue;
                j++;
                if(j == length) j = 0;
                    else throw new IndexOutOfBoundsException("Если размер матрицы, полученной из строки, не равен 4x4");
            }
        }
        return strDoubleArr;
    }

    //Преобразовать все элементы массива в числа типа int
    //просуммировать
    //поделить полученную сумму на 2 и вернуть результат
    //Если в одной из ячеек полученной матрицы не число; (например символ или слово)

    static int calculate(String[][] s){
        String[][] stringArray = s;
        int sum = 0;
        for(int i = 0; i < stringArray.length; i++){
            for (int j = 0; j < stringArray.length; j++){
                try {
                    sum += Integer.parseInt(stringArray[i][j]);
                }catch (NumberFormatException e){
                    System.out.println("В одной из ячеек полученной матрицы не число.");
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
        return sum/2;
    }
}
