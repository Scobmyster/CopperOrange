package com.scobmyster.copperorange.shared;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name="group")
@XmlAccessorType(XmlAccessType.FIELD)
public class Group implements Serializable
{

    private String groupName = "";
    private String ds_loc = "";
    private String[] groupUsers = new String[]{};
    private GroupRoles rolesOfThisGroup = new GroupRoles();

    public String getGroupName()
    {
        return groupName;
    }


    public void setGroupName(String name)
    {
        this.groupName = name;
    }

    public String getDs_loc() {
        return ds_loc;
    }


    public void setDs_loc(String ds_loc) {
        this.ds_loc = ds_loc;
    }


    public String[] getGroupUsers() {
        return groupUsers;
    }


    public void setGroupUsers(String[] groupUsers) {this.groupUsers = groupUsers; }

    public GroupRoles getRolesOfThisGroup()
    {
        return rolesOfThisGroup;
    }

    public void setRolesOfThisGroup(GroupRoles rolesOfThisGroup)
    {
        this.rolesOfThisGroup = rolesOfThisGroup;
    }

}
