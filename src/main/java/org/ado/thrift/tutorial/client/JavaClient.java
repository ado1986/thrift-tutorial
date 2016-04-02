package org.ado.thrift.tutorial.client;

import org.ado.thrift.tutorial.ThriftService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class JavaClient {

	public static void main(String[] args) throws Exception {
		TTransport transport = new TSocket("localhost", 9090);
		transport.open();
		TProtocol protocol = new TBinaryProtocol(transport);
		ThriftService.Client client = new ThriftService.Client(protocol);

		// integer数值
		System.out.println("integer : " + client.getMyInteger());
		// 打印
		client.testVoid();
		
		// 不支持null字符串
		System.out.println(client.testString());
		
		// 不支持null对象
		System.out.println(client.getSharedStruct());

		transport.close();
	}

}
