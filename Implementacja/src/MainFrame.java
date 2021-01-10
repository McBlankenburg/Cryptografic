//
//  Autor: Marcel Młodziński 217119
//

import javax.swing.*;

public class MainFrame extends JFrame
{
    private JButton elGamalButton;
    private JButton OTPButton;
    private JPanel mainPanel;

    public MainFrame()
    {
        this.setBounds(100,100,500,300);
        initComponents();
        elGamalButton.addActionListener(e -> elGamalAction());
        OTPButton.addActionListener(e -> otpAction());
    }

    private void initComponents()
    {
        this.setTitle("Kryptografia");
        this.getContentPane().add(mainPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new MainFrame().setVisible(true);
    }

    private void otpAction()
    {
        OTPFrame otpFrame = new OTPFrame();
        otpFrame.setName("Algorytm OTP");
        otpFrame.setTitle("Algorytm OTP");
        otpFrame.setVisible(true);
        this.getContentPane().add(otpFrame);
        mainPanel.setVisible(false);
        otpFrame.setPreferredSize(mainPanel.getPreferredSize());
        this.setSize(1000,600);
    }

    private void elGamalAction()
    {
        ElGamalFrame elGamalFrame = new ElGamalFrame();
        elGamalFrame.setName("Algorytm ElGamala");
        elGamalFrame.setTitle("Algorytm ElGamala");
        elGamalFrame.setVisible(true);
        this.getContentPane().add(elGamalFrame);
        mainPanel.setVisible(false);
        elGamalFrame.setPreferredSize(mainPanel.getPreferredSize());
        this.setSize(1000,300);
    }
}
