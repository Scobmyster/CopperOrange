package com.scobmyster.copperorange.client;

import com.google.gwt.user.cellview.client.CellList;
import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;
import com.scobmyster.copperorange.client.widgets.OrangePopupPanel;
import com.scobmyster.copperorange.client.widgets.OrangeTextbox;

public class ScreenModelImpl implements ScreenModel
{
    /*
        -------Objects---------
     */
    private OrangeFlexTable rotaTable;
    private OrangeTextbox saveNameBox;
    private OrangePopupPanel savePop;
    private OrangePopupPanel loadPop;
    private OrangeTextbox loadNameBox;
    private CellList<String> rotaNames;
    private String selectedFileToLoad;

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

    public OrangePopupPanel getLoadPop() {
        return loadPop;
    }

    public void setLoadPop(OrangePopupPanel loadPop) {
        this.loadPop = loadPop;
    }

    public OrangeTextbox getLoadNameBox() {
        return loadNameBox;
    }

    public void setLoadNameBox(OrangeTextbox loadNameBox) {
        this.loadNameBox = loadNameBox;
    }

    public CellList<String> getRotaNames() {
        return rotaNames;
    }

    public void setRotaNames(CellList<String> rotaNames) {
        this.rotaNames = rotaNames;
    }

    public String getSelectedFileToLoad() {
        return selectedFileToLoad;
    }

    public void setSelectedFileToLoad(String selectedFileToLoad) {
        this.selectedFileToLoad = selectedFileToLoad;
    }
}


