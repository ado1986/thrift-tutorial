package org.ado.thrift.tutorial.server;

import org.ado.thrift.tutorial.ThriftService;
import org.ado.thrift.tutorial.ThriftServiceImpl;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TNonblockingServer.Args;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;

public class JavaNonblockingServer {
	
	public static void main(String[] args) throws Exception {
		ThriftService.Processor<ThriftServiceImpl> processor = new ThriftService.Processor(new ThriftServiceImpl());
		TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(9090);
		TServer server = new TNonblockingServer(new Args(serverTransport).processor(processor));

		System.out.println("Starting the non blocking server...");
		server.serve();
	}

}
