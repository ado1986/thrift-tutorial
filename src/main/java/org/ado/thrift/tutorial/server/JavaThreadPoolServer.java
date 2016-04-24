package org.ado.thrift.tutorial.server;

import org.ado.thrift.tutorial.ThriftService;
import org.ado.thrift.tutorial.ThriftServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;

public class JavaThreadPoolServer {
	
	public static void main(String[] args) throws Exception {
		ThriftService.Processor<ThriftServiceImpl> processor = new ThriftService.Processor(new ThriftServiceImpl());
		TServerSocket serverTransport = new TServerSocket(9090);
		TServer server = new TThreadPoolServer(new Args(serverTransport).processor(processor));

		System.out.println("Starting the thread pool server...");
		server.serve();
	}

}
