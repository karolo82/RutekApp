package com.yourapp.app.gui.enums;

public enum Status {
	N("Nowe"), R("Realizacja"), Z("Zrealizowane"), O("Odebrane");

	private String statusName;

	private Status(String name) {
		this.statusName = name;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public static String[] getNames() {
		String[] res = new String[Status.values().length];
		int x = 0;
		for (Status s : Status.values()) {
			res[x] = s.getStatusName();
			x++;
		}
		return res;
	}
	
	public static Status getStatusByName(String name) {
		if (name == null) return null;
		for (Status s : Status.values()) {
			if (s.getStatusName().equals(name)) {
				return s;
			}
		}
		return null;
	}
	
}
