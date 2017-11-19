package com.scobmyster.copperorange.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;
import com.scobmyster.copperorange.client.widgets.OrangeTextbox;

public class TableBuilder {

    //5, 4
    public static OrangeFlexTable createTable(int col, int row) {
        OrangeFlexTable fTable = new OrangeFlexTable("rota");
        FlexCellFormatter cellFormatter = fTable.getFlexCellFormatter();
        fTable.setTableRowCount(row);
        fTable.setColumnCount(col);
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                fTable.setWidget(r, c, new OrangeTextbox("tBox"));
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
        fTable.removeFromRowCount();
    }


    public void addRow(OrangeFlexTable fTable)
    {
        fTable.addToRowCount();
        for(int c = 0; c < fTable.getColumnCount(); c++)
        {
            fTable.setWidget(fTable.getRowCountForTable(), c, new OrangeTextbox("tBox"));
            fTable.getFlexCellFormatter().setColSpan(fTable.getRowCountForTable(), c, 400);
        }
    }

}
