import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickCounter extends JFrame{
    private JPanel panel1;
    private JLabel lCounter;
    private JButton bDecriment;
    private JButton bReset;
    private JButton blncriment;

    public ClickCounter() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);

        lCounter.setFont(new Font("0", Font.PLAIN, 36));

        setContentPane(panel1);
        setTitle("クリックすることでカウントアップ、カウントダウンできます");

        bDecriment.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String sum = lCounter.getText();
                int count = Integer.parseInt(sum);
                count -= 1;
                lCounter.setText(String.valueOf(count));

            }
        });

        bReset.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                lCounter.setText("0");
            }
        });

        blncriment.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String sum = lCounter.getText();
                int count = Integer.parseInt(sum);
                count += 1;
                lCounter.setText(String.valueOf(count));
            }
        });
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {new ClickCounter().setVisible(true);
        });
    }
}
