import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberQuiz extends JFrame{
    private JPanel panel1;
    private JTextField tNumberInput;
    private JButton bCheck;
    private JLabel IMessage;
    public int count;
    public int currentNum;

    public NumberQuiz(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);

        tNumberInput.setFont(new Font("00000", Font.PLAIN, 36));
        setNumber();
        setContentPane(panel1);
        setTitle("ランダムに決定した5桁の整数値を当てましょう。");

        bCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bCheck.getText() == "リセット"){
                    setNumber();
                    IMessage.setText("ランダムに決定した5桁の整数値を当てましょう。");
                    bCheck.setText("チェック");
                    return;
                }
                String sum = tNumberInput.getText();
                int inputNum=0;
                try{
                    inputNum = Integer.parseInt(sum);
                }catch (Exception e1){
                    return;
                }
                count += 1;
                String message = "";
                if(currentNum - inputNum >= 10000) {
                    IMessage.setText("それよりもっともっと大きい(試行回数" + count + ")");
                }else if(currentNum - inputNum >= 1000){
                    IMessage.setText("それよりもっと大きい(試行回数:" + count + ")");
                }else if(currentNum - inputNum > 0){
                    IMessage.setText("それより大きい(試行回数:" + count + ")");
                }else if(inputNum - currentNum >= 10000){
                    IMessage.setText("それよりもっともっと小さい(試行回数:" + count + ")");
                }else if(inputNum - currentNum >= 1000){
                    IMessage.setText("それよりもっと小さい(試行回数:" + count + ")");
                }else if(inputNum - currentNum > 0){
                    IMessage.setText("それより小さい(試行回数:" + count + ")");
                }else if(inputNum == currentNum){
                    IMessage.setText("正解(試行回数:" + count + ")");
                    count=0;
                    bCheck.setText("リセット");
                }
            }
        });
    }

    public void setNumber(){
        Random rdom = new Random();
        int randomNumber = rdom.nextInt(100000);
        currentNum = randomNumber;
        tNumberInput.setText("00000");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {new NumberQuiz().setVisible(true);
        });
    }
}
