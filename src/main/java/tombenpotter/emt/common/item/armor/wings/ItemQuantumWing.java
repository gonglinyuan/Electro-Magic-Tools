package tombenpotter.emt.common.item.armor.wings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.util.EMTConfigHandler;

public class ItemQuantumWing extends ItemNanoWing {
	public static int maxCharge = 1000000;

    public ItemQuantumWing(ArmorMaterial material, int par3, int par4) {
        super(material, par3, par4);
        this.setMaxStackSize(1);
        this.setMaxDamage(27);
        this.setCreativeTab(ElectroMagicTools.tabEMT);
        visDiscount = 6;
        transferLimit = 10000;
        energyPerDamage = 1000;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ModInformation.texturePath + ":armor/wing_quantum");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return ModInformation.texturePath + ":textures/models/quantumwing.png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
    	this.useWing(player, stack, world, 0.33f, 0.5f, 0.2f, 7);
    }
    
    @Override
    public double getMaxCharge(ItemStack itemStack) {
        return maxCharge;
    }
}
