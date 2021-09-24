package cbo.onborading.remote.soap.body.creation;

import cbo.onborading.jpa.entity.Account;
import cbo.onborading.model.internal.CoreCredentials;

public class AccountCreation {
    public static String body(Account accountCreate, CoreCredentials requestCredentials){
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "xmlns:cus=\"http://temenos.com/CUSTONBRD\" xmlns:acc=\"http://temenos.com/ACCOUNTOPENPOC\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <cus:ACCOUNTOPEN>\n" +
                "         <WebRequestCommon>\n" +
                "            <company>"+requestCredentials.getCompanyCode()+"</company>\n" +
                "            <password>"+requestCredentials.getCorePassWord()+"</password>\n" +
                "            <userName>"+requestCredentials.getCoreUserName()+"</userName>\n" +
                "         </WebRequestCommon>\n" +
                "         <OfsFunction>\n" +
                "            <messageId>"+accountCreate.getMessageId()+"</messageId>\n" +
                "         </OfsFunction>\n" +
                "         <ACCOUNTOPENPOCType id=\"\">\n" +
                "            <acc:CustomerID>"+accountCreate.getCustomerID()+"</acc:CustomerID>\n" +
                "            <acc:ProductCode>"+accountCreate.getProductCode()+"</acc:ProductCode>\n" +
                "            <acc:gACCOUNTTITLE1 g=\"1\">\n" +
                "            <acc:AccountName1>"+accountCreate.getAccountName()+"</acc:AccountName1>\n" +
                "            </acc:gACCOUNTTITLE1>\n" +
                "            <acc:gACCOUNTTITLE2 g=\"1\">\n" +
                "            <acc:AccountName2></acc:AccountName2>\n" +
                "            </acc:gACCOUNTTITLE2>\n" +
                "            <acc:gSHORTTITLE g=\"1\">\n" +
                "            <acc:ShortName>"+accountCreate.getShortName()+"</acc:ShortName>\n" +
                "            </acc:gSHORTTITLE>\n" +
                "            <acc:Currency>"+accountCreate.getCurrency()+"</acc:Currency>\n" +
                "            <acc:LimitRef></acc:LimitRef>\n" +
                "            <acc:AccountOfficer></acc:AccountOfficer>\n" +
                "            <acc:LinktoLimitYN></acc:LinktoLimitYN>\n" +
                "            <acc:HVTFlag></acc:HVTFlag>\n" +
                "            <acc:SingleLimitYN></acc:SingleLimitYN>\n" +
                "            <acc:MaximumSubAccount></acc:MaximumSubAccount>\n" +
                "         </ACCOUNTOPENPOCType>\n" +
                "      </cus:ACCOUNTOPEN>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";


    }

}
