package com.locydragon.myinv.metrics;

public class MagicValue {
	public static final String MAGIC_VALUE_SCRIPT_DATA = "SlotTest:\n" +
			"  linkToMenu: test\n" +
			"  location: 13\n" +
			"  action: LEFT\n" +
			"  script:\n" +
			"    - 'compare: %frame% = 23'\n" +
			"    - 'ask: %ANSWER%|5|&aAre you happy today?(yes/no)'\n" +
			"    - 'compare: %ANSWER% = yes'\n" +
			"    - 'tell: &aYou are happy!I will give you some stone!'\n" +
			"    - 'op: /give %name% 1 64'";
	public static final String MAGIC_VALUE_MENU_DATA = "Output:\n" +
			"  Title: \"\\xa76Test-menu\"\n" +
			"  Size: 27\n" +
			"  Music: EMPTY_MUSIC\n" +
			"  Period: 0.15\n" +
			"  Loop: false\n" +
			"FRAME_0:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_1:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_2:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_3:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_4:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_5:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_6:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_7:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_8:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_9:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_10:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_11:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_12:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_13:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_14:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"FRAME_15:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_16:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_17:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_18:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_19:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_20:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_21:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_22:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"FRAME_23:\n" +
			"  Exist: true\n" +
			"  '0':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 10\n" +
			"  '1':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '2':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '3':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '4':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 1\n" +
			"  '5':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '6':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '7':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '8':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 10\n" +
			"  '9':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '13':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: SKULL_ITEM\n" +
			"    damage: 3\n" +
			"    meta:\n" +
			"      ==: ItemMeta\n" +
			"      meta-type: SKULL\n" +
			"      display-name: \"\\xa7aClick me!\"\n" +
			"      lore:\n" +
			"      - \"\\xa77This is a test button\"\n" +
			"      - \"\\xa76Try this!\"\n" +
			"      - \"\\xa77You name is: %name%\"\n" +
			"  '17':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '18':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 10\n" +
			"  '19':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '20':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '21':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '22':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '23':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '24':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '25':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"  '26':\n" +
			"    ==: org.bukkit.inventory.ItemStack\n" +
			"    type: STAINED_GLASS_PANE\n" +
			"    damage: 10\n";
}
