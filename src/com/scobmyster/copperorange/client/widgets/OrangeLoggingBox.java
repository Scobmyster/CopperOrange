package com.scobmyster.copperorange.client.widgets;

import com.google.gwt.user.client.ui.TextArea;

public class OrangeLoggingBox extends TextArea {


    private String componentID;

    public OrangeLoggingBox(String componentID)
    {
        this.componentID = componentID;
    }

    public void logMessage(String message)
    {
        String text = this.getText();
        this.setText(text + "\n" + "Logger:Log--> " + message);
    }

}
