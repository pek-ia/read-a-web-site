import java.io.*;
import java.net.*;

public class ReadFromWeb {
    public static void readURL(String aURL) {
        System.out.println("Reading " + aURL);
        try {
            URL u = new URL(aURL);
            URLConnection uc = u.openConnection();

            InputStream is = uc.getInputStream();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(is) );

            String s = null;
            while ((s = br.readLine()) != null) {
                if (s.contains("<img")) {
                    int queryIntroducer = s.indexOf("?");
                    String sub = s.substring(0,queryIntroducer);

                    String subsub = s.substring(sub.indexOf("srcset='")+8, sub.length());
                    System.out.println(subsub);}

            }
        } catch (IOException e) {
            System.out.println("Error occured: " + e);
        }
    }

    public static void main(String[] args) {
        readURL("https://www.cnn.com");
    }
}
