package com.locydragon.myinv.api;

import com.locydragon.myinv.core.MenuStacks;

public class MyInventoryAPI {
	public static Menu getMenu(String menuName) {
		return MenuStacks.getMenuCloned(menuName);
	}
}
