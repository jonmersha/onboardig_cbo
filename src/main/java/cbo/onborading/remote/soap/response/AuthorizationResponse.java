package cbo.onborading.remote.soap.response;

import cbo.onborading.jpa.entity.Account;
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
    public Account accountAuthorization(SOAPMessage soapMessage, Account account){
            try{
                Node node = new XMLNodeElement().getSoapBody(soapMessage);
                String status = node.getChildNodes().item(0).getChildNodes().item(2).getChildNodes().item(0).getNodeValue();
                if(status.equals("Success")){
                    account.setAccountAuthorized(true);
                }
            }catch (Exception e){

            }
        return account;
    }
    public Account imageUploadAuthorization(SOAPMessage soapMessage, Account account, String imageType){

        try{
            Node node = new XMLNodeElement().getSoapBody(soapMessage);
            String status = node.getChildNodes().item(0).getChildNodes().item(2).getChildNodes().item(0).getNodeValue();

            if(status.equals("Success")){
                if(imageType.equals("SIGNATURES"))
                {
                    account.setSignatureAuthorized(true);
                }
                else{
                    account.setPhotoAuthorized(true);
                }
            }

        }catch (Exception e){


        }
        return account;
    }


}
