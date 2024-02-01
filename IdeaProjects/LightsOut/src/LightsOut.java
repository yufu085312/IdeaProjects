import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class LightsOut extends JFrame{
    private JPanel panel1;
    private JPanel OutPanel;
    private JLabel ITopLeft;
    private JLabel ITopCenter;
    private JLabel ITopRight;
    private JLabel IMiddleLeft;
    private JLabel IMiddleCenter;
    private JLabel IMiddleRight;
    private JLabel IBottomLeft;
    private JLabel IBottomCenter;
    private JLabel IBottomRight;
    private int fontSize = 100;

    public LightsOut(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 600);
        Initialization();
        setContentPane(panel1);
        setTitle("ライツアウトっぽいゲーム");

        ITopLeft.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                changeLabelText(ITopLeft);
                changeLabelText(ITopCenter);
                changeLabelText(IMiddleLeft);
                checkCompleted();
            }
        });
        ITopCenter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                changeLabelText(ITopLeft);
                changeLabelText(ITopCenter);
                changeLabelText(ITopRight);
                changeLabelText(IMiddleCenter);
                checkCompleted();
            }
        });
        ITopRight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                changeLabelText(ITopCenter);
                changeLabelText(ITopRight);
                changeLabelText(IMiddleRight);
                checkCompleted();
            }
        });
        IMiddleLeft.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                changeLabelText(ITopLeft);
                changeLabelText(IMiddleLeft);
                changeLabelText(IMiddleCenter);
                changeLabelText(IBottomLeft);
                checkCompleted();
            }
        });
        IMiddleCenter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                changeLabelText(ITopCenter);
                changeLabelText(IMiddleLeft);
                changeLabelText(IMiddleCenter);
                changeLabelText(IMiddleRight);
                changeLabelText(IBottomCenter);
                checkCompleted();
            }
        });
        IMiddleRight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                changeLabelText(ITopRight);
                changeLabelText(IMiddleCenter);
                changeLabelText(IMiddleRight);
                changeLabelText(IBottomRight);
                checkCompleted();
            }
        });
        IBottomLeft.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                changeLabelText(IMiddleLeft);
                changeLabelText(IBottomLeft);
                changeLabelText(IBottomCenter);
                checkCompleted();
            }
        });
        IBottomCenter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                changeLabelText(IMiddleCenter);
                changeLabelText(IBottomLeft);
                changeLabelText(IBottomCenter);
                changeLabelText(IBottomRight);
                checkCompleted();
            }
        });
        IBottomRight.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                changeLabelText(IMiddleRight);
                changeLabelText(IBottomCenter);
                changeLabelText(IBottomRight);
                checkCompleted();
            }
        });
    }
    public void InitializationLabelFont(JLabel label){
        label.setFont(new Font("", Font.PLAIN, fontSize));
        Random random = new Random();
        label.setText(String.valueOf(random.nextInt(2)));
    }
    public void Initialization(){
        InitializationLabelFont(ITopLeft);
        InitializationLabelFont(ITopCenter);
        InitializationLabelFont(ITopRight);
        InitializationLabelFont(IMiddleLeft);
        InitializationLabelFont(IMiddleCenter);
        InitializationLabelFont(IMiddleRight);
        InitializationLabelFont(IBottomLeft);
        InitializationLabelFont(IBottomCenter);
        InitializationLabelFont(IBottomRight);
    }
    public void changeLabelText(JLabel label){
        if(label.getText().equals("0")){
            label.setText("1");
        }else if(label.getText().equals("1")){
            label.setText("0");
        }
    }
    public void checkCompleted(){
        if(ITopLeft.getText().equals("1")&&
                ITopCenter.getText().equals("1")&&
                ITopRight.getText().equals("1")&&
                IMiddleLeft.getText().equals("1")&&
                IMiddleCenter.getText().equals("1")&&
                IMiddleRight.getText().equals("1")&&
                IBottomLeft.getText().equals("1")&&
                IBottomCenter.getText().equals("1")&&
                IBottomRight.getText().equals("1"))
        {
            javax.swing.JOptionPane.showMessageDialog(
                    // コンテンツを配置しているペインコントロール
                    panel1,
                    // メッセージ
                    "GameClear!!",
                    // タイトル
                    "3x3 LightsOut",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE
            );
            Initialization();
        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {new LightsOut().setVisible(true);
        });
    }
}