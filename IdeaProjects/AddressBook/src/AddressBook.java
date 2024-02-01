import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class AddressBook extends JFrame{
    private JTextField textField1;
    private JList list1;
    private JButton addButton;
    private JButton saveButton;
    private JPanel panel1;
    private JTextField textField2;
    DefaultListModel<Address> address_list = new DefaultListModel();
    private void saveTextFileActionPerformed(ActionEvent evt) {

        JFileChooser dai = new JFileChooser(System.getProperty("user.home"));
        File file = null;
        int selected = dai.showSaveDialog(this);

        switch (selected) {
            case JFileChooser.APPROVE_OPTION:
                file = dai.getSelectedFile();
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "キャンセル");
                break;
            default:
                JOptionPane.showMessageDialog(this, "取り消しまたはエラー発生しました");
                break;
        }

        if (file != null) {
            try (BufferedWriter b = Files.newBufferedWriter(file.toPath(), Charset.defaultCharset())) {
                Gson gson = new Gson();
                b.write(gson.toJson(address_list.toArray()));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "ファイルを保存する際にエラー発生しました");
            }
        }
    }
    public AddressBook() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);
        setContentPane(panel1);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField2.getText().isEmpty() && !textField1.getText().isEmpty()){
                    address_list.addElement(new Address(textField1.getText(), textField2.getText()));
                    textField1.setText(null);
                    textField2.setText(null);
                    list1.setModel(address_list);
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTextFileActionPerformed(e);
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {new AddressBook().setVisible(true);
        });
    }
}

