package com.zaicent.mydemo.ip;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
/**
 * Helper class the get the external net IP address
 */
public class ServerHost {
	/**
	 * Singleton instance
	 */
	private static final ServerHost instance = new ServerHost();
	/**
	 * Access Control
	 */
	private ServerHost(){};
	/**
	 * @return instance
	 */
	public static ServerHost getInstance() {
		return instance;
	}
	
	public String getExtranetIPv4Address(){
		return searchNetworkInterfaces(IPAcceptFilterFactory.getIPv4AcceptFilter());
	}
	
	
	public String getExtranetIPv6Address(){
		return searchNetworkInterfaces(IPAcceptFilterFactory.getIPv6AcceptFilter());
	}
	
	
	public String getExtranetIPAddress(){
		return searchNetworkInterfaces(IPAcceptFilterFactory.getIPAllAcceptFilter());
	}
	
	private String searchNetworkInterfaces(IPAcceptFilter ipFilter){
		try {
			Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
			while (enumeration.hasMoreElements()) {
			    NetworkInterface networkInterface = enumeration.nextElement();
			    //Ignore Loop/virtual/Non-started network interface
	            if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
	                continue;
	            }
		        Enumeration<InetAddress> addressEnumeration = networkInterface.getInetAddresses();
		        while (addressEnumeration.hasMoreElements()) {
		        	InetAddress inetAddress = addressEnumeration.nextElement();
		        	String address = inetAddress.getHostAddress();
		        	if(ipFilter.accept(address)){
		        		return address;
		        	}
		        }
			}
		} catch (SocketException e) {
			//consider log for this exception
		}
		return "";
	}

}
