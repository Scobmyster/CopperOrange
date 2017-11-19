package com.scobmyster.copperorange.client.process.client;

import com.google.gwt.user.client.Window;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.TableBuilder;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;
import com.scobmyster.copperorange.client.widgets.OrangeTextbox;

public class RotaAddRowImpl implements ProcessModel
{

    private ScreenModelImpl screenModel = new ScreenModelImpl();
    private TableBuilder builder = new TableBuilder();

    @Override
    public void runProcess()
    {
        builder.addRow(screenModel.getRotaTable());
    }

    public ScreenModelImpl getScreenModel() {
        return screenModel;
    }

    public void setScreenModel(ScreenModelImpl screenModel) {
        this.screenModel = screenModel;
    }
}
