import javax.swing.*;

public class ElGamalFrame extends JInternalFrame
{

    private JPanel elGamalPanel;
    private JTextField tekstField;
    private JTextField kluczField;
    private JTextField szyfrogramField;
    private JButton OTPButton;
    private JButton szyfrujButton;
    private JButton deszyfrujButton;
    private JButton podpisCyfrowyButton;
    private JButton zapiszTekstJawnyDoButton;
    private JButton zapiszKluczDoPlikuButton;
    private JButton zapiszSzyfrogramDoPlikuButton;
    private JButton wczytajTekstJawnyZButton;
    private JButton wczytajKluczZPlikuButton;
    private JButton wczytajSzyfrogramZPlikuButton;

    public ElGamalFrame()
    {
        initComponents();
        zapiszTekstJawnyDoButton.addActionListener(e -> zapiszTekst());
        zapiszKluczDoPlikuButton.addActionListener(e -> zapiszKlucz());
        zapiszSzyfrogramDoPlikuButton.addActionListener(e -> zapiszSzyfrogram());
        wczytajTekstJawnyZButton.addActionListener(e -> wczytajTekst());
        wczytajKluczZPlikuButton.addActionListener(e -> wczytajKlucz());
        wczytajSzyfrogramZPlikuButton.addActionListener(e -> wczytajSzyfrogram());
        szyfrujButton.addActionListener(e -> szyfruj());
        deszyfrujButton.addActionListener(e -> deszyfruj());
        OTPButton.addActionListener(e -> OTP());
    }

    private void OTP()
    {
        OTPFrame otpFrame = new OTPFrame();
        otpFrame.setTitle("Algorytm OTP");
        otpFrame.setName("Algorytm OTP");
        otpFrame.setVisible(true);
        this.getContentPane().add(otpFrame);
        elGamalPanel.setVisible(false);
        otpFrame.setPreferredSize(elGamalPanel.getPreferredSize());
    }

    private void deszyfruj()
    {

    }

    private void szyfruj()
    {

    }

    private void wczytajSzyfrogram()
    {

    }

    private void wczytajKlucz()
    {

    }

    private void wczytajTekst()
    {

    }

    private void zapiszKlucz()
    {

    }

    private void zapiszSzyfrogram()
    {

    }

    private void zapiszTekst()
    {

    }

    public void initComponents() { this.getContentPane().add(elGamalPanel); }
}
