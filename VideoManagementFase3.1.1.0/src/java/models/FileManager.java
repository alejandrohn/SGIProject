/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class FileManager {

    public static Document getElementFromFile(String filename) throws SAXException, ParserConfigurationException, IOException {
        File fXmlFile = new File(filename);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        return doc;
    }

    public static void saveDocumentTo(Document document, String fileName)
            throws Exception {
        File encryptionFile = new File(fileName);
        FileOutputStream fOutStream = new FileOutputStream(encryptionFile);

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(fOutStream);
        transformer.transform(source, result);

        fOutStream.close();
    }

    public static Document getDocumentFromEncryptedXML(String filePath) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factoryDocument = DocumentBuilderFactory.newInstance();

        factoryDocument.setNamespaceAware(true);
        DocumentBuilder builder = factoryDocument.newDocumentBuilder();
        Document document = builder.parse(new File(filePath));
        return document;
    }

    public static String keyToString(SecretKey secretKey) {
        /* Get key in encoding format */
        byte encoded[] = secretKey.getEncoded();
        String encodedKey = Base64.getEncoder().encodeToString(encoded);

        return encodedKey;
    }

    public static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return Base64.getEncoder().encodeToString(encoded);
    }

    public static boolean existFile(String filename) {
        File tmpDir = new File(filename);
        boolean existDoc = tmpDir.exists();
        return existDoc;
    }

}
