package com.scobmyster.copperorange.client.process.client;

import com.google.gwt.user.client.Window;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.client.widgets.OrangeLoggingBox;

public class RotaCancelLoadRotaImpl implements ProcessModel
{

    private ScreenModelImpl screenModel;
    private OrangeLoggingBox logbox;

    @Override
    public void runProcess()
    {
        logbox.logMessage("Running close process on load popup");
        screenModel.getLoadPop().hide();
    }

    public void setScreenModel(ScreenModelImpl screenModel) {
        this.screenModel = screenModel;
    }

    public void setLogBox(OrangeLoggingBox logbox)
    {
        this.logbox = logbox;
    }
}
