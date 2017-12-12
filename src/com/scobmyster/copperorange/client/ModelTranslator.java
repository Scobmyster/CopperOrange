package com.scobmyster.copperorange.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;
import com.scobmyster.copperorange.client.widgets.OrangeTableCell;
import com.scobmyster.copperorange.shared.Rota;

import java.util.ArrayList;
import java.util.List;

public class ModelTranslator
{

    public Rota translate(ScreenModelImpl screenModel, Rota rota)
    {
        OrangeFlexTable table = screenModel.getRotaTable();
        List<String> text = new ArrayList<>();
        int[] rowpos = new int[table.getCellList().size()];
        int[] colpos = new int[table.getCellList().size()];
        int counter = 0;
        for(OrangeTableCell cell : table.getCellList())
        {
            text.add(cell.getText());
            rowpos[counter] = cell.getRow();
            colpos[counter] = cell.getCol();
            counter++;
        }
        rota.setCellText(text.toArray(new String[0]));
        rota.setRowpos(rowpos);
        rota.setColpos(colpos);
        return rota;
    }

    public ScreenModelImpl translate(Rota rota, ScreenModelImpl screenModel)
    {
        int counter = 0;
        FlexCellFormatter cellFormatter = screenModel.getRotaTable().getFlexCellFormatter();
        //TODO : Find way of clearing the xml file of rows that are deleted by the user after loading a save probably a process call
        int rowLength = rota.getRowpos().length;
        int colLength = rota.getColpos().length;
        Window.alert("This is the number of rows: " + rota.getRowpos()[(rowLength - 1)]);
        Window.alert("This is the number of columns: " + rota.getColpos()[(colLength - 1)]);
        screenModel.getRotaTable().setTableRowCount(rota.getRowpos()[(rowLength - 1)]);
        screenModel.getRotaTable().setColumnCount(rota.getColpos()[(colLength - 1)]);
        for(String text : rota.getCellText())
        {
            OrangeTableCell tCell = new OrangeTableCell("cell", rota.getRowpos()[counter], rota.getColpos()[counter]);
            screenModel.getRotaTable().getCellList().add(tCell);
            tCell.setText(text);
            screenModel.getRotaTable().setWidget(rota.getRowpos()[counter], rota.getColpos()[counter], tCell);
            cellFormatter.setColSpan(rota.getRowpos()[counter], rota.getColpos()[counter], 400);
            counter++;
        }
        return screenModel;
    }

}
