package cbo.onborading.utility;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class XMLNodeElement {
    public Node getSoapBody(SOAPMessage message) {
        try {
            Node firstElement = getFirstElement(message);
            return firstElement;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public SOAPMessage getSoapMessage(String xml) throws SOAPException, IOException {
        MessageFactory factory = MessageFactory.newInstance();
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        return factory.createMessage(new MimeHeaders(), byteArrayInputStream);
    }
    public Node getFirstElement(SOAPMessage message) throws SOAPException {
        final NodeList childNodes = message.getSOAPBody().getChildNodes();
        Node firstElement = null;
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i) instanceof Element) {
                firstElement =  childNodes.item(i);
                break;
            }
        }
        return firstElement;
    }
}
