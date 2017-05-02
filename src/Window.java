import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 29.04.2017.
 */
public class Window extends JFrame {
    public Window() {

////////////// Задание 2 ////////////////////////////////////
        AddressBook a = new AddressBook();
        a.set("Виктор",333,88888,444444,666666,777777,88888);
        a.set("Иван",1111111,33333333,444444,345345345,7776767);
        System.out.println(a.getString("Виктор"));
        System.out.println(a.getString("Иван"));

/////////////////////////////////////////////////////////////

        setTitle("Телефонная книга");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 600);
        Border blackline = BorderFactory.createLineBorder(Color.black);

        JPanel addressPanle = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));

        JTextArea jEditName = new JTextArea();
        JTextArea jEditPhone = new JTextArea();
        JTextPane jTextOutput = new JTextPane();

        JLabel jLabelName = new JLabel("Имя");
        JLabel jLabelPhone = new JLabel("Телефон");
        jLabelName.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelPhone.setHorizontalAlignment(SwingConstants.CENTER);

        jEditName.setBorder(blackline);
        jEditPhone.setBorder(blackline);

        jTextOutput.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));;
        jTextOutput.setEditable(false);

        JButton jbWrite = new JButton("Добавить");
        JButton jbRead = new JButton("Поиск");

        getContentPane().add(addressPanle, BorderLayout.CENTER);
        getContentPane().add(inputPanel, BorderLayout.SOUTH);

        addressPanle.setPreferredSize(new Dimension(0, 300));
        addressPanle.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        addressPanle.setBackground(Color.BLACK);
        addressPanle.add(jTextOutput,BorderLayout.CENTER);

        inputPanel.setPreferredSize(new Dimension(0, 100));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        inputPanel.add(jLabelName);
        inputPanel.add(jEditName);
        inputPanel.add(jLabelPhone);
        inputPanel.add(jEditPhone);
        inputPanel.add(jbWrite);
        inputPanel.add(jbRead);

        jbWrite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = jEditName.getText();
                String phone = jEditPhone.getText();
                Integer intPhone  = Integer.parseInt(phone);
                jEditPhone.setText("");
                a.set(name,intPhone);
                jTextOutput.setText(name + " "+phone+" контакт сохранен");
            }
        });

        jbRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = jEditName.getText();
                String phone = jEditPhone.getText();
                jEditPhone.setText("");
                jTextOutput.setText(a.getString(name));
            }
        });

        setVisible(true);
    }
}
