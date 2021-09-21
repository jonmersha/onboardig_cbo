package cbo.onborading.remote.soap.body.authorization;

import cbo.onborading.jpa.entity.CustomerData;
import cbo.onborading.model.internal.CoreCredentials;
import cbo.onborading.model.operation.Authorization;

public class ImageUploadAuthorization {
    static public String body(String transactionID,CoreCredentials credential){


        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cus=\"http://temenos.com/CUSTONBRD\">\n" +
                "\t<soapenv:Header/> \n" +
                "\t<soapenv:Body>\n" +
                "\t\t<cus:IMImageUploadAUTH> \n" +
                "\t\t<WebRequestCommon>\n" +
                "\n" +
                "\t\t\t\t<company>"+credential.getCompanyCode()+"</company>\n" +
                "\t\t\t\t<password>"+credential.getCorePassWord()+"</password>\n" +
                "\t\t\t\t<userName>"+credential.getCoreUserName()+"</userName>\n" +
                "\t</WebRequestCommon>\n" +
                "\n" +
                "\t<IMDOCUMENTUPLOADCAPTUREType>\n" +
                "\n" +
                "\t<transactionId>"+transactionID+"</transactionId> \n" +
                "\t</IMDOCUMENTUPLOADCAPTUREType>\n" +
                "</cus:IMImageUploadAUTH> \n" +
                "</soapenv:Body>\n" +
                "</soapenv:Envelope>";
    }
}
