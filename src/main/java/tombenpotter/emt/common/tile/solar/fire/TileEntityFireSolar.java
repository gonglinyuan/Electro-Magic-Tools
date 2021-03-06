package tombenpotter.emt.common.tile.solar.fire;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import tombenpotter.emt.common.init.BlockRegistry;
import tombenpotter.emt.common.tile.solar.TileEntitySolarBase;
import tombenpotter.emt.common.util.EMTConfigHandler;

public class TileEntityFireSolar extends TileEntitySolarBase {

	public TileEntityFireSolar() {
		output = EMTConfigHandler.compressedSolarOutput;
	}

	@Override
	public void checkConditions() {
		if (!initialized && worldObj != null) {
			canRain = worldObj.getWorldChunkManager().getBiomeGenAt(xCoord, zCoord).getIntRainfall() > 0;
			initialized = true;
		}

		if (worldObj.provider.dimensionId == -1) {
			energySource.addEnergy(output * 2);
		}
		else {
			if (tick-- == 0) {
				updateSunState();
				tick = 64;
			}
		}
	}

	@Override
	public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
		return new ItemStack(BlockRegistry.emtSolars, 1, 12);
	}
}
