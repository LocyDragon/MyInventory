package com.locydragon.myinv.api;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LocyDragon
 */
public class Menu {
	public List<FrameMenu> frames = new ArrayList<>();
	private String fatherTitle = "";
	private int index = 0;
	private int size = 9;
	private FrameMenu extended = null;
	public Menu(String fatherTitle, int size) {
		this.fatherTitle = fatherTitle;
		this.size = size;
	}

	public String getTitle() {
		return this.fatherTitle;
	}

	public void setTitle(String title) {
		this.fatherTitle = title;
	}

	public FrameMenu nextFrame() {
		if (index >= frames.size()) {
			index = 0;
		}
		FrameMenu menu = frames.get(index);
		index++;
		this.extended = menu;
		return menu;
	}

	public FrameMenu getExtended() {
		return this.extended;
	}

	public int getSize() {
		return this.size;
	}

	public FrameMenu getFrame(int index) {
		return this.frames.get(index);
	}

	public int getFramesSize() {
		return this.frames.size();
	}
}
