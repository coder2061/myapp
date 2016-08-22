package com.zaicent.mydemo.ip;

public class IPv4AcceptFilter implements IPAcceptFilter{
	private static IPAcceptFilter instance = null;
	
	/**
	 * Access Control
	 */
	private IPv4AcceptFilter(){};
	
	/**
	 * Ignore multiple thread sync problem in extreme case
	 */
	public static IPAcceptFilter getInstance(){
		if(instance == null){
			instance = new IPv4AcceptFilter();
		}
		return instance;
	}

	public boolean accept(String ipAddress) {
		return ipAddress != null && ipAddress.indexOf(IPv6KeyWord) == -1;
	}


}
