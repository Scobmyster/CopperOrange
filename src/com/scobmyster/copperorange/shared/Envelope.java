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

}
