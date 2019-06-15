package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class CipherContent {

    public static SecretKey getSecretKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        return getSecretKey(getKeyToken());
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

    public static void desencryptFile(SecretKey key, File encriptedFile, File outPutFileDescripted) throws FileNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
        FileInputStream encfis = new FileInputStream(encriptedFile);
        File decfile = outPutFileDescripted;
        int read;
        if (!decfile.exists()) {
            decfile.createNewFile();
        }
        FileOutputStream decfos = new FileOutputStream(decfile);
        Cipher decipher = Cipher.getInstance("AES");
        decipher.init(Cipher.DECRYPT_MODE, key);
        CipherOutputStream cipherOutput = new CipherOutputStream(decfos, decipher);

        while ((read = encfis.read()) != -1) {
            cipherOutput.write(read);
            cipherOutput.flush();
        }
        cipherOutput.close();
    }

    public static void encryptDocument(SecretKey key, File inputFile, File outputFile) throws FileNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
        FileInputStream fis = new FileInputStream(inputFile);
        File outfile = outputFile;
        int read;
        if (!outfile.exists()) {
            outfile.createNewFile();
        }
        FileOutputStream fileOutput = new FileOutputStream(outfile);
        FileInputStream encfis = new FileInputStream(outfile);
        Cipher encipher = Cipher.getInstance("AES");

        encipher.init(Cipher.ENCRYPT_MODE, key);
        CipherInputStream cis = new CipherInputStream(fis, encipher);

        while ((read = cis.read()) != -1) {
            fileOutput.write((char) read);
            fileOutput.flush();
        }
        fileOutput.close();

    }

    
    
    private static String getKeyToken() {
        return "Mary has one cat1";
    }
}
