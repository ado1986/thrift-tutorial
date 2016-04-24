namespace java org.ado.thrift.tutorial

typedef i32 MyInteger

struct InnerStruct {
	1: i32 key
	2: string value
}

struct SharedStruct {
	1: i32 key
	2: string value
	3: InnerStruct innerStruct
}


service ThriftService
{
	void testVoid(),
	MyInteger getMyInteger(1: MyInteger arg1, 2: string name),
	string testString(),
	SharedStruct getSharedStruct()
}