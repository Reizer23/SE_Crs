package utilities;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.BodyType;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import org.testng.annotations.Test;

public class emailTools {
    private EmailMessage msg=null;
    final String userName="automation.user@frontrunnertechnologies.net";
    final String password="Test4me1";

    @Test
    public void emailSend(){
        String emailFile = System.getProperty("user.dir") + "\\test-output\\ExtentReport.html";
        EmailSession("ucerecer@frontrunnertechnologies.net", "Email Test", "Let's see if is working", emailFile);
        EmailStart("ucerecer@frontrunnertechnologies.net", "Test Email", "It will works (=");
    }

    public void EmailSession(String mailto,String Subject,String EmailBody,String filesource){
        String[] Emailto = mailto.split(",");
        ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
        ExchangeCredentials credentials = new WebCredentials(userName, password);
        service.setCredentials(credentials);
        try {
            service.setUrl(new java.net.URI("https://outlook.office365.com/EWS/Exchange.asmx"));
            this.msg= new EmailMessage(service);
            for (String EmailAdress : Emailto) {
                this.msg.getToRecipients().add(EmailAdress);
            }
            this.msg.setSubject(Subject);
            MessageBody emialbdy = new MessageBody();
            emialbdy.setBodyType(BodyType.HTML);
            emialbdy.setText(EmailBody);
            this.msg.setBody(emialbdy);
            this.msg.getAttachments().addFileAttachment(filesource);
            this.msg.send();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EmailStart(String mailto,String Subject,String EmailBody){
        String[] Emailto = mailto.split(",");
        ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
        ExchangeCredentials credentials = new WebCredentials(userName, password);
        service.setCredentials(credentials);
        try {
            service.setUrl(new java.net.URI("https://outlook.office365.com/EWS/Exchange.asmx"));
            this.msg= new EmailMessage(service);
            for (String EmailAdress : Emailto) {
                this.msg.getToRecipients().add(EmailAdress);
            }
            this.msg.setSubject(Subject);
            MessageBody emialbdy = new MessageBody();
            emialbdy.setBodyType(BodyType.HTML);
            emialbdy.setText(EmailBody);
            this.msg.setBody(emialbdy);
            this.msg.send();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
