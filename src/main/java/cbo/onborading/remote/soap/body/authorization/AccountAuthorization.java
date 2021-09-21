package cbo.onborading.remote.soap.body.authorization;

import cbo.onborading.jpa.entity.CustomerAccount;
import cbo.onborading.model.internal.CoreCredentials;
import cbo.onborading.model.operation.Authorization;

public class AccountAuthorization {
    public static String body(String accountNumber, CoreCredentials requestCredentials) {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cus=\"http://temenos.com/CUSTONBRD\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <cus:ACCOUNTAUTH>\n" +
                "         <WebRequestCommon>\n" +
                "            <company>"+requestCredentials.getCompanyCode()+"</company>\n" +
                "            <password>"+requestCredentials.getCorePassWord()+"</password>\n" +
                "            <userName>"+requestCredentials.getCoreUserName()+"</userName>\n" +
                "         </WebRequestCommon>\n" +
                "         <ACCOUNTAUTHType>\n" +
                "            <transactionId>"+accountNumber+"</transactionId>\n" +
                "         </ACCOUNTAUTHType>\n" +
                "      </cus:ACCOUNTAUTH>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }
    }
