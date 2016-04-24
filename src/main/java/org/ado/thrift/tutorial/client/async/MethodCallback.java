package org.ado.thrift.tutorial.client.async;

import org.apache.thrift.async.AsyncMethodCallback;

public class MethodCallback<T> implements AsyncMethodCallback<T> {
	private volatile T response = null; 
	
	public T getResult() {
		return this.response;
	}

	@Override
	public void onComplete(T response) {
		this.response = response;
	}

	@Override
	public void onError(Exception exception) {
		
	}

}
