package tombenpotter.emt.common.item.focus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.FocusUpgradeType;
import thaumcraft.common.items.wands.ItemWandCasting;
import tombenpotter.emt.common.entity.EntityLaser;

public class ItemExplosionFocus extends ItemBaseFocus {

	private static final AspectList visCost = new AspectList().add(Aspect.FIRE, 200).add(Aspect.ENTROPY, 200);

	public ItemExplosionFocus() {
		super(".focus.explosion", "focus_explosion");
	}

	@Override
	public int getFocusColor(ItemStack stack) {
		return 0x8B0000;
	}

	@Override
	public AspectList getVisCost(ItemStack focusstack) {
		return visCost;
	}

	@Override
	public String getSortingHelper(ItemStack itemstack) {
		return "EXPLOSION";
	}

	@Override
	public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
		ItemWandCasting wand = (ItemWandCasting) itemstack.getItem();
		if (player.capabilities.isCreativeMode || wand.consumeAllVis(itemstack, player, getVisCost(itemstack), true, true)) {
			if (!world.isRemote) {
				EntityLaser laser;
				laser = new EntityLaser(world, player, 2);
				laser.setExplosionStrengthModifier(getUpgradeLevel(itemstack, FocusUpgradeType.potency) * 0.5f + 1);
				world.spawnEntityInWorld(laser);
			}
		}
		return itemstack;
	}
	
	public FocusUpgradeType[] getPossibleUpgradesByRank(ItemStack focusstack, int rank) 
	{
	  return new FocusUpgradeType[] { FocusUpgradeType.potency, FocusUpgradeType.frugal };
	}
		
	/**
	 * Use this method to define custom logic about which upgrades can be applied. This can be used to set up upgrade "trees" 
	 * that make certain upgrades available only when others are unlocked first, when certain research is completed, or similar logic.
	 * 
	 */
	public boolean canApplyUpgrade(ItemStack focusstack, EntityPlayer player, FocusUpgradeType type, int rank) {
		return true;
	}


}
