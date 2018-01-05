package com.scobmyster.copperorange.shared;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class User implements Serializable
{
    private String username;
    private String password;
    private String ds_loc;

    public String getUsername()
    {
        return username;
    }
    @XmlElement
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }
    @XmlElement
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getDs_loc()
    {
        return ds_loc;
    }
    @XmlElement
    public void setDs_loc(String ds_loc)
    {
        this.ds_loc = ds_loc;
    }

}
