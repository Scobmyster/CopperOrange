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


}
