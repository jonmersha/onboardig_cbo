package cbo.onborading.remote.soap.body.authorization;

import cbo.onborading.model.internal.CoreCredentials;

public class CustomerAuthorization {
    public static String  body(String customerId, CoreCredentials coreUser){

        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cus=\"http://temenos.com/CUSTONBRD\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <cus:CUSTOMERAUTH>\n" +
                "         <WebRequestCommon>\n" +
                "            <!--Optional:-->\n" +
                "            <company>"+coreUser.getCompanyCode()+"</company>\n" +
                "            <password>"+coreUser.getCorePassWord()+"</password>\n" +
                "            <userName>"+coreUser.getCoreUserName()+"</userName>\n" +
                "         </WebRequestCommon>\n" +
                "         <!--Optional:-->\n" +
                "         <CUSTOMERNAUType>\n" +
                "            <!--Optional:-->\n" +
                "            <transactionId>"+customerId+"</transactionId>\n" +
                "         </CUSTOMERNAUType>\n" +
                "      </cus:CUSTOMERAUTH>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }

}
