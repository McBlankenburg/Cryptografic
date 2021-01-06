import javax.swing.*;
import java.io.File;

public class OTPFrame extends JInternalFrame
{
    private JPanel otpPanel;
    private JTextField szyfrogramField;
    private JTextField kluczField;
    private JButton wczytajPlikTekstu;
    private JButton wczytaPlikZKluczem;
    private JButton zapiszSzyfrogramDoPliku;
    private JButton szyfrujButton;
    private JButton deszyfrujButton;
    private JTextField tekstField;
    private JButton elGamalButton;
    private JButton wczytajSzyfrogram;
    private JButton zapiszKluczButton;
    private JButton zapiszTekstButton;

    private File plik;
    private byte[] input;

    public OTPFrame()
    {
        initComponents();
        zapiszTekstButton.addActionListener(e -> zapiszTekst());
        zapiszKluczButton.addActionListener(e -> zapiszKlucz());
        zapiszSzyfrogramDoPliku.addActionListener(e -> zapiszSzyfrogram());
        szyfrujButton.addActionListener(e -> szyfruj());
        deszyfrujButton.addActionListener(e -> deszyfruj());
        wczytajSzyfrogram.addActionListener(e -> wczytajSzyfrogram());
        wczytaPlikZKluczem.addActionListener(e -> wczytajKlucz());
        wczytajPlikTekstu.addActionListener(e -> wczytajTekst());
        elGamalButton.addActionListener(e -> elGamal());
    }

    private void elGamal()
    {
            ElGamalFrame elGamalFrame = new ElGamalFrame();
            elGamalFrame.setTitle("Algorytm ElGamala");
            elGamalFrame.setName("Algorytm ElGamala");
            elGamalFrame.setVisible(true);
            this.getContentPane().add(elGamalFrame);
            otpPanel.setVisible(false);
            elGamalFrame.setPreferredSize(otpPanel.getPreferredSize());
    }

    private void initComponents()
    {
        this.getContentPane().add(otpPanel);
    }

    private void wczytajTekst()
    {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION)
        {
            String path = fileChooser.getSelectedFile().getPath();
            plik = new File(path);
            try
            {
                input = OperacjeNaPlikach.wczytajPlik(path);
                tekstField.setText(new String(input));
            }
            catch (Exception e) { new Exceptions("Blad podczas wczytywania pliku"); }
        }
    }

    private void wczytajKlucz()
    {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION)
        {
            String path = fileChooser.getSelectedFile().getPath();
            plik = new File(path);
            try
            {
                input = OperacjeNaPlikach.wczytajPlik(path);
                kluczField.setText(new String(input));
            }
            catch (Exception e) { new Exceptions("Blad podczas wczytywania pliku"); }
        }
    }

    private void wczytajSzyfrogram()
    {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION)
        {
            String path = fileChooser.getSelectedFile().getPath();
            plik = new File(path);
            try
            {
                input = OperacjeNaPlikach.wczytajPlik(path);
                szyfrogramField.setText(new String(input));
            }
            catch (Exception e) { new Exceptions("Blad podczas wczytywania pliku"); }
        }
    }

    private void deszyfruj()
    {
        try
        {
            input = OTP.odszyfruj(kluczField.getText().getBytes(), szyfrogramField.getText().getBytes());
            tekstField.setText(new String(input));
        }
        catch (Exception e) { new Exceptions("Problem z kluczem"); }
    }

    private void szyfruj()
    {
        try
        {
            input = OTP.szyfruj(kluczField.getText().getBytes(), tekstField.getText().getBytes());
            szyfrogramField.setText(new String(input));
        }
        catch (Exception e) { new Exceptions ("Problem z kluczem"); }
    }

    private void zapiszSzyfrogram()
    {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION)
        {
            String path = fileChooser.getSelectedFile().getPath();
            plik = new File(path);
            try
            {
                OperacjeNaPlikach.zapiszPlik(szyfrogramField.getText().getBytes(),path);
            }
            catch (Exception e) { new Exceptions("Blad podczas zapisywania pliku"); }
        }
    }

    private void zapiszKlucz()
    {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION)
        {
            String path = fileChooser.getSelectedFile().getPath();
            plik = new File(path);
            try
            {
                OperacjeNaPlikach.zapiszPlik(kluczField.getText().getBytes(),path);
            }
            catch (Exception e) { new Exceptions("Blad podczas zapisywania pliku"); }
        }
    }

    private void zapiszTekst()
    {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION)
        {
            String path = fileChooser.getSelectedFile().getPath();
            plik = new File(path);
            try
            {
                OperacjeNaPlikach.zapiszPlik(tekstField.getText().getBytes(),path);
            }
            catch (Exception e) { new Exceptions("Blad podczas zapisywania pliku"); }
        }
    }
}
