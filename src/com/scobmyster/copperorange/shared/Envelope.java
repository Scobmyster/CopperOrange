package com.scobmyster.copperorange.shared;

import java.util.List;

public interface Envelope
{

    void setRotaModel(Rota rotaModel);
    Rota getRotaModel();
    void setAddress(String address);
    String getAddress();
    String getFileSaveName();
    void setFileSaveName(String fileSaveName);
    String getRotaLoadName();
    void setRotaLoadName(String rotaLoadName);
    List<String> getRotaFileNames();
    void setRotaFileNames(List<String> rotaFileNames);
    User getUserModel();
    void setUserModel(User userModel);
    boolean getUserGreenlight();
    void setUserGreenlight(boolean userGreenlight);
    void setGroupName(String name);
    String getGroupName();
    void setCreated(boolean created);
    boolean getCreated();
    void setSearchPrefix(String searchPrefix);
    String getSearchPrefix();
    List<String> getGroupFileNames();
    void setGroupFileNames(List<String> groupFileNames);
    String getChosenGroupName();
    void setChosenGroupName(String chosenGroupName);
    String getSearchMode();
    void setSearchMode(String mode);
    boolean getSaveForGroup();
    void setSaveForGroup(boolean saveForGroup);
    Group getGroup();
    void setGroup(Group group);
    List<String> getMyGroupNames();
    void setMyGroupNames(List<String> myGroupNames);
    String getRotaLinkName();
    void setRotaLinkName(String rotaLinkName);
    String getRotaID();
    void setRotaID(String rotaID);

}
