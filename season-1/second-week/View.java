import java.util.Map;


public class View {
	
	private Map<String, Object> resultValue;
	
	private String jsp;

	public Map<String, Object> getResultValue() {
		return resultValue;
	}

	public void setResultValue(Map<String, Object> resultValue) {
		this.resultValue = resultValue;
	}

	public String getJsp() {
		return jsp;
	}

	public void setJsp(String jsp) {
		this.jsp = jsp;
	}

}
