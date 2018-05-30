package com.scobmyster.copperorange.client.process.client;

import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.process.ProcessModel;

public class GroupOpenRegisterPrompt implements ProcessModel
{

    private ScreenModelImpl screenModel;

    @Override
    public void runProcess()
    {
        screenModel.getPop_GroupRegister().center();
    }

    public void setScreenModel(ScreenModelImpl screenModel)
    {
        this.screenModel = screenModel;
    }
}
