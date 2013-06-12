package de.keridos.utilityrecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.keridos.utilityrecipes.compatability.ModCompatability;
import de.keridos.utilityrecipes.data.Config;
import de.keridos.utilityrecipes.lib.Reference;
import net.minecraftforge.common.Configuration;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class UtilityRecipes {

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        Config.initConfig(new Configuration(event.getSuggestedConfigurationFile()));
    }

    @Init
    public void init(FMLInitializationEvent event) {
        ModCompatability.checkForMods();
    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        Recipes.initRecipes();
    }

}
