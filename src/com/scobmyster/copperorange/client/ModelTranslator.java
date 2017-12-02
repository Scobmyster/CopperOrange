package com.scobmyster.copperorange.client;

import com.google.gwt.user.client.Window;
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
            Window.alert("Details for cell: " + cell.getText() + " Row: " + cell.getRow() + "Col: " + cell.getCol());
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
        for(String text : rota.getCellText())
        {
            OrangeTableCell tCell = new OrangeTableCell("cell", rota.getRowpos()[counter], rota.getColpos()[counter]);
            tCell.setText(text);
            screenModel.getRotaTable().setWidget(rota.getRowpos()[counter], rota.getColpos()[counter], tCell);
            counter++;
        }
        Window.alert("Hit the translate back to the screen bit I think we will have a problem with");
        return screenModel;
    }

}
