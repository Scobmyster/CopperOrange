package com.scobmyster.copperorange.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class PluggerImpl
{

    public static void setup(RootPanel root)
    {
        Button pushMe = new Button("Push Me");

        root.add(pushMe);
    }

}
