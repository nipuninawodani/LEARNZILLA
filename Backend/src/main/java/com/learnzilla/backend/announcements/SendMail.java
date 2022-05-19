package com.learnzilla.backend.announcements;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class SendMail {
    public static void main(String[] args) throws IOException{

        Email from = new Email("sacintharakaedu@gmail.com");
        Email to = new Email("sacintharakaedu@gmail.com");
        String subject = "Sending with sendgrid test mail";
        Content content = new Content("text/plain", "An easy to send email via send grid API");
        Mail mail = new Mail(from,subject,to,content);

        SendGrid sg = new SendGrid(System.getenv("spring API key"));
        Request request = new Request();

        try{
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        }catch (IOException e){
            throw e;
        }

    }
}
