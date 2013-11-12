package de.keridos.utilityrecipes.data;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import de.keridos.utilityrecipes.lib.GenericBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 12.11.13
 * Time: 04:00
 * To change this template use File | Settings | File Templates.
 */
public class Blocks {
    public static Block autoCrafter;

    public static void setupBlocks() {
        autoCrafter = new GenericBlock(Config.autoCrafterID, Material.wood).setHardness(0.5F).setStepSound(
                Block.soundWoodFootstep).setUnlocalizedName("autoCrafter").setCreativeTab(CreativeTabs.tabBlock);

    }

    public static void registerBlocks() {
        GameRegistry.registerBlock(autoCrafter, "autoCrafter");
        LanguageRegistry.addName(autoCrafter, "Auto Crafter");
        MinecraftForge.setBlockHarvestLevel(autoCrafter, "axe", 0);
    }
}
