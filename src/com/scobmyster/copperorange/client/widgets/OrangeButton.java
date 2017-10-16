package com.scobmyster.copperorange.client.widgets;

import com.google.gwt.user.client.ui.Button;
import com.scobmyster.copperorange.client.ScreenModelImpl;

public class OrangeButton extends Button
{
    private String componentID;
    private ScreenModelImpl screenModel;


    public OrangeButton(String componentID)
    {
        this.componentID = componentID;
        this.addStyleName("customButton");
    }

    public void setScreenModel(ScreenModelImpl screenModel)
    {
        this.screenModel = screenModel;
    }
    public ScreenModelImpl getScreenModel()
    {
        return screenModel;
    }
}
