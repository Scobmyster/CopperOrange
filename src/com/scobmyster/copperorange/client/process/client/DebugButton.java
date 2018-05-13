package com.scobmyster.copperorange.client.process.client;

import com.google.gwt.user.client.Window;
import com.scobmyster.copperorange.client.process.ProcessModel;

public class DebugButton implements ProcessModel
{


    @Override
    public void runProcess()
    {
        Window.alert("Running handler from new button script");
    }
}
