package de.keridos.utilityrecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import de.keridos.utilityrecipes.client.GuiHandler;
import de.keridos.utilityrecipes.compatability.EventListener;
import de.keridos.utilityrecipes.compatability.ModCompatability;
import de.keridos.utilityrecipes.core.CommonProxy;
import de.keridos.utilityrecipes.data.Blocks;
import de.keridos.utilityrecipes.data.Config;
import de.keridos.utilityrecipes.data.Recipes;
import de.keridos.utilityrecipes.lib.Reference;
import net.minecraftforge.common.Configuration;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = true, channels = {Reference.CHANNEL})
public class UtilityRecipes {
    @Mod.Instance(Reference.MOD_ID)
    public static UtilityRecipes instance;

    @SidedProxy(clientSide = Reference.PROXY_LOCATION + ".ClientProxy", serverSide = Reference.PROXY_LOCATION + ".ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModCompatability.checkForMods();
        Config.initConfig(new Configuration(event.getSuggestedConfigurationFile()));
        EventListener.setupEventListener();
        Blocks.setupBlocks();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.initRenderers();
        proxy.initSounds();
        new GuiHandler();
        Blocks.registerBlocks();
        Blocks.registerTileEntities();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Recipes.initRecipes();
    }


}
