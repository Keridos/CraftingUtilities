package de.keridos.craftingutilities.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import de.keridos.craftingutilities.data.Config;
import de.keridos.craftingutilities.tileentity.TileEntityAutoCrafter;
import de.keridos.craftingutilities.tileentity.TileEntityCraftingStation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

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
        if (Configuration.autoCrafter) {
            blockAutoCrafter = new BlockAutoCrafter(Material.wood);
        }
        if (Configuration.craftingStation) {
            blockCraftingStation = new BlockCraftingStation(Material.wood);
        }
    }

    public void registerBlocks() {
        if (Configuration.autoCrafter) {
            GameRegistry.registerBlock(blockAutoCrafter, "BlockAutoCrafter");
            LanguageRegistry.addName(blockAutoCrafter, "Auto Crafter");
        }
        if (Configuration.craftingStation) {
            GameRegistry.registerBlock(blockCraftingStation, "BlockCraftingStation");
            LanguageRegistry.instance().addName(blockCraftingStation, "Crafting Station");
        }
    }

    public void registerTileEntities() {
        if (Configuration.autoCrafter) {
            GameRegistry.registerTileEntity(TileEntityAutoCrafter.class, "craftingutilities_autocrafter");
        }
        if (Configuration.craftingStation) {
            GameRegistry.registerTileEntity(TileEntityCraftingStation.class, "craftingutilities_craftingstation");
        }
    }
}
