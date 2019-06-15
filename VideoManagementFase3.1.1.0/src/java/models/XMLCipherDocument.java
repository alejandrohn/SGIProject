package models;

import com.sun.org.apache.xml.internal.security.encryption.XMLCipher;
import com.sun.org.apache.xml.internal.security.encryption.XMLEncryptionException;
import com.sun.org.apache.xml.internal.security.utils.EncryptionConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.apache.xml.security.stax.ext.XMLSecurityConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLCipherDocument {

    static {
        com.sun.org.apache.xml.internal.security.Init.init();
    }

    public static SecretKey getSecretKey(String algorithm) {
        KeyGenerator keyGenerator = null;

        try {
            keyGenerator = KeyGenerator.getInstance(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyGenerator.generateKey();
    }

    public static Document encryptDocument(Document document, SecretKey secretKey, String algorithm) throws XMLEncryptionException, Exception {
        Element rootElement = document.getDocumentElement();
        String algorithmURI = algorithm;
        XMLCipher xmlCipher = XMLCipher.getInstance(algorithmURI);

        xmlCipher.init(XMLCipher.ENCRYPT_MODE, secretKey);

        Document docEncrypted = xmlCipher.doFinal(document, rootElement);
        return docEncrypted;
    }

    public static Document decryptDocument(Document document, SecretKey secretKey, String algorithm) throws Exception {
        Element encryptedDataElement = (Element) document.getElementsByTagNameNS(EncryptionConstants.EncryptionSpecNS, EncryptionConstants._TAG_ENCRYPTEDDATA).item(0);

        XMLCipher xmlCipher = XMLCipher.getInstance(algorithm);
        xmlCipher.init(XMLCipher.DECRYPT_MODE, secretKey);

        Document descriptedDoc = xmlCipher.doFinal(document, document.getDocumentElement());

        return descriptedDoc;
    }

    public static void saveSecretKey(SecretKey secretKey, String fileName) {
        byte[] keyBytes = secretKey.getEncoded();
        File keyFile = new File(fileName);
        FileOutputStream fOutStream = null;
        try {
            fOutStream = new FileOutputStream(keyFile);
            fOutStream.write(keyBytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fOutStream != null) {
                try {
                    fOutStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
