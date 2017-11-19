package com.scobmyster.copperorange.client.widgets;

import com.google.gwt.user.client.ui.TextBox;


public class OrangeTextbox extends TextBox
{

    private String componentID;


    public OrangeTextbox(String componentID)
    {
        this.componentID = componentID;
        this.setText("---------");
    }

}
