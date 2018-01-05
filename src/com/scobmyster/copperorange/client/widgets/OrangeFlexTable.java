package com.scobmyster.copperorange.client.widgets;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.scobmyster.copperorange.client.ScreenModel;
import com.scobmyster.copperorange.client.ScreenModelImpl;

import java.util.ArrayList;
import java.util.List;

public class OrangeFlexTable extends FlexTable
{

    private String componentID;
    private ScreenModelImpl screenModel;
    private int tableRowCount = 0;
    private int columnCount = 0;
    private int defColCount = 5;
    private int defRowCount = 1;
    private List<OrangeTableCell> cellList = new ArrayList();



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
        this.tableRowCount = tableRowCount;
    }

    public List<OrangeTableCell> getCellList()
    {
        return cellList;
    }


    public int getTableRowCount()
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

    public String getComponentID() {
        return componentID;
    }

    public void setComponentID(String componentID) {
        this.componentID = componentID;
    }

    public int getDefColCount() {
        return defColCount;
    }

    public void setDefColCount(int defColCount) {
        this.defColCount = defColCount;
    }

    public int getDefRowCount() {
        return defRowCount;
    }

    public void setDefRowCount(int defRowCount) {
        this.defRowCount = defRowCount;
    }
}
