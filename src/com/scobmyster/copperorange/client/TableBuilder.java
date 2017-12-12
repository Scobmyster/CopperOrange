package com.scobmyster.copperorange.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;
import com.scobmyster.copperorange.client.widgets.OrangeTableCell;
import com.scobmyster.copperorange.shared.Utils;

public class TableBuilder {

    private  Utils util;

    //5, 4
    public static OrangeFlexTable createTable(int col, int row) {
        OrangeFlexTable fTable = new OrangeFlexTable("rota");
        FlexCellFormatter cellFormatter = fTable.getFlexCellFormatter();
        fTable.setTableRowCount(row);
        fTable.setColumnCount(col);
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                OrangeTableCell cell = new OrangeTableCell("tCell", r, c);
                fTable.setWidget(r, c, cell);
                fTable.getCellList().add(cell);
                cellFormatter.setColSpan(r, c, 400);
                //fTable.getCellFormatter().addStyleName(c, 0, "tablecolumn");
            }

        }
        fTable.addStyleName("table");
        fTable.getRowFormatter().addStyleName(0, "tableheader");

        return fTable;

    }

    public void removeRow(OrangeFlexTable fTable)
    {
        int rowToRemove = adaptNumberToTableCoords(fTable.getTableRowCount());
        Window.alert("Normal Row: " + fTable.getTableRowCount());
        Window.alert("Removing row: " + rowToRemove);
        fTable.removeRow(rowToRemove);
        for(OrangeTableCell cell : fTable.getCellList())
        {
            if(cell.getRow() == rowToRemove)
            {
                fTable.remove(cell);
            }
        }
        fTable.removeFromRowCount();
    }


    public void addRow(OrangeFlexTable fTable)
    {
        fTable.addToRowCount();
        FlexCellFormatter cellFormatter = fTable.getFlexCellFormatter();
        Window.alert("Column Count: " + fTable.getColumnCount());
        for(int c = 0; c <= fTable.getColumnCount(); c++)
        {
            OrangeTableCell cell = new OrangeTableCell("tCell", fTable.getTableRowCount(), c);
            fTable.setWidget(fTable.getTableRowCount(), c, cell);
            fTable.getCellList().add(cell);
            cellFormatter.setColSpan(fTable.getTableRowCount(), c, 400);
        }
    }

    public void newTable(OrangeFlexTable fTable)
    {
        while(fTable.getColumnCount() < fTable.getDefColCount())
        {
        }
        while(fTable.getRowCount() > fTable.getDefRowCount())
        {
            removeRow(fTable);
        }
        for(int i = 0; i < fTable.getCellList().size(); i++)
        {
            fTable.getCellList().get(i).setText("------------");
        }
        Window.alert("New table generated");
    }

    public int adaptNumberToTableCoords(int realNum)
    {
        return (realNum - 1);
    }

    public  int adaptTableCoordsToNumber(int coordNum)
    {
        return (coordNum + 1);
    }

}
