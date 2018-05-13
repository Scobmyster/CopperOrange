package com.scobmyster.copperorange.client.widgets;

import com.google.gwt.user.client.ui.TextArea;
import com.scobmyster.copperorange.client.ClientSideHandler;

public class OrangeLoggingBox extends TextArea {


    private String componentID;
    private ClientSideHandler handler;

    public OrangeLoggingBox(String componentID, ClientSideHandler handler)
    {
        this.componentID = componentID;
        this.handler = handler;

        handler.setLogBox(this);
    }

    public void logMessage(String message)
    {
        String text = this.getText();
        this.setText(text + "\n" + "Logger:Log--> " + message);
    }

}
