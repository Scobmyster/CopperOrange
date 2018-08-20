package com.scobmyster.copperorange.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.shared.Envelope;

/**
 * The async counterpart of <code>OrangeService</code>.
 */
public interface OrangeServiceAsync
{
    void saveRota(Envelope envelope, AsyncCallback<Envelope> callback) throws IllegalArgumentException;
    void loadRota(Envelope envelope, AsyncCallback<Envelope> callback) throws IllegalArgumentException;
    void fetchFileNames(Envelope envelope, AsyncCallback<Envelope> callback) throws IllegalArgumentException;
    void login(Envelope envelope, AsyncCallback<Envelope> callback) throws IllegalArgumentException;
    void register(Envelope envelope, AsyncCallback<Envelope> callback) throws IllegalArgumentException;
    void registerGroup(Envelope envelope, AsyncCallback<Envelope> callback) throws IllegalArgumentException;
    void fetchGroupNames(Envelope envelope, AsyncCallback<Envelope> callback) throws IllegalArgumentException;
    void joinGroup(Envelope envelope, AsyncCallback<Envelope> callback) throws IllegalArgumentException;
    void userSetupService(Envelope envelope, AsyncCallback<Envelope> callback) throws IllegalArgumentException;
    void groupFetchMyGroups(Envelope envelope, AsyncCallback<Envelope> callback) throws IllegalArgumentException;
    void groupSwitch(Envelope envelope, AsyncCallback<Envelope> callback) throws IllegalArgumentException;
    void userLinkToRota(Envelope envelope, AsyncCallback<Envelope> callback) throws IllegalArgumentException;
}
