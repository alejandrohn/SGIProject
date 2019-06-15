package models;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.org.apache.xml.internal.security.encryption.XMLCipher;
import java.io.File;

//import org.apache.xml.security.encryption.XMLCipher;
//import org.apache.xml.security.encryption.XMLEncryptionException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class EncryptResource {

    static final String BASE_PATH = "C:/Users/alejandro/Documents/documentsXML/";

    static {
        com.sun.org.apache.xml.internal.security.Init.init();
    }

    public static void encryptDocument(String fileToEncrypt) throws Exception {
        String pathOfFileToScript = getPathOFile(fileToEncrypt);
        if (FileManager.existFile(pathOfFileToScript)) {

            String fileForSecretKey = getPathForSecretKey(pathOfFileToScript);
            String encryptedFile = getPathForEncryptedDocument(pathOfFileToScript);

            //SecretKey secretKey = XMLCipherDocument.getSecretKey("AES");
            //XMLCipherDocument.saveSecretKey(secretKey, fileForSecretKey);

            SecretKey secretKey = getSecretKey(getKeyToken());
            Document document = FileManager.getElementFromFile(pathOfFileToScript);
            Document encryptedDoc = XMLCipherDocument.encryptDocument(document, secretKey,
                    XMLCipher.AES_128);
            FileManager.saveDocumentTo(encryptedDoc, encryptedFile);
        }
    }

    public static void desencryptDocument(String fileToEncrypt) throws Exception {
        String pathOfFileToScript = getPathOFile(fileToEncrypt);
        if (FileManager.existFile(pathOfFileToScript)) {
            
            String desencryptedFile = getPathForDesencryptedDocument(pathOfFileToScript);
            String encryptedDoc1 = getPathForEncryptedDocument(pathOfFileToScript);
            
            SecretKey secretKey = getSecretKey(getKeyToken());
            Document document = FileManager.getDocumentFromEncryptedXML(encryptedDoc1);

            Document decryptedDoc = XMLCipherDocument.decryptDocument(document,
                    secretKey, XMLCipher.AES_128);
           FileManager.saveDocumentTo(decryptedDoc, desencryptedFile);
        }
    }

    private static String getPathForSecretKey(String pathOfFileToScript) {
        return pathOfFileToScript + "_secretKey.txt";
    }

    private static String getPathForEncryptedDocument(String pathOfFileToScript) {
        return pathOfFileToScript + "_encrypted.xml";
    }

    private static String getPathForDesencryptedDocument(String pathOfFileToScript) {
        return pathOfFileToScript + "_desencrypted.xml";
    }

    private static String getPathOFile(String filename) {
        return BASE_PATH + filename;
    }
    
    private static SecretKey getSecretKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = new byte[8];
        SecretKeyFactory factory = SecretKeyFactory
                .getInstance("PBKDF2WithHmacSHA1");
        KeySpec keySpec = new PBEKeySpec(key.toCharArray(), salt, 65536,
                256);
        SecretKey secretKey = factory.generateSecret(keySpec);
        SecretKey secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
        return secret;
    }
    
      private static String getKeyToken() {
        return "Mary has one cat1";
    }

}
