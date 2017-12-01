package com.scobmyster.copperorange.client.widgets;

import com.google.gwt.user.client.ui.PopupPanel;

public class OrangePopupPanel extends PopupPanel
{

    private String componentID;

    public OrangePopupPanel(String componentID)
    {
        this.componentID = componentID;
    }

    public String getComponentID() {
        return componentID;
    }

    public void setComponentID(String componentID) {
        this.componentID = componentID;
    }
}
