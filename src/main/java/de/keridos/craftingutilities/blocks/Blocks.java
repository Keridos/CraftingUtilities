package de.keridos.craftingutilities.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import de.keridos.craftingutilities.data.Config;
import de.keridos.craftingutilities.tileentity.TileEntityAutoCrafter;
import de.keridos.craftingutilities.tileentity.TileEntityCraftingStation;
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
    private static Blocks instance = null;
    private static Config Configuration = Config.getInstance();
    public Block blockAutoCrafter;
    public Block blockCraftingStation;

    private Blocks() {
    }

    public static Blocks getInstance() {
        if (instance == null) {
            instance = new Blocks();
        }
        return instance;
    }


    public void setupBlocks() {
        if (Configuration.autoCrafterID > 0) {
            blockAutoCrafter = new BlockAutoCrafter(Configuration.autoCrafterID, Material.wood);
        }
        if (Configuration.craftingStationID > 0) {
            blockCraftingStation = new BlockCraftingStation(Configuration.craftingStationID, Material.wood);
        }
    }

    public void registerBlocks() {
        if (Configuration.autoCrafterID > 0) {
            GameRegistry.registerBlock(blockAutoCrafter, "BlockAutoCrafter");
            LanguageRegistry.addName(blockAutoCrafter, "Auto Crafter");
            MinecraftForge.setBlockHarvestLevel(blockAutoCrafter, "axe", 0);
        }
        if (Configuration.craftingStationID > 0) {
            GameRegistry.registerBlock(blockCraftingStation, "BlockCraftingStation");
            LanguageRegistry.addName(blockCraftingStation, "Crafting Station");
            MinecraftForge.setBlockHarvestLevel(blockCraftingStation, "axe", 0);
        }
    }

    public void registerTileEntities() {
        if (Configuration.autoCrafterID > 0) {
            GameRegistry.registerTileEntity(TileEntityAutoCrafter.class, "craftingutilities_autocrafter");
        }
        if (Configuration.craftingStationID > 0) {
            GameRegistry.registerTileEntity(TileEntityCraftingStation.class, "craftingutilities_craftingstation");
        }
    }
}
