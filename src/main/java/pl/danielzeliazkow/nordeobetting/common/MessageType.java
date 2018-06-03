package pl.danielzeliazkow.nordeobetting.common;

public enum MessageType {
	INFO("alert alert-info"), ERROR("alert alert-danger");
	
	private String cssStyle;
	
	private MessageType(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public String getCssStyle() {
		return cssStyle;
	}
	
	
}
