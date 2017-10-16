package com.scobmyster.copperorange.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.scobmyster.copperorange.client.widgets.OrangeButton;
import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;

public class PluggerImpl
{

    private static ScreenModelImpl screenModel = new ScreenModelImpl();

    public static void setup(RootPanel root)
    {

        OrangeFlexTable rotaTable = new OrangeFlexTable("rotaTable");
        rotaTable.setScreenModel(screenModel);
        screenModel.setRotaTable(rotaTable);
        rotaTable.setup(6, 6);

        OrangeButton addRow = new OrangeButton("addRow");
        addRow.setText("Add Row");

        OrangeButton removeRow = new OrangeButton("removeRow");
        removeRow.setText("Remove Row");

        OrangeButton pushMe = new OrangeButton("pushMe");
        pushMe.setText("Push Me");

        pushMe.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Window.alert("It's ya birthday!!!");
            }
        });


        root.add(pushMe);
        root.add(rotaTable);
        root.add(addRow);
        root.add(removeRow);
    }

}
