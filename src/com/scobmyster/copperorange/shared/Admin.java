package com.scobmyster.copperorange.shared;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="Admins")
@XmlAccessorType(XmlAccessType.FIELD)
public class Admin implements Serializable
{

    private String[] admins = new String[]{};


    public String[] getAdmins()
    {
        return admins;
    }

    public void setAdmins(String[] admins)
    {
        this.admins = admins;
    }

}
