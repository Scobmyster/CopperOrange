package com.scobmyster.copperorange.client;

import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.scobmyster.copperorange.client.widgets.*;



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
    private OrangeLoggingBox logbox;
    private OrangeButton newButton;
    private OrangeButton saveButton;
    private OrangeButton loadButton;
    private OrangeButton addRowButton;
    private OrangeButton removeRowButton;
    private OrangeTextbox usernameBox;
    private OrangePasswordTextbox passwordBox;
    private OrangeButton loginButton;
    private OrangeButton registerButton;
    private OrangePopupPanel loginPop;
    private Label loginErrorLabel;
    private DockPanel mainPanel;
    private Label currentUser;

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

    public OrangeLoggingBox getLogBox() { return logbox; }

    public void setLogbox(OrangeLoggingBox logbox){ this.logbox = logbox; }

    public OrangeButton getNewButton() {
        return newButton;
    }

    public void setNewButton(OrangeButton newButton) {
        this.newButton = newButton;
    }

    public OrangeTextbox getUsernameBox() {
        return usernameBox;
    }

    public void setUsernameBox(OrangeTextbox usernameBox) {
        this.usernameBox = usernameBox;
    }

    public OrangePasswordTextbox getPasswordBox() {
        return passwordBox;
    }

    public void setPasswordBox(OrangePasswordTextbox passwordBox) {
        this.passwordBox = passwordBox;
    }

    public OrangeButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(OrangeButton loginButton) {
        this.loginButton = loginButton;
    }

    public OrangeButton getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(OrangeButton registerButton) {
        this.registerButton = registerButton;
    }

    public OrangePopupPanel getLoginPop() {
        return loginPop;
    }

    public void setLoginPop(OrangePopupPanel loginPop) {
        this.loginPop = loginPop;
    }

    public OrangeButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(OrangeButton saveButton) {
        this.saveButton = saveButton;
    }

    public OrangeButton getLoadButton() {
        return loadButton;
    }

    public void setLoadButton(OrangeButton loadButton) {
        this.loadButton = loadButton;
    }

    public OrangeButton getAddRowButton() {
        return addRowButton;
    }

    public void setAddRowButton(OrangeButton addRowButton) {
        this.addRowButton = addRowButton;
    }

    public OrangeButton getRemoveRowButton() {
        return removeRowButton;
    }

    public void setRemoveRowButton(OrangeButton removeRowButton) {
        this.removeRowButton = removeRowButton;
    }

    public Label getLoginErrorLabel() {
        return loginErrorLabel;
    }

    public void setLoginErrorLabel(Label loginErrorLabel) {
        this.loginErrorLabel = loginErrorLabel;
    }

    public DockPanel getMainPanel()
    {
        return mainPanel;
    }

    public void setMainPanel(DockPanel mainPanel)
    {
        this.mainPanel = mainPanel;
    }

    public Label getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Label currentUser) {
        this.currentUser = currentUser;
    }
}


