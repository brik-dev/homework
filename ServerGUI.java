package lesson_four.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler{
    private static final int POS_X = 1000;
    private static final int POS_Y = 550;
    private static final int WIDTH = 200;
    private static final int HEIGHT = 100;

    private final ChatServer chatServer = new ChatServer();
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ServerGUI();
            }
        });
    }

    private ServerGUI(){
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        setLayout(new GridLayout(1, 2));
        btnStart.addActionListener(this);
//        btnStart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                chatServer.start(8189);
//            }
//        });
        btnStop.addActionListener(this);

        add(btnStart);
        add(btnStop);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == btnStop){
            chatServer.stop();
        } else if(src == btnStart){
            //throw new RuntimeException("Hello from EDT!");
            chatServer.start(8189);
        }else {
            throw new RuntimeException("unknown source " + src);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) { //  у нас есть некий Throwable, который мы делаем
        e.printStackTrace(); // stackTrace в консоль. Нам для наших нужд интереснее
        String msg; // а для пользователя мы говорим следующее: Слушай, чувак, вот тебе будет сообщение
        StackTraceElement[] ste = e.getStackTrace(); // из чего оно будет состоять, оно будет состоять из того же самого stacktrace
        msg = "Exception in " + t.getName() + " " + // который мы снабдим информацией "Exception in" + Thread такой.то +
                e.getClass().getCanonicalName() + ": " + // класс исключения тоакой.то
                e.getMessage() + "\n\t at " + ste[0]; // сообщение исключения такое.то  + выведем первую строчку stacktrace
        JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE); // выведем это в такое же диалог сообщение
        System.exit(1); // после этого мы завершаем работу нашего сервера
    }
}
