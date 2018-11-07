package com.ipartek.formacion.nidea.pojo;

public class Alert {

	public static final String PRIMARY = "primary";
	public static final String SECONDARY = "secondary";
	public static final String SUCCESS = "success";
	public static final String DANGER = "danger";
	public static final String WARNING = "warning";
	public static final String INFO = "info";
	public static final String LIGHT = "light";
	public static final String DARK = "dark";
	
	private static final String DEFAULT_MSG = "Lo sentimos. Ha ocurrido un error inesperado.";

	private String msg;
	private String priority;

	public Alert() {
		super();
		this.msg = DEFAULT_MSG;
		this.priority = DANGER;
	}

	public Alert(String msg) {
		this();
		if (msg != null && !msg.trim().isEmpty()) {
			this.msg = msg;
		}
	}

	public Alert(String msg, String priority) {
		this();
		if (msg != null && !msg.trim().isEmpty()) {
			this.msg = msg;
		}
		if (priority != null && !priority.trim().isEmpty()) {
			this.priority = priority;
		}

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

}
