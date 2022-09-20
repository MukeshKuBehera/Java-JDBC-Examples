class Test  
{
	 static{
		System.out.println("Test:static block");
	}
	public Test(){
		System.out.println("Test:0 param constroctor");
	}
}

class Demo 
{
	 static{
		System.out.println("Demo:static block");
	}
	public Demo(){
		System.out.println("Demo:0 param constructor");
	}
}


public class DemoApp
{
	 static{
		System.out.println("DemoApp:static block");
	}
	public DemoApp(){
		System.out.println("DemoApp:0 param constroctor");
	}
	public static void main(String[] args) throws Exception{ 
		System.out.println("DemoApp:main start");
		Test t1=new Test();
		//Test t2=new Test();
		System.out.println("============================");
		Class.forName("Demo");
		System.out.println("DemoApp:main end");
	}
}
