package com.scobmyster.copperorange.client;

import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;
import com.scobmyster.copperorange.client.widgets.OrangePopupPanel;
import com.scobmyster.copperorange.client.widgets.OrangeTextbox;

public class ScreenModelImpl implements ScreenModel
{
    /*
        -------Objects---------
     */
    OrangeFlexTable rotaTable;
    OrangeTextbox saveNameBox;
    OrangePopupPanel savePop;

    /*
        -------Getters & Setters--------
     */
    public OrangeFlexTable getRotaTable()
    {
        return rotaTable;
    }

    public void setRotaTable(OrangeFlexTable rotaTable)
    {
        this.rotaTable = rotaTable;
    }

    public OrangeTextbox getSaveNameBox() {
        return saveNameBox;
    }

    public void setSaveNameBox(OrangeTextbox saveNameBox) {
        this.saveNameBox = saveNameBox;
    }

    public OrangePopupPanel getSavePop() {
        return savePop;
    }

    public void setSavePop(OrangePopupPanel savePop) {
        this.savePop = savePop;
    }
}
