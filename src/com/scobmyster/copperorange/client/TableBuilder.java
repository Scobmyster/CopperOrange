package com.scobmyster.copperorange.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;
import com.scobmyster.copperorange.client.widgets.OrangeTableCell;

public class TableBuilder {

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
                fTable.getCellFormatter().addStyleName(c, 0, "tablecolumn");
            }

        }
        fTable.addStyleName("table");
        fTable.getRowFormatter().addStyleName(0, "tableheader");

        return fTable;

    }

    public void removeRow(OrangeFlexTable fTable)
    {
        fTable.removeRow(fTable.getRowCountForTable());
        for(OrangeTableCell cell : fTable.getCellList())
        {
            if(cell.getRow() == fTable.getRowCountForTable())
                fTable.getCellList().remove(cell);
        }
        fTable.removeFromRowCount();
    }


    public void addRow(OrangeFlexTable fTable)
    {
        fTable.addToRowCount();
        for(int c = 0; c < fTable.getColumnCount(); c++)
        {
            OrangeTableCell cell = new OrangeTableCell("tCell", fTable.getRowCountForTable(), c);
            fTable.setWidget(fTable.getRowCountForTable(), c, cell);
            fTable.getCellList().add(cell);
            fTable.getFlexCellFormatter().setColSpan(fTable.getRowCountForTable(), c, 400);
        }
    }

    public void newTable(OrangeFlexTable fTable)
    {
        while(fTable.getColumnCount() < fTable.getDefColCount())
        {
            Window.alert("Should remove a column");
        }
        while(fTable.getRowCount() >= fTable.getDefRowCount())
        {
            Window.alert("Row count: " + fTable.getRowCount());
            Window.alert("Def count: " + fTable.getDefRowCount());
            removeRow(fTable);
        }
        for(OrangeTableCell cell : fTable.getCellList())
        {
            cell.setText("------------");
        }
        Window.alert("New table generated");
    }

}
