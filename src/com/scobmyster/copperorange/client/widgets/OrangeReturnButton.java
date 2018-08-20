package com.scobmyster.copperorange.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.scobmyster.copperorange.client.ClientSideHandler;
import com.scobmyster.copperorange.client.ScreenModelImpl;

public class OrangeReturnButton extends Button
{
    private String componentID;
    private ScreenModelImpl screenModel;
    private ClientSideHandler handler = new ClientSideHandler();
    private String eventID = "default";
    private OrangeTableCell sender = new OrangeTableCell("default", 10000000, 10000000);


    public OrangeReturnButton(String componentID)
    {
        this.componentID = componentID;
        this.addStyleName("customButton");
    }

    public OrangeReturnButton(String componentID, ClientSideHandler clientSideHandler, String textForButton, String idPrefix)
    {
        this.componentID = componentID;
        handler = clientSideHandler;
        this.setText(textForButton);
        this.setEventID(idPrefix + componentID);
        this.addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent clickEvent)
            {
                handler.handleEvent(getEventID());
            }
        });
    }

    public OrangeReturnButton(String componentID, ClientSideHandler clientSideHandler, String textForButton)
    {
        this.componentID = componentID;
        handler = clientSideHandler;
        this.setText(textForButton);
        this.setEventID(componentID);
        this.addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent clickEvent)
            {
                handler.handleEvent(getEventID());
            }
        });
    }

    public String getComponentID()
    {
        return componentID;
    }

    public void setComponentID(String componentID)
    {
        this.componentID = componentID;
    }

    public void setScreenModel(ScreenModelImpl screenModel)
    {
        this.screenModel = screenModel;
    }

    public ScreenModelImpl getScreenModel()
    {
        return screenModel;
    }

    public String getEventID()
    {
        return eventID;
    }

    public void setEventID(String eventID)
    {
        this.eventID = eventID;
    }

    public OrangeTableCell getSender()
    {
        return sender;
    }

    public void setSender(OrangeTableCell sender)
    {
        this.sender = sender;
    }
}
