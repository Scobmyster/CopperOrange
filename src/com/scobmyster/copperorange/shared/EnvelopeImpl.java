package com.scobmyster.copperorange.shared;

import java.io.Serializable;
import java.util.List;

public class EnvelopeImpl implements Envelope, Serializable
{

    private Rota rotaModel = new Rota();
    private User userModel = new User();
    private String address = "";
    private String fileSaveName = "";
    private String rotaLoadName = "";
    private List<String> rotaFileNames;
    private boolean userGreenlight;
    private String groupName = "";
    private boolean created = false;
    private String searchPrefix = "";
    private List<String> groupFileNames;
    private String chosenGroupName = "";
    private String searchMode = "";
    private boolean saveForGroup = false;
    private Group group;
    private List<String> myGroupNames;
    private String rotaLinkName;
    private String rotaID;

    @Override
    public void setRotaModel(Rota rotaModel)
    {
        this.rotaModel = rotaModel;
    }

    @Override
    public Rota getRotaModel()
    {
        return rotaModel;
    }

    @Override
    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getFileSaveName() {
        return fileSaveName;
    }

    @Override
    public void setFileSaveName(String fileSaveName) {
        this.fileSaveName = fileSaveName;
    }

    @Override
    public String getRotaLoadName() {
        return rotaLoadName;
    }

    @Override
    public void setRotaLoadName(String rotaLoadName) {
        this.rotaLoadName = rotaLoadName;
    }

    @Override
    public List<String> getRotaFileNames() {
        return rotaFileNames;
    }

    @Override
    public void setRotaFileNames(List<String> rotaFileNames)
    {
        this.rotaFileNames = rotaFileNames;
    }

    @Override
    public User getUserModel() {
        return userModel;
    }

    @Override
    public void setUserModel(User userModel) {
        this.userModel = userModel;
    }

    @Override
    public boolean getUserGreenlight() {
        return userGreenlight;
    }

    @Override
    public void setUserGreenlight(boolean userGreenlight) {
        this.userGreenlight = userGreenlight;
    }

    @Override
    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    @Override
    public String getGroupName()
    {
        return groupName;
    }

    @Override
    public void setCreated(boolean created)
    {
        this.created = created;
    }

    @Override
    public boolean getCreated()
    {
        return created;
    }

    @Override
    public void setSearchPrefix(String searchPrefix)
    {
        this.searchPrefix = searchPrefix;
    }

    @Override
    public String getSearchPrefix()
    {
        return searchPrefix;
    }

    @Override
    public List<String> getGroupFileNames()
    {
        return groupFileNames;
    }

    @Override
    public void setGroupFileNames(List<String> groupFileNames)
    {
        this.groupFileNames = groupFileNames;
    }

    @Override
    public String getChosenGroupName()
    {
        return chosenGroupName;
    }

    @Override
    public void setChosenGroupName(String chosenGroupName)
    {
        this.chosenGroupName = chosenGroupName;
    }

    @Override
    public String getSearchMode()
    {
        return searchMode;
    }

    @Override
    public void setSearchMode(String searchMode)
    {
        this.searchMode = searchMode;
    }

    @Override
    public boolean getSaveForGroup()
    {
        return saveForGroup;
    }

    @Override
    public void setSaveForGroup(boolean saveForGroup)
    {
        this.saveForGroup = saveForGroup;
    }

    @Override
    public Group getGroup()
    {
        return group;
    }

    @Override
    public void setGroup(Group group)
    {
        this.group = group;
    }

    @Override
    public List<String> getMyGroupNames()
    {
        return myGroupNames;
    }

    @Override
    public void setMyGroupNames(List<String> myGroupNames)
    {
        this.myGroupNames = myGroupNames;
    }

    @Override
    public String getRotaLinkName()
    {
        return rotaLinkName;
    }

    @Override
    public void setRotaLinkName(String rotaLinkName)
    {
        this.rotaLinkName = rotaLinkName;
    }

    @Override
    public String getRotaID()
    {
        return rotaID;
    }

    @Override
    public void setRotaID(String rotaID)
    {
        this.rotaID = rotaID;
    }
}
