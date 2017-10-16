package com.scobmyster.copperorange.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import com.scobmyster.copperorange.client.ScreenModel;
import com.scobmyster.copperorange.client.ScreenModelImpl;

public class OrangeFlexTable extends FlexTable
{

    private String componentID;
    private ScreenModelImpl screenModel;
    private FlexCellFormatter cellFormatter = this.getFlexCellFormatter();

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

    public void setup(int col, int row)
    {
        for(int c = 0; c < col; c++)
        {
            for(int r = 0; r < row; r++)
            {

                this.setWidget(c, r, new OrangeTextbox("ID: " + c + r));

                cellFormatter.setColSpan(c, r, 400);
            }
            this.getCellFormatter().addStyleName(c, 0, "tablecolumn");
        }

        this.addStyleName("table");
        this.getRowFormatter().addStyleName(0, "tableheader");
    }



}
