package com.scobmyster.copperorange.client.process.client;

import com.google.gwt.user.client.Window;
import com.scobmyster.copperorange.client.PluggerImpl;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.TableBuilder;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;

public class RotaNewImpl implements ProcessModel
{

    private ScreenModelImpl screenModel = new ScreenModelImpl();
    private TableBuilder builder;


    @Override
    public void runProcess()
    {
        screenModel.getLogBox().logMessage("Running new process");
        builder.newTable(screenModel.getRotaTable());
    }

    public void setScreenModel(ScreenModelImpl screenModel) {
        this.screenModel = screenModel;
    }

    public void setBuilder(TableBuilder builder) { this.builder = builder; }

}
