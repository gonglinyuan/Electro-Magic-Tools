package tombenpotter.emt.common.init;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import static thaumcraft.api.ThaumcraftApi.*;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.block.BlockMachines;
import tombenpotter.emt.common.block.BlockSolars;
import tombenpotter.emt.common.block.BlockSolars2;
import tombenpotter.emt.common.block.BlockEssentiaGenerators;
import tombenpotter.emt.common.block.BlockPortableNode;
import tombenpotter.emt.common.block.BlockShield;
import tombenpotter.emt.common.item.block.ItemBlockMachines;
import tombenpotter.emt.common.item.block.ItemBlockSolars;
import tombenpotter.emt.common.item.block.ItemBlockSolars2;
import tombenpotter.emt.common.item.block.ItemBlockEssentiaGenerator;
import tombenpotter.emt.common.item.block.ItemBlockEssentiaGenerators;

public class BlockRegistry {

	public static Block portableNode;
	public static Block essentiaGens;
	public static Block shield;
	public static Block emtSolars;
	public static Block emtMachines;
	public static Block emtSolars2;

	public static void registerBlocks() {
		portableNode = new BlockPortableNode("portablenode");
		GameRegistry.registerBlock(portableNode, "PortableNode");

		shield = new BlockShield("shield");
		GameRegistry.registerBlock(shield, "ShieldBlock");

		emtSolars = new BlockSolars("solar");
		GameRegistry.registerBlock(emtSolars, ItemBlockSolars.class, "EMTSolars");

		emtSolars2 = new BlockSolars2("solar2");
		GameRegistry.registerBlock(emtSolars2, ItemBlockSolars2.class, "EMTSolars2");

		emtMachines = new BlockMachines("machine");
		GameRegistry.registerBlock(emtMachines, ItemBlockMachines.class, "EMTMachines");

		essentiaGens = new BlockEssentiaGenerators("essentia");
		GameRegistry.registerBlock(essentiaGens, ItemBlockEssentiaGenerators.class, "EssentiaGenerators");
	}

	public static void addAspects() {
		registerObjectTag(IC2Items.getItem("rubberTrampoline"), new AspectList().add(Aspect.AIR, 5));
		registerObjectTag(IC2Items.getItem("ironFence"), new AspectList().add(Aspect.ENERGY, 1).add(Aspect.METAL, 2).add(Aspect.WEATHER, 1));
		registerObjectTag(IC2Items.getItem("reinforcedGlass"), new AspectList().add(Aspect.METAL, 2).add(Aspect.COLD, 2));
		registerObjectTag(IC2Items.getItem("scaffold"), new AspectList().add(Aspect.TREE, 4));
		registerObjectTag(IC2Items.getItem("ironScaffold"), new AspectList().add(Aspect.METAL, 4));
		registerObjectTag(IC2Items.getItem("generator"), new AspectList().add(Aspect.METAL, 2).add(Aspect.ENERGY, 2).add(Aspect.MECHANISM, 1));
		registerObjectTag(IC2Items.getItem("waterMill"), new AspectList().add(Aspect.METAL, 2).add(Aspect.ENERGY, 1).add(Aspect.WATER, 2).add(Aspect.MECHANISM, 1));
		registerObjectTag(IC2Items.getItem("solarPanel"), new AspectList().add(Aspect.METAL, 1).add(Aspect.ENERGY, 1).add(Aspect.LIGHT, 2).add(Aspect.MECHANISM, 1));
		registerObjectTag(IC2Items.getItem("windMill"), new AspectList().add(Aspect.ENERGY, 1).add(Aspect.WEATHER, 3).add(Aspect.MECHANISM, 1));
		registerObjectTag(IC2Items.getItem("batBox"), new AspectList().add(Aspect.METAL, 1).add(Aspect.ENERGY, 3).add(Aspect.MECHANISM, 1));
		registerObjectTag(IC2Items.getItem("cesuUnit"), new AspectList().add(Aspect.METAL, 2).add(Aspect.ENERGY, 4).add(Aspect.MECHANISM, 1));
		registerObjectTag(IC2Items.getItem("mfeUnit"), new AspectList().add(Aspect.METAL, 2).add(Aspect.ENERGY, 5).add(Aspect.MECHANISM, 1));
		registerObjectTag(IC2Items.getItem("mfsUnit"), new AspectList().add(Aspect.METAL, 2).add(Aspect.ENERGY, 7).add(Aspect.MECHANISM, 1));
		registerObjectTag(IC2Items.getItem("ironFurnace"), new AspectList().add(Aspect.METAL, 2).add(Aspect.FIRE, 2).add(Aspect.MECHANISM, 1));
		registerObjectTag(IC2Items.getItem("electroFurnace"), new AspectList().add(Aspect.METAL, 2).add(Aspect.ENERGY, 1).add(Aspect.FIRE, 3).add(Aspect.MECHANISM, 1));
		registerObjectTag(IC2Items.getItem("macerator"), new AspectList().add(Aspect.METAL, 1).add(Aspect.ENERGY, 2).add(Aspect.MINE, 2).add(Aspect.MECHANISM, 1));
		registerObjectTag(IC2Items.getItem("extractor"), new AspectList().add(Aspect.METAL, 2).add(Aspect.ENERGY, 1).add(Aspect.CRAFT, 2).add(Aspect.MECHANISM, 1));
		registerObjectTag(IC2Items.getItem("compressor"), new AspectList().add(Aspect.METAL, 1).add(Aspect.ENERGY, 2).add(Aspect.VOID, 3).add(Aspect.MECHANISM, 1));
	}
}
