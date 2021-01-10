import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
    private JTextField iloscSzyfr;
    private JTextField iloscKlucz;
    private JTextField iloscTekst;

    private File plikZTekst;
    private File plikZKlucz;
    private File plikZSzyft;
    private File plikWTekst;
    private File plikWKlucz;
    private File plikWSzyft;
    private byte[] inputTekst;
    private byte[] inputKlucz;
    private byte[] inputSzyfr;
    private byte[] output;

    public OTPFrame()
    {
        initComponents();
        tekstField.getDocument().addDocumentListener(new docLisText());
        kluczField.getDocument().addDocumentListener(new docLisKlucz());
        szyfrogramField.getDocument().addDocumentListener(new docLisSzyfr());
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

    private void wczytajTekst()
    {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION)
        {
            String path = fileChooser.getSelectedFile().getPath();
            plikWTekst = new File(path);
            try
            {
                inputTekst = OperacjeNaPlikach.wczytajPlik(path);
                tekstField.setText(new String(inputTekst));
            }
            catch (Exception e) { JOptionPane.showMessageDialog(null,"Blad podczas wczytywania pliku"); }
        }
    }

    private void wczytajKlucz()
    {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION)
        {
            String path = fileChooser.getSelectedFile().getPath();
            plikWKlucz = new File(path);
            try
            {
                inputKlucz = OperacjeNaPlikach.wczytajPlik(path);
                kluczField.setText(new String(inputKlucz));
            }
            catch (Exception e) { JOptionPane.showMessageDialog(null,"Blad podczas wczytywania pliku"); }
        }
    }

    private void wczytajSzyfrogram()
    {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION)
        {
            String path = fileChooser.getSelectedFile().getPath();
            plikWSzyft = new File(path);
            try
            {
                inputSzyfr = OperacjeNaPlikach.wczytajPlik(path);
                szyfrogramField.setText(new String(inputSzyfr));
            }
            catch (Exception e) { JOptionPane.showMessageDialog(null,"Blad podczas wczytywania pliku"); }
        }
    }

    private void deszyfruj()
    {
        try
        {
            if (inputSzyfr == null && inputKlucz == null)
                output = OTP.odszyfruj(kluczField.getText().getBytes(), szyfrogramField.getText().getBytes());
            else if (inputSzyfr != null && inputKlucz != null)
                output = OTP.odszyfruj(inputKlucz,inputSzyfr);

            tekstField.setText(new String(output));
            output = null;
        }
        catch (Exception e) { JOptionPane.showMessageDialog(null,"Problem z kluczem"); }
    }

    private void szyfruj()
    {
        try
        {
            if (inputTekst != null && inputKlucz !=null)
                output = OTP.szyfruj(inputKlucz,inputTekst);
            else if (inputTekst == null && inputKlucz == null)
                output = OTP.szyfruj(kluczField.getText().getBytes(), tekstField.getText().getBytes());
            szyfrogramField.setText(new String(output));
            output = null;
        }
        catch (Exception e) { JOptionPane.showMessageDialog(null,"Problem z kluczem"); }
    }

    private void zapiszSzyfrogram()
    {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION)
        {
            String path = fileChooser.getSelectedFile().getPath();
            plikZSzyft = new File(path);
            try
            {
                OperacjeNaPlikach.zapiszPlik(szyfrogramField.getText().getBytes(),path);
            }
            catch (Exception e) { JOptionPane.showMessageDialog(null,"Blad podczas zapisywania pliku"); }
        }
    }

    private void zapiszKlucz()
    {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION)
        {
            String path = fileChooser.getSelectedFile().getPath();
            plikZKlucz = new File(path);
            try
            {
                OperacjeNaPlikach.zapiszPlik(kluczField.getText().getBytes(),path);
            }
            catch (Exception e) { JOptionPane.showMessageDialog(null,"Blad podczas zapisywania pliku"); }
        }
    }

    private void zapiszTekst()
    {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);

        if(choice == JFileChooser.APPROVE_OPTION)
        {
            String path = fileChooser.getSelectedFile().getPath();
            plikZTekst = new File(path);
            try
            {
                OperacjeNaPlikach.zapiszPlik(tekstField.getText().getBytes(),path);
            }
            catch (Exception e) { JOptionPane.showMessageDialog(null,"Blad podczas zapisywania pliku"); }
        }
    }

    class docLisText implements DocumentListener
    {
        @Override
        public void insertUpdate(DocumentEvent e)
        {
            iloscTekst.setText(String.valueOf(e.getDocument().getLength()));
        }

        @Override
        public void removeUpdate(DocumentEvent e)
        {
            iloscTekst.setText(String.valueOf(e.getDocument().getLength()));
        }

        @Override
        public void changedUpdate(DocumentEvent e)
        {
            iloscTekst.setText(String.valueOf(e.getDocument().getLength()));
        }
    }

    class docLisKlucz implements DocumentListener
    {
        @Override
        public void insertUpdate(DocumentEvent e)
        {
            iloscKlucz.setText(String.valueOf(e.getDocument().getLength()));
        }

        @Override
        public void removeUpdate(DocumentEvent e)
        {
            iloscKlucz.setText(String.valueOf(e.getDocument().getLength()));
        }

        @Override
        public void changedUpdate(DocumentEvent e)
        {
            iloscKlucz.setText(String.valueOf(e.getDocument().getLength()));
        }
    }

    class docLisSzyfr implements DocumentListener
    {
        @Override
        public void insertUpdate(DocumentEvent e)
        {
            double ilosc = e.getDocument().getLength();
            ilosc /= 2;
            iloscSzyfr.setText(String.valueOf(ilosc));
        }

        @Override
        public void removeUpdate(DocumentEvent e)
        {
            double ilosc = e.getDocument().getLength();
            ilosc /= 2;
            iloscSzyfr.setText(String.valueOf(ilosc));
        }

        @Override
        public void changedUpdate(DocumentEvent e)
        {
            double ilosc = e.getDocument().getLength();
            ilosc /= 2;
            iloscSzyfr.setText(String.valueOf(ilosc));
        }
    }
}
