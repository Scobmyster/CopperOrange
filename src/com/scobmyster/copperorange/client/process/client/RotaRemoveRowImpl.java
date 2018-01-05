package com.scobmyster.copperorange.client.process.client;

import com.google.gwt.user.client.Window;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.TableBuilder;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.client.widgets.OrangeTableCell;

public class RotaRemoveRowImpl implements ProcessModel
{

    private ScreenModelImpl screenModel = new ScreenModelImpl();
    private  TableBuilder builder;

    @Override
    public void runProcess()
    {
        screenModel.getLogBox().logMessage("Running remove row process");

        screenModel.getLogBox().logMessage("About to list cells before removal");
        for(OrangeTableCell cell : screenModel.getRotaTable().getCellList())
        {
            screenModel.getLogBox().logMessage("Cell: " + cell.getRow() + "," + cell.getCol());
        }
        builder.removeRow(screenModel.getRotaTable());
    }


    public void setScreenModel(ScreenModelImpl screenModel) {
        this.screenModel = screenModel;
    }

    public void setBuilder(TableBuilder builder)
    {
        this.builder = builder;
    }
}
