package com.lisboa.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmailMessage {
    private SimpleStringProperty subject;
    private SimpleStringProperty sender;
    private SimpleStringProperty recipient;
    private SimpleObjectProperty<SizeInteger> size;
    private SimpleObjectProperty<Date> date;
    private boolean isRead;
    private Message message;
    private List<MimeBodyPart> attachmentList = new ArrayList<>();
    private boolean hasAttachments = false;

    public EmailMessage (String subject, String sender, String recipient, int size, Date data, boolean isRead, Message message){
        this.subject = new SimpleStringProperty(subject);
        this.sender = new SimpleStringProperty(sender);
        this.recipient = new SimpleStringProperty(recipient);
        this.size = new SimpleObjectProperty<SizeInteger>(new SizeInteger(size));
        this.date = new SimpleObjectProperty<Date>(data);
        this.isRead = isRead;
        this.message = message;
    }

    public boolean hasAttachments(){
        return hasAttachments;
    }
    public String getSubject(){
        return this.subject.get();
    }
    public String getSender(){
        return this.sender.get();
    }
    public String getRecipient(){
        return this.recipient.get();
    }
    public SizeInteger getSize(){
        return this.size.get();
    }
    public Date getDate(){
        return this.date.get();
    }
    public boolean isRead(){
        return isRead;
    }
    public void setRead(boolean read){
        isRead = read;
    }
    public Message getMessage(){
        return this.message;
    }
    public List<MimeBodyPart> getAttachmentList(){
        return attachmentList;
    }

    public void addAttachment(MimeBodyPart mdp) {
        hasAttachments = true;
        if (!attachmentList.contains(mdp)){
            attachmentList.add(mdp);
        }
        try {
            System.out.println("Added attach: " +  mdp.getFileName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}