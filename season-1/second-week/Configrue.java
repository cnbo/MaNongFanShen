import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Configure {

	private static String FILE_NAME = "src/struts-login.xml";

	public static void main(String[] args) throws DocumentException {
		Configure configure = new Configure();
		 System.out.println(configure.getJSP("login", "success"));
	}

	private Element getElement(Element parentElement, String elementName, String attribute) {
		List<Element> eList = parentElement.elements(elementName);
		for(Element e : eList) {
			if (attribute.equals(e.attributeValue("name"))) {
				return e;
			}
		}
		
		return null;
	}
	
	private Element getPackageElement() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = (Document) reader.read(new File(FILE_NAME));
		Element rootElement = doc.getRootElement();
		return rootElement.element("package");
	}
	
	public String getClassName(String actionName) throws DocumentException {
		Element packageElement = getPackageElement();
		if (packageElement != null) {
			Element eAction = getElement(packageElement, "action", actionName);
			if (eAction != null) {
				return eAction.attributeValue("class");
			}
		}
		

		return null;
	}
	
	public String getJSP(String actionName, String resultName) throws DocumentException {
		Element packageElement = getPackageElement();
		if (packageElement == null) {
			return null;
		}
		Element eAction = getElement(packageElement, "action", actionName);
		if (eAction == null) {
			return null;
		}
		Element eResult = getElement(eAction, "result", resultName);
		if (eResult != null) {
			return eResult.getStringValue();
		}
		
		return null;
	}

}
