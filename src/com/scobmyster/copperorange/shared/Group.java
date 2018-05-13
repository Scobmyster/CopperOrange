package com.scobmyster.copperorange.shared;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Group implements Serializable
{

    private String groupName = "";
    private String ds_loc = "";
    private String[] groupUsers;

    public String getGroupName()
    {
        return groupName;
    }

    @XmlElement
    public void setGroupName(String name)
    {
        this.groupName = name;
    }

    public String getDs_loc() {
        return ds_loc;
    }

    @XmlElement
    public void setDs_loc(String ds_loc) {
        this.ds_loc = ds_loc;
    }


    public String[] getGroupUsers() {
        return groupUsers;
    }

    @XmlElement
    public void setGroupUsers(String[] groupUsers) {this.groupUsers = groupUsers; }
}
