package org.nutz.lang;

import java.lang.reflect.Method;
import java.text.MessageFormat;

import javax.xml.parsers.DocumentBuilderFactory;

public class XX extends AbstractInvoker {

	private static Method _method_0;
	private static Method _method_1;
	
	@Override
	public void invoke_instant_void(Object obj, Method method, Object... args)
			throws Throwable {
		System.out.println(args);
		if (_method_0.equals(method))
			((AClass)obj).pp();
//		if (_method_1.equals(method))
//			((AClass)obj).yy((String)args[0]);
//		Object x = args[0];
//		x = args[1];
//		x = args[2];
//		x = args[3];
//		x = args[4];
		yy((String)args[0],(String)args[1],(String)args[2]);
	}
	
	public void yy(Object x, Object y,Object z){}

	public void xxx(Object vv,String uu,Object...args){
		for (Object object : args) 
			System.out.println(object);;
	}
}
