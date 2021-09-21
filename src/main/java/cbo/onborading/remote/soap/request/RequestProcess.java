package cbo.onborading.remote.soap.request;

import cbo.onborading.utility.Collections;

import javax.xml.soap.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class RequestProcess {
    public SOAPMessage soapRequest(String soapMessage){
        SOAPConnectionFactory soapConnectionFactory = null;
        try {
            soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            SOAPMessage responseMassage=soapConnection.call(Collections.getSoapMessageFromString(soapMessage), Collections.ON_BOARDING_URL);
            return responseMassage;
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
