package com.scobmyster.copperorange.shared;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Link implements Serializable
{
	String linkName;
	String rotaID;
	
	public String getLinkName()
	{
		return linkName;
	}
	
	@XmlAttribute
	public void setLinkName(String linkName)
	{
		this.linkName = linkName;
	}
	
	public String getRotaID()
	{
		return rotaID;
	}
	
	@XmlAttribute
	public void setRotaID(String rotaID)
	{
		this.rotaID = rotaID;
	}
}
