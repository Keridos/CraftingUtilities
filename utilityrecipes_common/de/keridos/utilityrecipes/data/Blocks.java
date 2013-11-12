package de.keridos.utilityrecipes.data;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
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
            blockAutoCrafter = new autoCrafter(Config.autoCrafterID, Material.wood);
        }

    }

    public static void registerBlocks() {
        GameRegistry.registerBlock(blockAutoCrafter, "blockAutoCrafter");
        LanguageRegistry.addName(blockAutoCrafter, "Auto Crafter");
        MinecraftForge.setBlockHarvestLevel(blockAutoCrafter, "axe", 0);
    }
}
