package com.scobmyster.copperorange.client.widgets;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.scobmyster.copperorange.client.ScreenModel;
import com.scobmyster.copperorange.client.ScreenModelImpl;

public class OrangeFlexTable extends FlexTable
{

    private String componentID;
    private ScreenModelImpl screenModel;
    private FlexCellFormatter cellFormatter = this.getFlexCellFormatter();
    private int tableRowCount = 0;
    private int columnCount = 0;


    public OrangeFlexTable(String componentID)
    {
        this.componentID = componentID;
    }

    public void setScreenModel(ScreenModelImpl screenModel)
    {
        this.screenModel = screenModel;
    }
    public ScreenModel getScreenModel()
    {
        return screenModel;
    }


    public void addToRowCount()
    {
        tableRowCount++;
    }

    public void removeFromRowCount()
    {
        tableRowCount--;
    }

    public void setTableRowCount(int tableRowCount)
    {
        this.tableRowCount = (tableRowCount - 1);
    }


    public int getRowCountForTable()
    {
        return this.tableRowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount)
    {
        this.columnCount = columnCount;
    }
}
