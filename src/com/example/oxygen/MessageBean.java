package com.example.oxygen;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

public class MessageBean {

	private Uri  PhotoDrawableId;  
    private String MessageName;  
    private String MessageContent;  
    private String MessageTime; 
    
    public MessageBean(){
    }
    
    public MessageBean(Uri photoDrawableId,String messageName,String messageContent,String  messageTime){
    
    	super();
    	PhotoDrawableId = photoDrawableId;
    	MessageName = messageName;
    	//MessageContent = messageContent;
    	//MessageTime = messageTime;
    }
    
    public Uri getPhotoDrawableId(){
    	return PhotoDrawableId;
    }
    
    public void setPhotoDrawableId(Uri mPhotoDrawableId){
    	this.PhotoDrawableId = mPhotoDrawableId;
    }
    
    public String getMessageName(){
    	return MessageName;
    }
    
    public void setMessageName(String messageName){
    	MessageName = messageName;
    }
    
    public String getMessageContent(){
    	return MessageContent;
    }
    
    public void setMessageContent(String messageContent){
    	MessageContent = messageContent;
    }
    
    public String getMessageTime(){
    	return MessageTime;
    }
    
    public void setMessageTime(String messageTime){
    	MessageContent = messageTime;
    }
    
    public String toString() {  
        return "MessageBean [mPhotoDrawableId=" + PhotoDrawableId  
                + ", MessageName=" + MessageName + ", MessageContent="  
                + MessageContent + ", MessageTime=" + MessageTime + "]";
        }
    
    
}
