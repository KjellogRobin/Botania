/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [Jun 11, 2014, 2:16:47 AM (GMT)]
 */
package vazkii.botania.common.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import vazkii.botania.client.core.helper.IconHelper;
import vazkii.botania.common.core.handler.ConfigHandler;
import vazkii.botania.common.lib.LibItemNames;

public class ItemQuartz extends ItemMod {

	private static final int SUBTYPES = 5;
	IIcon[] icons;

	public ItemQuartz() {
		setUnlocalizedName(LibItemNames.QUARTZ);
		setHasSubtypes(true);
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for(int i = ConfigHandler.darkQuartzEnabled ? 0 : 1; i < SUBTYPES; i++)
			list.add(new ItemStack(item, 1, i));
	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		icons = new IIcon[SUBTYPES];
		for(int i = 0; i < icons.length; i++)
			icons[i] = IconHelper.forItem(par1IconRegister, this, i);
	}

	@Override
	public IIcon getIconFromDamage(int par1) {
		return icons[Math.min(icons.length - 1, par1)];
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return getUnlocalizedNameLazy(par1ItemStack) + par1ItemStack.getItemDamage();
	}

	String getUnlocalizedNameLazy(ItemStack par1ItemStack) {
		return super.getUnlocalizedName(par1ItemStack);
	}
}
