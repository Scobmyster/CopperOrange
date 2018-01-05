package com.scobmyster.copperorange.client.widgets;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextBox;

public class OrangeTableCell extends TextBox
{

    private String componentID;
    private int row;
    private int col;
    private ClickHandler handler = new ClickHandler()
    {
        @Override
        public void onClick(ClickEvent clickEvent)
        {

        }
    };


    public OrangeTableCell(String componentID, int row, int col)
    {
        this.componentID = componentID;
        this.row = row;
        this.col = col;
        this.setText("------------");
        this.addClickHandler(handler);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
