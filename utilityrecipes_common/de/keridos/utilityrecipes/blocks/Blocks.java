package de.keridos.utilityrecipes.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import de.keridos.utilityrecipes.data.Config;
import de.keridos.utilityrecipes.tileentity.TileEntityAutoCrafter;
import de.keridos.utilityrecipes.tileentity.TileEntityCraftingStation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 12.11.13
 * Time: 04:00
 * To change this template use File | Settings | File Templates.
 */

public class Blocks {
    public static Block blockAutoCrafter;
    public static Block blockCraftingStation;

    public static void setupBlocks() {
        if (Config.autoCrafterID > 0) {
            blockAutoCrafter = new BlockAutoCrafter(Config.autoCrafterID, Material.wood);
        }
        if (Config.craftingStationID > 0) {
            blockCraftingStation = new BlockCraftingStation(Config.craftingStationID, Material.wood);
        }
    }

    public static void registerBlocks() {
        if (Config.autoCrafterID > 0) {
            GameRegistry.registerBlock(blockAutoCrafter, "BlockAutoCrafter");
            LanguageRegistry.addName(blockAutoCrafter, "Auto Crafter");
            MinecraftForge.setBlockHarvestLevel(blockAutoCrafter, "axe", 0);
        }
        if (Config.craftingStationID > 0) {
            GameRegistry.registerBlock(blockCraftingStation, "BlockCraftingStation");
            LanguageRegistry.addName(blockCraftingStation, "Crafting Station");
            MinecraftForge.setBlockHarvestLevel(blockCraftingStation, "axe", 0);
        }
    }

    public static void registerTileEntities() {
        if (Config.autoCrafterID > 0) {
            GameRegistry.registerTileEntity(TileEntityAutoCrafter.class, "utilityrecipes_autocrafter");
        }
        if (Config.craftingStationID > 0) {
            GameRegistry.registerTileEntity(TileEntityCraftingStation.class, "utilityrecipes_craftingstation");
        }
    }
}
