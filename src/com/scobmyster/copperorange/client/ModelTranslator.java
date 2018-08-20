package com.scobmyster.copperorange.client;

import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;
import com.scobmyster.copperorange.client.widgets.OrangeLoggingBox;
import com.scobmyster.copperorange.client.widgets.OrangeTableCell;
import com.scobmyster.copperorange.shared.Rota;
import com.scobmyster.copperorange.shared.User;

import java.util.ArrayList;
import java.util.List;

public class ModelTranslator
{



    public Rota translate(ScreenModelImpl screenModel, Rota rota)
    {
        OrangeLoggingBox logbox = screenModel.getLogBox();
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
        OrangeLoggingBox logbox = screenModel.getLogBox();
        int counter = 0;
        FlexCellFormatter cellFormatter = screenModel.getRotaTable().getFlexCellFormatter();
        int rowLength = rota.getRowpos().length;
        int colLength = rota.getColpos().length;
        screenModel.getRotaTable().setTableRowCount(rota.getRowpos()[(rowLength - 1)]);
        int columnCount = rota.getColpos()[(colLength - 1)] + 1;
        screenModel.getRotaTable().setColumnCount(columnCount);
        screenModel.getRotaTable().getCellList().clear();

        for(String text : rota.getCellText())
        {
            OrangeTableCell tCell = new OrangeTableCell("cell", rota.getRowpos()[counter], rota.getColpos()[counter]);
            tCell.addMouseListener(new ToolTipListener("Link Me", 5000, "toolTip"));
            screenModel.getRotaTable().getCellList().add(tCell);
            tCell.setText(text);
            screenModel.getRotaTable().setWidget(rota.getRowpos()[counter], rota.getColpos()[counter], tCell);
            cellFormatter.setColSpan(rota.getRowpos()[counter], rota.getColpos()[counter], 400);
            counter++;
        }



        return screenModel;
    }

    public User translate(ScreenModelImpl screenModel, User user)
    {
        OrangeLoggingBox logbox = screenModel.getLogBox();
        logbox.logMessage("Translating into user model");
        user.setUsername(screenModel.getUsernameBox().getText());
        user.setPassword(screenModel.getPasswordBox().getText());
        return user;
    }


}
