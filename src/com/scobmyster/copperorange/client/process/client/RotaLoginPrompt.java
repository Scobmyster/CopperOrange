package com.scobmyster.copperorange.client.process.client;

import com.google.gwt.user.client.Window;
import com.scobmyster.copperorange.client.ScreenModel;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.client.widgets.OrangeLoggingBox;

public class RotaLoginPrompt implements ProcessModel
{

    private ScreenModelImpl screenModel;
    private OrangeLoggingBox logbox;

    @Override
    public void runProcess()
    {
        logbox.logMessage("Loading login prompt");
        screenModel.getLoginPop().center();
        disableScreen();
    }

    public void setScreenModel(ScreenModelImpl screenModel)
    {
        this.screenModel = screenModel;
    }

    public void setLogbox(OrangeLoggingBox logbox)
    {
        this.logbox = logbox;
    }

    public void disableScreen()
    {

    }
}

