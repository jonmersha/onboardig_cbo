package cbo.onborading.remote.soap.response;

import cbo.onborading.jpa.entity.Account;
import cbo.onborading.jpa.entity.CustomerData;
import cbo.onborading.utility.XMLNodeElement;
import org.w3c.dom.Node;

import javax.xml.soap.SOAPMessage;

public class CreationResponse {
    public CustomerData customerCreation(SOAPMessage soapMessage, CustomerData customerData) {
        try {
            Node node = new XMLNodeElement().getSoapBody(soapMessage);
            customerData.setStatus(node.getChildNodes().item(0).getChildNodes().item(2).getChildNodes().item(0).getNodeValue());

            if (customerData.getStatus().equals("Success")) {
                String application = node.getChildNodes().item(0).getChildNodes().item(3).getChildNodes().item(0).getNodeValue();
                String shortname = node.getChildNodes().item(1).getChildNodes().item(1).getChildNodes().item(0).getChildNodes().item(0).getNodeValue();
                String fullName = node.getChildNodes().item(1).getChildNodes().item(2).getChildNodes().item(0).getChildNodes().item(0).getNodeValue();

                customerData.setShortName(shortname);
                customerData.setFullName(fullName);
                customerData.setMessages("Customer Created");
                customerData.setCustomerCreated(true);

                customerData.setTransactionID(node.getChildNodes().item(0).getChildNodes().item(0).getChildNodes().item(0).getNodeValue());
                customerData.setAuthorized(false);

                //customerData.setCreatedBuy();
            } else {
                String message = node.getChildNodes().item(0).getChildNodes().item(4).getChildNodes().item(0).getNodeValue();
                customerData.setMessages(message);
                return customerData;
            }
            return customerData;
        }catch (Exception ex){
            customerData.setMessages(ex.getLocalizedMessage());
            return  customerData;
        }
    }
    public Account accountCreation(SOAPMessage soapMessage, Account account){
        try{
            Node node = new XMLNodeElement().getSoapBody(soapMessage);
            String status = node.getChildNodes().item(0).getChildNodes().item(2).getChildNodes().item(0).getNodeValue();
            account.setAccountCreated(true);
            if(status.equals("Success")){
                String AccountNUmber = node.getChildNodes().item(0).getChildNodes().item(0).getChildNodes().item(0).getNodeValue();
                account.setAccountNumber(AccountNUmber);
            }
        }catch (Exception e){

        }
        return account;
    }
    public Account imageCapture(SOAPMessage soapMessage, Account account, String imageType){
        try{

            Node node = new XMLNodeElement().getSoapBody(soapMessage);
            String status = node.getChildNodes().item(0).getChildNodes().item(2).getChildNodes().item(0).getNodeValue();
            //customerAccount.set;
            if(status.equals("Success")){
                String imageId = node.getChildNodes().item(0).getChildNodes().item(0).getChildNodes().item(0).getNodeValue();

                if(imageType.equals("SIGNATURES")){
                    account.setSignatureImageId(imageId);
                }
                else
                    account.setPersonImageId(imageId);
            }

        }catch (Exception e){


        }

        return account;
    }
    public Account imageUpload(SOAPMessage soapMessage, Account account, String imageType){

        try{

            Node node = new XMLNodeElement().getSoapBody(soapMessage);
            String status = node.getChildNodes().item(0).getChildNodes().item(2).getChildNodes().item(0).getNodeValue();

            if(status.equals("Success")){
                String uploadedTransactionID = node.getChildNodes().item(0).getChildNodes().item(0).getChildNodes().item(0).getNodeValue();
                if(imageType.equals("SIGNATURES")){

                    account.setSignatureImageId(uploadedTransactionID);
                    account.setSignatureUploaded(true);
                }
                else
                    account.setPhotoUploaded(true);
                    account.setPersonImageId(uploadedTransactionID);

            }

        }catch (Exception e){


        }
        return account;
    }

}
