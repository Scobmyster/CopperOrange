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
}
