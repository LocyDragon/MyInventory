package com.locydragon.myinv.api;

import com.locydragon.myinv.util.MenuOutputStream;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * @author LocyDragon
 */
public class Menu implements Cloneable,Iterable {
	private List<FrameMenu> frames = new ArrayList<>();
	private String fatherTitle = "";
	private int index = 0;
	private int size = 9;
	private FrameMenu extended = null;
	private String menuName;
	public Menu(String fatherTitle, int size, String menuName) {
		this.fatherTitle = fatherTitle;
		this.size = size;
		this.menuName = menuName;
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

	public Menu deepClone() {
		return (Menu)deepClone(this);
	}

	private Object deepClone(Object src){
		Object o = null;
		try{
			if (src != null){
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				oos.writeObject(src);
				oos.close();
				ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
				ObjectInputStream ois = new ObjectInputStream(bais);
				o = ois.readObject();
				ois.close();
			}
		} catch (IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return o;
	}

	public void save() {
		File outputFile = new File(".//plugins//MyInventory//Gui//"+this.menuName+".yml");
		if (!outputFile.exists()) {
			outputFile.getParentFile().mkdirs();
			try {
				outputFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileConfiguration configuration = YamlConfiguration.loadConfiguration(outputFile);
		MenuOutputStream.saveTo(configuration, this, outputFile);
	}

	public static Menu forName(String menuName) {
		File outputFile = new File(".//plugins//MyInventory//Gui//"+menuName+".yml");
		FileConfiguration configuration = YamlConfiguration.loadConfiguration(outputFile);
		return MenuOutputStream.load(configuration, menuName);
	}

	public String getMenuName() {
		return menuName;
	}

	public void addFrame(FrameMenu menu) {
		this.frames.add(menu);
	}

	@Override
	public Iterator<FrameMenu> iterator() {
		return this.frames.iterator();
	}

	public boolean hasFrame(int frame) {
		return frame < this.frames.size();
	}

	public boolean isEmpty() {
		return this.frames.isEmpty();
	}

	public void insertFrame(int index, FrameMenu frameMenu) {
		if (hasFrame(index)) {
			this.frames.set(index, frameMenu);
		} else {
			this.frames.add(frameMenu);
		}
	}
}
