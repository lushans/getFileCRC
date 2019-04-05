import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

public class crc {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java crc <file>");
            System.exit(-1);
        }
        System.out.println(args[0]);
        String path =  args[0];
        String crc = loadCRC32(path);

        System.out.println("HEX:" + crc);
        System.out.println("DEC:"+ Integer.parseInt(crc,16));
    }

    public static String loadCRC32(String filePath) {
        CRC32 crc32 = new CRC32();
        FileInputStream inputStream = null;
        CheckedInputStream checkedinputstream = null;
        String crcStr = null;
        try {
            inputStream = new FileInputStream(new File(filePath));
            checkedinputstream = new CheckedInputStream(inputStream, crc32);
            while (checkedinputstream.read() != -1) {
            }
            crcStr = Long.toHexString(crc32.getValue()).toUpperCase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (checkedinputstream != null) {
                try {
                    checkedinputstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return crcStr;
    }

}
