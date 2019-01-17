package com.locydragon.myinv.api.events;

import com.locydragon.myinv.api.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class MenuOpenEvent extends PlayerEvent {
	private static final HandlerList handlers = new HandlerList();
	private Menu openedMenu;

	public MenuOpenEvent(final Player player, Menu targetMenu) {
		super(player);
		this.openedMenu = targetMenu;
	}

	public Menu getOpenedMenu() {
		return this.openedMenu;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
