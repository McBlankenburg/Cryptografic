import java.io.FileInputStream;
import java.io.FileOutputStream;

public class OperacjeNaPlikach
{
    public static byte[] wczytajPlik(String nazwaPliku) throws Exception
    {
        FileInputStream fileInputStream = new FileInputStream(nazwaPliku);
        int rozmiar = fileInputStream.available();
        byte[] ret = new byte[rozmiar];
        fileInputStream.read(ret);
        fileInputStream.close();
        return ret;
    }

    public static void zapiszPlik(byte[] input, String nazwaPliku) throws Exception
    {
        FileOutputStream fileOutputStream = new FileOutputStream(nazwaPliku);
        fileOutputStream.write(input);
        fileOutputStream.close();
    }
}
