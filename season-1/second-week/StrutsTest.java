import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.dom4j.DocumentException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StrutsTest {

	@Test
	public void testRunAction() throws SecurityException,
			IllegalArgumentException, DocumentException,
			ClassNotFoundException, NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("userName", "admin");
		parameters.put("password", "123");
		View view = Struts.runAction("login", parameters);
		
		Assert.assertNotNull(view);
		Assert.assertEquals("/WEB-INF/user/login.jsp", view.getJsp());
		Assert.assertEquals("Login Success!", view.getResultValue().get("loginMessage"));
	}

}
