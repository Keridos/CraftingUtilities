package de.keridos.utilityrecipes.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import de.keridos.utilityrecipes.data.Config;
import de.keridos.utilityrecipes.tileentity.TileEntityAutoCrafter;
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

    public static void setupBlocks() {
        if (Config.autoCrafterID > 0) {
            blockAutoCrafter = new BlockAutoCrafter(Config.autoCrafterID, Material.wood);
        }

    }

    public static void registerBlocks() {
        GameRegistry.registerBlock(blockAutoCrafter, "BlockAutoCrafter");
        LanguageRegistry.addName(blockAutoCrafter, "Auto Crafter");
        MinecraftForge.setBlockHarvestLevel(blockAutoCrafter, "axe", 0);
    }

    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityAutoCrafter.class, "utilityrecipes_autocrafter");
    }
}
