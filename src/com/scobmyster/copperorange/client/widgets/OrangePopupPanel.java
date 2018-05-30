package com.scobmyster.copperorange.client.widgets;

import com.google.gwt.user.client.ui.PopupPanel;

import java.util.ArrayList;
import java.util.List;

public class OrangePopupPanel extends PopupPanel
{

    private String componentID;
    private List<OrangeButton> bt_collection = new ArrayList<>();

    public OrangePopupPanel(String componentID)
    {
        this.componentID = componentID;
    }

    public OrangePopupPanel(String componentID, boolean visible, String size)
    {
        this.componentID = componentID;
        this.setVisible(visible);
        this.setSize(size, size);
    }

    public String getComponentID() {
        return componentID;
    }

    public void setComponentID(String componentID) {
        this.componentID = componentID;
    }

    public List<OrangeButton> getBt_collection() {
        return bt_collection;
    }

    public void setBt_collection(List<OrangeButton> bt_collection) {
        this.bt_collection = bt_collection;
    }
}
