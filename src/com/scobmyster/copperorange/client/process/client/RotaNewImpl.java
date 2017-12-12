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
    private TableBuilder builder = new TableBuilder();


    @Override
    public void runProcess()
    {
        builder.newTable(screenModel.getRotaTable());
    }

    public void setScreenModel(ScreenModelImpl screenModel) {
        this.screenModel = screenModel;
    }

}
