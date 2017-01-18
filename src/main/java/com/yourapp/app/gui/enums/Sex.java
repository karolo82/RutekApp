package com.yourapp.app.gui.enums;

public enum Sex {
	M("Mężczyzna"), K("Kobieta");
	
	private String name;
	
	private Sex(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static String[] getNames() {
		String[] res = new String[Sex.values().length];
		int x = 0;
		for (Sex s : Sex.values()) {
			res[x] = s.getName();
			x++;
		}
		return res;
	}
	
	public static Sex getSexName(String name) {
		if (name == null) return null;
		for (Sex s : Sex.values()) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}
}
