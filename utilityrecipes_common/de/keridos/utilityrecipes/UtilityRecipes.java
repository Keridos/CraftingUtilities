package de.keridos.utilityrecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.keridos.utilityrecipes.compatability.EventListener;
import de.keridos.utilityrecipes.compatability.ModCompatability;
import de.keridos.utilityrecipes.data.Blocks;
import de.keridos.utilityrecipes.data.Config;
import de.keridos.utilityrecipes.data.Recipes;
import de.keridos.utilityrecipes.lib.Reference;
import net.minecraftforge.common.Configuration;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class UtilityRecipes {

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModCompatability.checkForMods();
        Config.initConfig(new Configuration(event.getSuggestedConfigurationFile()));
        EventListener.setupEventListener();
        Blocks.setupBlocks();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        Blocks.registerBlocks();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Recipes.initRecipes();
    }


}
