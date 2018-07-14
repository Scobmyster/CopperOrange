package com.scobmyster.copperorange.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="Members")
@XmlAccessorType(XmlAccessType.FIELD)
public class Member implements Serializable
{
    private String[] members = new String[]{};


    public String[] getMembers()
    {
        return members;
    }

    public void setMembers(String[] members)
    {
        this.members = members;
    }
}
