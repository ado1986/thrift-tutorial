package org.ado.thrift.tutorial.server;

import org.ado.thrift.tutorial.ThriftService;
import org.ado.thrift.tutorial.ThriftServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class JavaServer {

	public static void main(String[] args) throws Exception {
		ThriftService.Processor<ThriftServiceImpl> processor = new ThriftService.Processor(new ThriftServiceImpl());
		TServerTransport serverTransport = new TServerSocket(9090);
		TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

		System.out.println("Starting the simple server...");
		server.serve();
	}

}
