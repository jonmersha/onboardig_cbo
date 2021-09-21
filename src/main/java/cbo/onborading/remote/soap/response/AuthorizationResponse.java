package cbo.onborading.remote.soap.response;

import cbo.onborading.jpa.entity.CustomerAccount;
import cbo.onborading.jpa.entity.CustomerData;
import cbo.onborading.utility.XMLNodeElement;
import org.w3c.dom.Node;

import javax.xml.soap.SOAPMessage;

public class AuthorizationResponse {
    public CustomerData customerAuthorization(SOAPMessage soapMessage, CustomerData cd) {
        try {
            Node node = new XMLNodeElement().getSoapBody(soapMessage);
            String status = node.getChildNodes().item(0).getChildNodes().item(2).getChildNodes().item(0).getNodeValue();
            if(status.equals("Success"))
                cd.setAuthorized(true);
            return cd;
        }
        catch (Exception ex){

            return cd;
        }

    }
    public CustomerAccount accountAuthorization(SOAPMessage soapMessage,CustomerAccount customerAccount){
            try{

                Node node = new XMLNodeElement().getSoapBody(soapMessage);
                String status = node.getChildNodes().item(0).getChildNodes().item(2).getChildNodes().item(0).getNodeValue();

            }catch (Exception e){


            }

        return customerAccount;
    }
    public CustomerAccount imageUploadAuthorization(SOAPMessage soapMessage,CustomerAccount customerAccount){

        try{

            Node node = new XMLNodeElement().getSoapBody(soapMessage);
            String status = node.getChildNodes().item(0).getChildNodes().item(2).getChildNodes().item(0).getNodeValue();

        }catch (Exception e){


        }
        return customerAccount;
    }


}
