package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Pattern;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class DigitalContent {

    private static final String BASE_PATH = "C:/Users/alejandro/Documents/documentsXML/digitalContent/";
    
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    private static final String ENCRIPTED_MARK = "_encripted";
    private static final String DESCRIPTED_MARK = "_desencripted";

    public static void encriptedFile(String fileName) throws FileNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, InvalidKeySpecException {

        File encryptionFile = new File(getFileToEncryptPath(fileName));
        File encryptedFile = new File(getEncryptedFilePath(fileName));

        SecretKey key = CipherContent.getSecretKey();
        CipherContent.encryptDocument(key, encryptionFile, encryptedFile);
    }

    public static void descriptedFile(String fileName) throws FileNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, InvalidKeySpecException {
        File encryptedFile = new File(getEncryptedFilePath(fileName));
        File descriptedFile = new File(getDesencriptedFilePath(fileName));

        SecretKey key = CipherContent.getSecretKey();
        CipherContent.desencryptFile(key, encryptedFile, descriptedFile);
    }

    private static String getEncryptedFilePath(String fileName) {
        return BASE_PATH + fileName + ENCRIPTED_MARK;
    }

    private static String getFileToEncryptPath(String fileName) {
        return BASE_PATH + fileName;
    }

    private static String getDesencriptedFilePath(String fileName) {
        return BASE_PATH + fileName + DESCRIPTED_MARK + "." + getExtensionOfFile(fileName);
    }

    private static String getExtensionOfFile(String filename) {
        String[] segments = filename.split(Pattern.quote("."));
        return segments[segments.length -1];
    }

}
