package com.scobmyster.copperorange.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Group Roles")
@XmlAccessorType(XmlAccessType.FIELD)
public class GroupRoles implements Serializable
{

    private Member members = new Member();
    private Admin admins = new Admin();

    public Member getMembers()
    {
        return members;
    }

    public void setMembers(Member members)
    {
        this.members = members;
    }

    public Admin getAdmins()
    {
        return admins;
    }

    public void setAdmins(Admin admins)
    {
        this.admins = admins;
    }
}
