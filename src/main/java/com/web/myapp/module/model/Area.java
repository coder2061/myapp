package com.web.myapp.module.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * JAXB能够使用Jackson对JAXB注解的支持实现(jackson-module-jaxb-annotations)，
 * 既方便生成XML，也方便生成JSON，这样一来可以更好的标志可以转换为JSON对象的JAVA类。
 * 	JDK中JAXB相关的重要Class和Interface：
		JAXBContext类，是应用的入口，用于管理XML/Java绑定信息。
		Marshaller接口，将Java对象序列化为XML数据。
		Unmarshaller接口，将XML数据反序列化为Java对象。
	JDK中JAXB相关的重要Annotation：
		@XmlType，将Java类或枚举类型映射到XML模式类型
		@XmlAccessorType(XmlAccessType.FIELD) ，控制字段或属性的序列化。FIELD表示JAXB将自动绑定Java类中的每个非静态的（static）、非瞬态的（由@XmlTransient标注）字段到XML。其他值还有XmlAccessType.PROPERTY和XmlAccessType.NONE。
		@XmlAccessorOrder，控制JAXB 绑定类中属性和字段的排序。
		@XmlJavaTypeAdapter，使用定制的适配器（即扩展抽象类XmlAdapter并覆盖marshal()和unmarshal()方法），以序列化Java类为XML。
		@XmlElementWrapper ，对于数组或集合（即包含多个元素的成员变量），生成一个包装该数组或集合的XML元素（称为包装器）。
		@XmlRootElement，将Java类或枚举类型映射到XML元素。
		@XmlElement，将Java类的一个属性映射到与属性同名的一个XML元素。
		@XmlAttribute，将Java类的一个属性映射到与属性同名的一个XML属性。
 */
@XmlRootElement(name = "area")
public class Area {
	
	private String country;
	
	private String province;
	
	private String city;
	
	private String county;
	
	private String postcode;
	
	public Area() {
		super();
	}

	public Area(String country, String province, String city, String county, String postcode) {
		super();
		this.country = country;
		this.province = province;
		this.city = city;
		this.county = county;
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	@XmlElement
	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	@XmlElement
	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	@XmlElement
	public void setCounty(String county) {
		this.county = county;
	}

	public String getPostcode() {
		return postcode;
	}

	@XmlElement
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
}
