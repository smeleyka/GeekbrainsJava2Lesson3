import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by admin on 29.04.2017.
 */
public class Window extends JFrame {
    public Window() throws IOException {
        setTitle("Телефонная книга");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 600);

        Border blackline, raisedetched, loweredetched,
                raisedbevel, loweredbevel, empty;
        blackline = BorderFactory.createLineBorder(Color.black);
        raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        String[]words = {"Яблоко","Яблоко","Абрикос","Авокадо","Вишня","Оливки","Манго","Папайя","Персики","Груши","Сливы","Миндаль","Кешью","Вишня","Каштан","Финики","Фундук","Кумкват","Лимон","Каштан","Оливки","Лайм"};
        HashSet<String> wordsHash = new HashSet<String>(Arrays.asList(words));
        System.out.println(wordsHash);

        HashMap newmap = new HashMap();
        newmap.put("Фрукты",wordsHash);
        newmap.put("Овощи",words);
        System.out.println(newmap.get("Фрукты"));

        System.out.println("_______________________");
        AddressBook a = new AddressBook();
        a.set("Овощи","Яблоко","Яблоко","Абрикос","Авокадо","Вишня","Оливки","Манго","Папайя");
        a.set("Имена","Федр","Иван","Пантелей","Олег","Николай","Григорий","Григорий","Федор");
        //System.out.println(a.get("Ов"));
        System.out.println(a.get("Имена"));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        JPanel addressPanle = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));


        JTextArea jEditName = new JTextArea("Имя");
        JTextArea jEditPhone = new JTextArea("Телефон");
        //JTextArea jTextOutput = new JTextArea();
        JTextPane jTextOutput = new JTextPane();

        JLabel jLabelName = new JLabel("Имя");
        JLabel jLabelPhone = new JLabel("Телефон");
        jLabelName.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelPhone.setHorizontalAlignment(SwingConstants.CENTER);

        jTextOutput.setEditable(false);
        jTextOutput.setText(a.getString("Имена"));

        jEditName.setBorder(blackline);
        jEditPhone.setBorder(blackline);
        jTextOutput.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));;

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
        //inputPanel.setBackground(Color.RED);
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
                a.set(name,phone);
                jTextOutput.setText(name + " "+phone+" контакт сохранен");
            }
        });

        jbRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = jEditName.getText();
                String phone = jEditPhone.getText();
                jTextOutput.setText(a.getString(name));
            }
        });

        setVisible(true);
    }
}
