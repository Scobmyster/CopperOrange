package com.scobmyster.copperorange.client.process.client;

import com.google.gwt.user.client.Window;
import com.scobmyster.copperorange.client.ClientSideHandler;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.process.ProcessModel;

public class GroupOpenSwitchPrompt implements ProcessModel
{

    private ScreenModelImpl screenModel;
    private ClientSideHandler handler;

    @Override
    public void runProcess()
    {
        Window.alert("Running switch group setup");
        handler.handleEvent("fetchMyGroups");
        screenModel.getPop_SwitchGroup().center();
    }

    public void setScreenModel(ScreenModelImpl screenModel)
    {
        this.screenModel = screenModel;
    }

    public void setHandler(ClientSideHandler handler) { this.handler = handler; }
}
