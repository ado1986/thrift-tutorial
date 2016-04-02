namespace java org.ado.thrift.tutorial

typedef i32 MyInteger

struct SharedStruct {
	1: i32 key
	2: string value
}

service ThriftService
{
	void testVoid(),
	MyInteger getMyInteger(),
	string testString(),
	SharedStruct getSharedStruct()
}