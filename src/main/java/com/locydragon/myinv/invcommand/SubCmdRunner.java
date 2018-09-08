package com.locydragon.myinv.invcommand;

/**
 * @apiNote 指令执行者
 * @author LocyDragon
 */
public interface SubCmdRunner {
	/**
	 * 当被执行时调用
	 * @param info
	 */
	void onSubCommand(SubCommandInfo info);
}
