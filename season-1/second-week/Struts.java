import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.dom4j.DocumentException;

public class Struts {

	public static View runAction(String actionName,
			Map<String, String> parameters) throws DocumentException,
			ClassNotFoundException, SecurityException, NoSuchMethodException,
			IllegalArgumentException, InstantiationException,
			IllegalAccessException, InvocationTargetException {

		/**
		 * 0. 读取配置文件 struts.xml
		 * 
		 * 1. 根据 actionName 找到对应的 class， 例如 LoginAction,通过反射实例化（创建对象）， 然后根据
		 * params 中的数据，调用对象的 setter方法， 例如 params 中的数据是 {"name"="cnbo",
		 * "password"="1234"}, 那就应该调用 setName 和 setPassword 方法
		 * 
		 * 2.通过反射调用对象的 exectue 方法，并获得返回值，例如 "success"
		 * 
		 * 3.通过反射找到对象的所有 getter 方法， 通过反射来调用，把值和属性形成一个 HashMap， 例如
		 * {"message":"登录成功"}, 放到 View 对象的 parameters
		 * 
		 * 4.根据 struts.xml 中的 <result> 配置，以及 execute 的返回值， 确定哪一个 JSP，放到 View 对象的
		 * jsp 中
		 */
		Configure configure = new Configure();
		String className = configure.getClassName(actionName);
		
		if (className == null || "".equals(className)) {
			return null;
		}
		
		// 创建 action 实例
		Class<?> actionClass = Class.forName(className);
		Constructor<?> constructor = actionClass.getConstructor();
		Object actionInstance = constructor.newInstance();
		
		// 调用 setter 方法
		Set<String> parameterKeySet = parameters.keySet();
		for (String key : parameterKeySet) {
			String methodName = "set" + Character.toUpperCase(key.charAt(0)) + key.substring(1);
			Method method = actionClass.getMethod(methodName, String.class);
			method.invoke(actionInstance, parameters.get(key));
 		}
		
		Method executeMethod = actionClass.getMethod("execute");
		String keyOfJsp = (String) executeMethod.invoke(actionInstance);
		
		Map<String, Object> resultValue = new HashMap<String, Object>();
		Method[] methods = actionClass.getMethods();
		for (Method m : methods) {
			String methodName = m.getName();
			if (methodName.startsWith("get")) {
				String key = Character.toLowerCase(methodName.charAt(3)) + methodName.substring(4, methodName.length());
				resultValue.put(key, m.invoke(actionInstance));
			}
		}

		String resultJsp = configure.getJSP(actionName, keyOfJsp);
		
		View view = new View();
		view.setResultValue(resultValue);
		view.setJsp(resultJsp);
		
		return view;
	}

}
