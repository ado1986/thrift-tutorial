package org.ado.thrift.tutorial;

import org.ado.thrift.tutorial.ThriftService.Iface;
import org.apache.thrift.TException;

public class ThriftServiceImpl implements Iface {

	@Override
	public void testVoid() throws TException {
		System.out.println("run testVoid()...");
	}

	@Override
	public int getMyInteger() throws TException {
		System.out.println("run getMyInteger()...");
		
		return 11;
	}

	@Override
	public String testString() throws TException {
//		return null;
		return "Hello World!";
	}

	@Override
	public SharedStruct getSharedStruct() throws TException {
//		return null;
		SharedStruct sharedStruct = new SharedStruct();
		sharedStruct.setKey(1);
		sharedStruct.setValue("ado");
		return sharedStruct;
	}

}
