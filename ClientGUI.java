package lesson_four.homework;
/**
 * Домашнее задание №4
 * Отправлять сообщения в лог по нажатию кнопки или по нажатию клавиши Enter.
 * Создать лог в файле
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));

    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField tfLogin = new JTextField("ivan");
    private final JPasswordField tfPassword = new JPasswordField("123");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private final static String newline = "\n";

    private final JList<String> userList = new JList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });
    }

    private ClientGUI(){
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        JScrollPane scrollLog = new JScrollPane(log);
        JScrollPane scrollUser = new JScrollPane(userList);
        String[] users = {"user1", "user2", "user3", "user4", "user5",
                "user_with_an_exceptionally_long_name_in_this_chat"};
        userList.setListData(users);
        log.setEditable(false);
        scrollUser.setPreferredSize(new Dimension(150, 0));
        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        getRootPane().setDefaultButton(btnSend); // set btnSend as the default button

        add(scrollLog, BorderLayout.CENTER);
        add(scrollUser, BorderLayout.EAST);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);

        btnSend.addActionListener(this);
        btnDisconnect.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == cbAlwaysOnTop){
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());

        }else if(src == btnSend){  //Отправлять сообщения в лог по нажатию кнопки или по нажатию клавиши Enter.
            String text = new String();
            text = tfMessage.getText();
            log.append(text + newline);
            tfMessage.selectAll();

        }else if(src == btnDisconnect){ // Создать лог в файле
            try {
                FileOutputStream doc = new FileOutputStream("log.txt", true);
                doc.write(log.getText().getBytes());
                doc.flush();
                doc.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else {
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
