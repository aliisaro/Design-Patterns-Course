package Task6Decorator;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class EncryptedPrinter extends Printer {
    private Printer printer; //instance of printer
    public EncryptedPrinter(Printer printer) { // Constructor that initializes the EncryptedPrinter with a Printer instance
        this.printer = printer;
    }

    @Override
    public void print(String message){
        String encryptedMessage = encrypt(message); // Encrypt the message
        printer.print(encryptedMessage);
    }


    // ecryption logic borrowed from geeksforgeeks.org
    private String encrypt(String message) {
        try {
            // Generating objects of KeyGenerator & SecretKey
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();

            // Creating object of Cipher
            Cipher desCipher;
            desCipher = Cipher.getInstance("DES");

            // Creating byte array to store string
            byte[] text = message.getBytes("UTF8");

            // Encrypting text
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            byte[] textEncrypted = desCipher.doFinal(text);

            // Converting encrypted byte array to string
            message = new String(textEncrypted);
        } catch (Exception e) {
            System.out.println("Exception");
        }
        return message;
    }
}

