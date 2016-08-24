package com.web.myapp.demo.ip;

/**
 * Consider @FunctionalInterface for JDK8
 *
 */
public interface IPAcceptFilter {
	public String IPv6KeyWord = ":";
	public boolean accept(String ipAddress);
}
