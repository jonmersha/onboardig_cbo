package cbo.onborading.remote.soap.body.creation;

import cbo.onborading.model.internal.CoreCredentials;
import cbo.onborading.model.operation.ImageUpload;

public class ImageUploadSoap {
    static public String body(ImageUpload imageUpload,CoreCredentials credential){

        String soapStructure="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "xmlns:cus=\"http://temenos.com/CUSTONBRD\"\n" +
                "xmlns:imd=\"http://temenos.com/IMDOCUMENTUPLOADCAPTURE\">\n" +
                "\t<soapenv:Header/>\n" +
                "\t<soapenv:Body>\n" +
                "\t\t<cus:IMAGEUPLOAD>\n" +
                "\t\t\t<WebRequestCommon>\n" +
                "\t\t\t\t<company>"+credential.getCompanyCode()+"</company>\n" +
                "\t\t\t\t<password>"+credential.getCorePassWord()+"</password>\n" +
                "\t\t\t\t<userName>"+credential.getCoreUserName()+"</userName>\n" +
                "\t\t\t</WebRequestCommon>\n" +
                "\t\t\t\n" +
                "\t\t\t<OfsFunction>\n" +
                "\t\t\t\t<messageId>"+imageUpload.getMessageId()+"</messageId>\n" +
                "\t\t\t</OfsFunction>\n" +
                "\t\t\t\n" +
                "\t\t\t<IMDOCUMENTUPLOADCAPTUREType id=\""+imageUpload.getImageId()+"\">\n" +
                "\t\t\t\t<imd:ImageId>"+imageUpload.getImageId()+"</imd:ImageId>\n" +
                "\t\t\t\t<imd:UploadImage>"+imageUpload.getImageName()+"</imd:UploadImage>\n" +
                "\t\t\t</IMDOCUMENTUPLOADCAPTUREType>\n" +
                "\t\t</cus:IMAGEUPLOAD>\n" +
                "\t</soapenv:Body>\n" +
                "</soapenv:Envelope>";;
        return soapStructure;
    }
}
