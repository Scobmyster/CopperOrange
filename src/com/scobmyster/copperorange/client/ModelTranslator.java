package com.scobmyster.copperorange.client;

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
        List<Integer> rowpos = new ArrayList<>();
        List<Integer> colpos = new ArrayList<>();
        for(OrangeTableCell cell : table.getCellList())
        {
            text.add(cell.getText());
            rowpos.add(cell.getRow());
            colpos.add(cell.getCol());
        }
        rota.setCellText(text.toArray(new String[0]));
        int[] rotaRowPos = new int[table.getCellList().size()];
        int counter = 0;
        for(Integer i : rowpos)
        {
            rotaRowPos[counter] = i;
            counter++;
        }
        rota.setRowpos(rotaRowPos);
        int[] rotaColPos = new int[table.getCellList().size()];
        int iterator = 0;
        for(Integer i : colpos)
        {
            rotaColPos[iterator] = i;
            counter++;
        }
        rota.setColpos(rotaColPos);
        return rota;
    }

    public ScreenModelImpl translate(Rota rota, ScreenModelImpl screenModel)
    {
        return screenModel;
    }

}
