package cbo.onborading.remote.soap.response;

import cbo.onborading.jpa.entity.CustomerAccount;
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
    public CustomerAccount accountCreation(SOAPMessage soapMessage,CustomerAccount customerAccount){
        try{
            Node node = new XMLNodeElement().getSoapBody(soapMessage);
            String status = node.getChildNodes().item(0).getChildNodes().item(2).getChildNodes().item(0).getNodeValue();

        }catch (Exception e){

        }
        return customerAccount;
    }
    public CustomerAccount imageCapture(SOAPMessage soapMessage,CustomerAccount customerAccount){

        try{

            Node node = new XMLNodeElement().getSoapBody(soapMessage);
            String status = node.getChildNodes().item(0).getChildNodes().item(2).getChildNodes().item(0).getNodeValue();

        }catch (Exception e){


        }

        return customerAccount;
    }
    public CustomerAccount imageUpload(SOAPMessage soapMessage,CustomerAccount customerAccount){

        try{

            Node node = new XMLNodeElement().getSoapBody(soapMessage);
            String status = node.getChildNodes().item(0).getChildNodes().item(2).getChildNodes().item(0).getNodeValue();

        }catch (Exception e){


        }
        return customerAccount;
    }




}
