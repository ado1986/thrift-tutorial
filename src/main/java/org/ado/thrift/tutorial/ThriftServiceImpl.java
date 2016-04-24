package org.ado.thrift.tutorial;

import org.ado.thrift.tutorial.ThriftService.Iface;
import org.apache.thrift.TException;

public class ThriftServiceImpl implements Iface {

	@Override
	public void testVoid() throws TException {
		System.out.println("run testVoid()...");
	}

	@Override
	public String testString() throws TException {
		// return null;
		return "Hello World!";
	}

	@Override
	public SharedStruct getSharedStruct() throws TException {
		// return null;
		SharedStruct sharedStruct = new SharedStruct();
		sharedStruct.setKey(1);
		// 支持内部字段为null
		sharedStruct.setValue(null);
		InnerStruct innerStruct = new InnerStruct();
		innerStruct.setKey(1);
		innerStruct.setValue("inner struct");
		sharedStruct.setInnerStruct(innerStruct);
		return sharedStruct;
	}

	@Override
	public int getMyInteger(int arg1, String arg2) throws TException {
		System.out.println("run getMyInteger()...args: " + arg1 + ", " + arg2);

		return 11;
	}

}
