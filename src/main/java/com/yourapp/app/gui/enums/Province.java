package com.yourapp.app.gui.enums;

public enum Province {
	
	WM("warmińsko-mazurskie"),
	DS("dolnośląskie"), 
	KP("kujawsko-pomorskie"), 
	LU("lubelskie"), 
	LB("lubuskie"), 
	LO("łódzkie"), 
	MA("małopolskie"), 
	MZ("mazowieckie"), 
	OP("opolskie"), 
	PK("podkarpackie"), 
	PD("podlaskie"), 
	PM("pomorskie"), 
	SL("śląskie"), 
	SW("świętokrzyskie"), 
	WL("wielkopolskie"), 
	ZP("zachodniopomorskie");
	
	private String name;
	
	private Province(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static String[] getNames() {
		String[] res = new String[Province.values().length];
		int x = 0;
		for (Province s : Province.values()) {
			res[x] = s.getName();
			x++;
		}
		return res;
	}
	
	public static Province getProvinceName(String name) {
		if (name == null) return null;
		for (Province s : Province.values()) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}
}
