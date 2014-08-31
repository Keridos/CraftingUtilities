package de.keridos.craftingutilities;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.keridos.craftingutilities.blocks.Blocks;
import de.keridos.craftingutilities.client.gui.GuiHandler;
import de.keridos.craftingutilities.compatability.ModCompatability;
import de.keridos.craftingutilities.core.EventListener;
import de.keridos.craftingutilities.core.proxy.IProxy;
import de.keridos.craftingutilities.data.Config;
import de.keridos.craftingutilities.data.Recipes;
import de.keridos.craftingutilities.lib.Reference;
import net.minecraftforge.common.config.Configuration;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES)
public class CraftingUtilities {
    @Mod.Instance(Reference.MOD_ID)
    public static CraftingUtilities instance;

    @SidedProxy(clientSide = Reference.PROXY_LOCATION + ".ClientProxy", serverSide = Reference.PROXY_LOCATION + ".ServerProxy")
    public static IProxy proxy;

    private static Config config = Config.getInstance();
    private static ModCompatability ModCompat = ModCompatability.getInstance();
    private static EventListener EventHandler = EventListener.getInstance();
    private static Recipes RecipeHandler = Recipes.getInstance();
    private static Blocks BlockHandler = Blocks.getInstance();
    private static GuiHandler Gui = null;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModCompat.checkForMods();
        config.initConfig(new Configuration(event.getSuggestedConfigurationFile()));
        EventHandler.setupEventListener();
        BlockHandler.setupBlocks();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        BlockHandler.registerBlocks();
        BlockHandler.registerTileEntities();
        ModCompat.registerModCompatBlocks();
        RecipeHandler.initRecipes();
        Gui = GuiHandler.getInstance();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        RecipeHandler.removeRecipes();
    }


}
