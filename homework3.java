package lesson_b.homework;

/**
 * Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
 * Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция: ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);
 * Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль. Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class homework3 {
    public static void main(String[] args) {
        try {
            task1();
            // task2();
            // task3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void task3() throws IOException {
        final int PAGE_SIZE = 1800;
        RandomAccessFile raf = new RandomAccessFile("1.txt", "rw");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter page:");
        int p = sc.nextInt() - 1;
        raf.seek(p * PAGE_SIZE);
        for (int i = 0; i < PAGE_SIZE; i++) {
            System.out.print((char)raf.read());
        }
        raf.close();
    }

    public static void task2() throws IOException {
        ArrayList<InputStream> al = new ArrayList<InputStream>();

        for (int i = 0; i < 10; i++) {
            al.add(new FileInputStream(i + ".txt"));
        }
        BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
        int x;
        while((x = in.read()) != -1) {
            System.out.print((char)x);
        }
        in.close();
    }

    public static void task1() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("2.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int x;
        while((x = in.read()) != -1) {
            out.write(x);
        }
        byte[] b = out.toByteArray();
        System.out.println(Arrays.toString(b));
        in.close();
        out.close();
    }
}
