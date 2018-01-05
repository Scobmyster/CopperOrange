package com.scobmyster.copperorange.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;
import com.scobmyster.copperorange.client.widgets.OrangeLoggingBox;
import com.scobmyster.copperorange.client.widgets.OrangeTableCell;
import com.scobmyster.copperorange.shared.Utils;

public class TableBuilder {

    private  Utils util;
    private OrangeLoggingBox logbox;

    //5, 4
    public  OrangeFlexTable createTable(int col, int row)
    {
        OrangeFlexTable fTable = new OrangeFlexTable("rota");
        FlexCellFormatter cellFormatter = fTable.getFlexCellFormatter();
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
        int highestRow = 0;
        int highestColumn = 0;
        for(OrangeTableCell cell : fTable.getCellList())
        {
            if(cell.getRow() > highestRow)
            {
                highestRow = cell.getRow();
            }
            if(cell.getCol() > highestColumn)
            {
                highestColumn = cell.getCol();
            }
        }
        fTable.setTableRowCount(highestRow);
        fTable.setColumnCount(highestColumn + 1);
        logbox.logMessage("Table Row Count: " + fTable.getTableRowCount() + " Table Col Count: " + fTable.getColumnCount());

        return fTable;

    }

    public void removeRow(OrangeFlexTable fTable) {

        logbox.logMessage("Inside remove row method");
        int counter = 0;
        logbox.logMessage("Table Row Count: " + fTable.getTableRowCount());
        OrangeTableCell[] cells = fTable.getCellList().toArray(new OrangeTableCell[0]);
        for(int i = 0; i < cells.length; i++)
        {
            //logbox.logMessage("Cell: " + cells[i].getRow() + "," + cells[i].getCol());
            if(cells[i].getRow() == fTable.getTableRowCount())
            {
                fTable.remove(cells[i]);
                fTable.getCellList().remove(cells[i]);
                counter++;
            }
        }
       //logbox.logMessage("Amount of times we hit a cell to remove: " + counter);
        //fTable.removeRow(fTable.getTableRowCount());
        fTable.removeFromRowCount();
    }


    public void addRow(OrangeFlexTable fTable)
    {
        fTable.addToRowCount();
        FlexCellFormatter cellFormatter = fTable.getFlexCellFormatter();
        for(int c = 0; c < fTable.getColumnCount(); c++)
        {
            OrangeTableCell cell = new OrangeTableCell("tCell", fTable.getTableRowCount(), c);
            fTable.setWidget(fTable.getTableRowCount(), c, cell);
            fTable.getCellList().add(cell);
            cellFormatter.setColSpan(fTable.getTableRowCount(), c, 400);
        }
    }

    public void newTable(OrangeFlexTable fTable)
    {
        logbox.logMessage("Creating new table");
        logbox.logMessage("Removing rows");
        while(fTable.getTableRowCount() >= fTable.getDefRowCount())
        {
            logbox.logMessage("Row count: " + fTable.getTableRowCount());
            logbox.logMessage("Def row count: " + fTable.getDefRowCount());
            removeRow(fTable);
        }
        logbox.logMessage("Removing text");
        for(int i = 0; i < fTable.getCellList().size(); i++)
        {
            fTable.getCellList().get(i).setText("------------");
        }
       logbox.logMessage("New table generated");
       logbox.logMessage("Cell list size from new table: " + fTable.getCellList().size());
    }

    public void setLogbox(OrangeLoggingBox logbox)
    {
        this.logbox = logbox;
    }
}
