public class Main
{
    public static void main(String[] args) throws Exceptions
    {
        String tekst = "asd";
        String klucz = "123";
        System.out.println("Tekst jawny: " + tekst + " = " + tekst.getBytes() + "\nKlucz: " + klucz + " = " + klucz.getBytes());
        byte[] szyfrogram = OTP.szyfruj(klucz.getBytes(),tekst.getBytes());
        String szyfr = new String(szyfrogram);
        System.out.println("\nSzyfrogram: " + szyfrogram + " = " + szyfr);
        byte[] odszyfrowana = OTP.odszyfruj(klucz.getBytes(),szyfrogram);
        String ods = new String(odszyfrowana);
        System.out.println("\nTekst jawny po odszyfrowaniu: " + odszyfrowana + " = " + ods);
    }
}
