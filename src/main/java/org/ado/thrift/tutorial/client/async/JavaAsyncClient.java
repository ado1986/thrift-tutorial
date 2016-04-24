package org.ado.thrift.tutorial.client.async;

import org.ado.thrift.tutorial.ThriftService;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;

public class JavaAsyncClient {

	public static void main(String[] args) throws Exception {
		TAsyncClientManager clientManager = new TAsyncClientManager();
		TNonblockingSocket transport = new TNonblockingSocket("localhost", 9090);
		TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();
		ThriftService.AsyncClient asyncClient = new ThriftService.AsyncClient(protocolFactory, clientManager,
				transport);
		System.out.println("Client calls .....");
		MethodCallback<ThriftService.AsyncClient.testString_call> callBack = new MethodCallback<ThriftService.AsyncClient.testString_call>();
		asyncClient.testString(callBack);
		ThriftService.AsyncClient.testString_call res = callBack.getResult();
		while (res == null) {
			res = callBack.getResult();
		}
		System.out.println(((ThriftService.AsyncClient.testString_call) res).getResult());
	}

}
