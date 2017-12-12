package com.scobmyster.copperorange.client.process.client;

import com.google.gwt.user.client.Window;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.process.ProcessModel;

public class RotaGetSaveName implements ProcessModel
{

    private ScreenModelImpl screenmodel = new ScreenModelImpl();

    @Override
    public void runProcess()
    {
        screenmodel.getSavePop().center();
    }


    public void setScreenmodel(ScreenModelImpl screenmodel) {
        this.screenmodel = screenmodel;
    }
}
