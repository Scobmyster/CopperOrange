package com.scobmyster.copperorange.client.process.client;

import com.google.gwt.user.client.Window;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.TableBuilder;
import com.scobmyster.copperorange.client.process.ProcessModel;

public class RotaRemoveRowImpl implements ProcessModel
{

    private ScreenModelImpl screenModel = new ScreenModelImpl();
    private  TableBuilder builder = new TableBuilder();

    @Override
    public void runProcess()
    {
        builder.removeRow(screenModel.getRotaTable());
    }


    public void setScreenModel(ScreenModelImpl screenModel) {
        this.screenModel = screenModel;
    }
}
