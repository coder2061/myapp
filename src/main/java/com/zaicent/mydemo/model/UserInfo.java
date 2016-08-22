package com.zaicent.mydemo.model;

import java.io.Serializable;  

public class UserInfo implements Serializable{  
  
	private static final long serialVersionUID = -4176164431600621160L;
	
	private int id;  
    private String username;  
    private String pswd;  
      
    public UserInfo() {
    	
    }  
  
    public UserInfo(int id, String username, String pswd) {
		super();
		this.id = id;
		this.username = username;
		this.pswd = pswd;
	}

	public int getId() {  
        return id;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
    }  
  
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getPswd() {  
        return pswd;  
    }  
  
    public void setPswd(String pswd) {  
        this.pswd = pswd;  
    }  
  
    @Override  
    public String toString() {  
        return "UserInfo [id=" + id + ", username=" + username + ", pswd="  
                + pswd + "]";  
    }  
  
}  
