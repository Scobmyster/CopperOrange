package com.scobmyster.copperorange.client;

import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
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
    private OrangeButton loadSelectedButton;
    private OrangeButton loadCancelButton;
    private OrangeButton saveRotaButton;
    private OrangeButton saveCancelButton;
    private OrangeTextbox usernameBox;
    private OrangePasswordTextbox passwordBox;
    private OrangeButton loginButton;
    private OrangeButton registerButton;
    private OrangePopupPanel loginPop;
    private Label loginErrorLabel;
    private SplitLayoutPanel mainPanel;
    private Label currentUser;
    private HorizontalPanel hp;
    private OrangeTextbox groupName;
    private OrangeButton bt_RegisterGroup;
    private OrangeButton bt_CancelRegisterGroup;
    private OrangePopupPanel pop_GroupRegister;
    private OrangePopupPanel pop_FindGroup;
    private OrangeButton bt_SearchForGroups;
    private OrangeButton bt_CancelFindGroup;
    private OrangeTextbox groupSearchBox;
    private OrangeButton bt_JoinGroup;
    private String selectedGroupToLoad;
    private CellList<String> groupNames;
    private OrangeCheckbox ck_SearchAllRotas;
    private OrangeCheckbox ck_SearchUserRotas;
    private OrangeCheckbox ck_SearchGroupRotas;
    private OrangeCheckbox ck_SaveForUser;
    private OrangeCheckbox ck_SaveForGroup;
    private Label currentGroup;
    private String selectedGroupToSwitch;
    private CellList<String> myGroups;
    private OrangeButton bt_switch;
    private OrangeButton bt_switchCancel;
    private OrangePopupPanel pop_SwitchGroup;


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

    public SplitLayoutPanel getMainPanel()
    {
        return mainPanel;
    }

    public void setMainPanel(SplitLayoutPanel mainPanel)
    {
        this.mainPanel = mainPanel;
    }

    public Label getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Label currentUser) {
        this.currentUser = currentUser;
    }

    public OrangeButton getLoadCancelButton() {
        return loadCancelButton;
    }

    public void setLoadCancelButton(OrangeButton loadCancelButton) {
        this.loadCancelButton = loadCancelButton;
    }

    public OrangeButton getLoadSelectedButton() {
        return loadSelectedButton;
    }

    public void setLoadSelectedButton(OrangeButton loadSelectedButton) {
        this.loadSelectedButton = loadSelectedButton;
    }

    public OrangeButton getSaveRotaButton() {
        return saveRotaButton;
    }

    public void setSaveRotaButton(OrangeButton saveRotaButton) {
        this.saveRotaButton = saveRotaButton;
    }

    public OrangeButton getSaveCancelButton() {
        return saveCancelButton;
    }

    public void setSaveCancelButton(OrangeButton saveCancelButton) {
        this.saveCancelButton = saveCancelButton;
    }

    public HorizontalPanel getHp()
    {
        return hp;
    }

    public void setHp(HorizontalPanel hp)
    {
        this.hp = hp;
    }

    public OrangeTextbox getGroupName()
    {
        return groupName;
    }

    public void setGroupName(OrangeTextbox groupName)
    {
        this.groupName = groupName;
    }

    public OrangeButton getBt_RegisterGroup()
    {
        return bt_RegisterGroup;
    }

    public void setBt_RegisterGroup(OrangeButton bt_RegisterGroup)
    {
        this.bt_RegisterGroup = bt_RegisterGroup;
    }

    public OrangeButton getBt_CancelRegisterGroup()
    {
        return bt_CancelRegisterGroup;
    }

    public void setBt_CancelRegisterGroup(OrangeButton bt_CancelRegisterGroup)
    {
        this.bt_CancelRegisterGroup = bt_CancelRegisterGroup;
    }

    public OrangePopupPanel getPop_GroupRegister()
    {
        return pop_GroupRegister;
    }

    public void setPop_GroupRegister(OrangePopupPanel pop_GroupRegister)
    {
        this.pop_GroupRegister = pop_GroupRegister;
    }

    public OrangePopupPanel getPop_FindGroup()
    {
        return pop_FindGroup;
    }

    public void setPop_FindGroup(OrangePopupPanel pop_FindGroup)
    {
        this.pop_FindGroup = pop_FindGroup;
    }

    public OrangeButton getBt_SearchForGroups()
    {
        return bt_SearchForGroups;
    }

    public void setBt_SearchForGroups(OrangeButton bt_SearchForGroups)
    {
        this.bt_SearchForGroups = bt_SearchForGroups;
    }

    public OrangeButton getBt_CancelFindGroup()
    {
        return bt_CancelFindGroup;
    }

    public void setBt_CancelFindGroup(OrangeButton bt_CancelFindGroup)
    {
        this.bt_CancelFindGroup = bt_CancelFindGroup;
    }

    public OrangeTextbox getGroupSearchBox()
    {
        return groupSearchBox;
    }

    public void setGroupSearchBox(OrangeTextbox groupSearchBox)
    {
        this.groupSearchBox = groupSearchBox;
    }

    public OrangeButton getBt_JoinGroup()
    {
        return bt_JoinGroup;
    }

    public void setBt_JoinGroup(OrangeButton bt_JoinGroup)
    {
        this.bt_JoinGroup = bt_JoinGroup;
    }

    public String getSelectedGroupToLoad()
    {
        return selectedGroupToLoad;
    }

    public void setSelectedGroupToLoad(String selectedGroupToLoad)
    {
        this.selectedGroupToLoad = selectedGroupToLoad;
    }

    public CellList<String> getGroupNames()
    {
        return groupNames;
    }

    public void setGroupNames(CellList<String> groupNames)
    {
        this.groupNames = groupNames;
    }

    public OrangeCheckbox getCk_SearchAllRotas()
    {
        return ck_SearchAllRotas;
    }

    public OrangeCheckbox getCk_SearchUserRotas()
    {
        return ck_SearchUserRotas;
    }

    public OrangeCheckbox getCk_SearchGroupRotas()
    {
        return ck_SearchGroupRotas;
    }

    public void setCk_SearchAllRotas(OrangeCheckbox ck_SearchAllRotas)
    {
        this.ck_SearchAllRotas = ck_SearchAllRotas;
    }

    public void setCk_SearchUserRotas(OrangeCheckbox ck_SearchUserRotas)
    {
        this.ck_SearchUserRotas = ck_SearchUserRotas;
    }

    public void setCk_SearchGroupRotas(OrangeCheckbox ck_SearchGroupRotas)
    {
        this.ck_SearchGroupRotas = ck_SearchGroupRotas;
    }

    public OrangeCheckbox getCk_SaveForGroup()
    {
        return ck_SaveForGroup;
    }

    public void setCk_SaveForGroup(OrangeCheckbox ck_SaveForGroup)
    {
        this.ck_SaveForGroup = ck_SaveForGroup;
    }

    public Label getCurrentGroup()
    {
        return currentGroup;
    }

    public void setCurrentGroup(Label currentGroup)
    {
        this.currentGroup = currentGroup;
    }

    public String getSelectedGroupToSwitch()
    {
        return selectedGroupToSwitch;
    }

    public void setSelectedGroupToSwitch(String selectedGroupToSwitch)
    {
        this.selectedGroupToSwitch = selectedGroupToSwitch;
    }

    public CellList<String> getMyGroups()
    {
        return myGroups;
    }

    public void setMyGroups(CellList<String> myGroups)
    {
        this.myGroups = myGroups;
    }

    public OrangeButton getBt_switch()
    {
        return bt_switch;
    }

    public void setBt_switch(OrangeButton bt_switch)
    {
        this.bt_switch = bt_switch;
    }

    public OrangeButton getBt_switchCancel()
    {
        return bt_switchCancel;
    }

    public void setBt_switchCancel(OrangeButton bt_switchCancel)
    {
        this.bt_switchCancel = bt_switchCancel;
    }

    public OrangePopupPanel getPop_SwitchGroup()
    {
        return pop_SwitchGroup;
    }

    public void setPop_SwitchGroup(OrangePopupPanel pop_SwitchGroup)
    {
        this.pop_SwitchGroup = pop_SwitchGroup;
    }
}


