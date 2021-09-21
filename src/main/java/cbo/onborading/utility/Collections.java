package cbo.onborading.utility;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Collections {

    //Path
    public static final Object ON_BOARDING_URL ="http://10.1.245.189:9081/CUSONBRD/services" ;




    public static String randomString(int n){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz!@#$%&*";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }
    public static String encP(String password){

        //String password = "myPassword";
        String encryptedpassword = null;
        try
        {
            /* MessageDigest instance for MD5. */
            MessageDigest m = MessageDigest.getInstance("MD5");

            /* Add plain-text password bytes to digest using MD5 update() method. */
            m.update(password.getBytes());

            /* Convert the hash value into bytes */
            byte[] bytes = m.digest();

            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            /* Complete hashed password in hexadecimal format */
            encryptedpassword = s.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

return encryptedpassword;
    }
    public static SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage(new MimeHeaders(),
                new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
        return message;
    }

}
