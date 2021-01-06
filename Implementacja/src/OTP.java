public class OTP
{
    public static byte[] szyfruj(byte[] klucz, byte[] tekst) throws Exceptions
    {
        if(klucz.length != tekst.length)
            throw new Exceptions("Dlugosc klucza i tekstu jawnego musi byc taka sama");
        byte[] szyfrogram = tekst;
        for(int i = 0; i < tekst.length; i++)
            szyfrogram[i] ^= klucz[i];
        return szyfrogram;
    }

    public static byte[] odszyfruj(byte[] klucz, byte[] tekst) throws Exceptions
    {
        if(klucz.length != tekst.length)
            throw new Exceptions("Dlugosc klucza i tekstu jawnego musi byc taka sama");
        byte[] szyfrogram = tekst;
        for(int i = 0; i < tekst.length; i++)
            szyfrogram[i] ^= klucz[i];
        return szyfrogram;
    }
}
