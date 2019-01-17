package com.locydragon.myinv.core.script.ache;

import com.avaje.ebean.validation.NotNull;

public class SlotLabel {
	@NotNull private int slotNum = -1;
	@NotNull private String menuName = null;

	public SlotLabel(int slotNum, String menuName) {
		 this.slotNum = slotNum;
		 this.menuName = menuName;
	}

	public int getSlotNum() {
		return this.slotNum;
	}

	public String getMenuName() {
		return this.menuName;
	}

	@Override
	public boolean equals(Object another) {
		if (!(another instanceof SlotLabel)) {
			return false;
		}
		SlotLabel targetLabel = (SlotLabel)another;
		return targetLabel.slotNum == this.slotNum && targetLabel.menuName.equals(this.menuName);
	}
}
