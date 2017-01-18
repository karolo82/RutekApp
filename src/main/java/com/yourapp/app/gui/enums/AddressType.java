package com.yourapp.app.gui.enums;

public enum AddressType {
	Z("Zameldowania"), K("Korespondencyjny");
	
	private String name;
	
	private AddressType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static String[] getNames() {
		String[] res = new String[AddressType.values().length];
		int x = 0;
		for (AddressType s : AddressType.values()) {
			res[x] = s.getName();
			x++;
		}
		return res;
	}
	
	public static AddressType getAddresTypeName(String name) {
		if (name == null) return null;
		for (AddressType s : AddressType.values()) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}
}
