package de.keridos.craftingutilities;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import de.keridos.craftingutilities.blocks.Blocks;
import de.keridos.craftingutilities.client.gui.GuiHandler;
import de.keridos.craftingutilities.compatability.ModCompatability;
import de.keridos.craftingutilities.core.EventListener;
import de.keridos.craftingutilities.core.PacketHandler;
import de.keridos.craftingutilities.core.proxy.CommonProxy;
import de.keridos.craftingutilities.data.Config;
import de.keridos.craftingutilities.data.Recipes;
import de.keridos.craftingutilities.lib.Reference;
import net.minecraftforge.common.Configuration;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {Reference.CHANNEL}, packetHandler = PacketHandler.class)
public class CraftingUtilities {
    @Mod.Instance(Reference.MOD_ID)
    public static CraftingUtilities instance;
    private static Config config = Config.getInstance();
    private static ModCompatability ModCompat = ModCompatability.getInstance();
    private static EventListener EventHandler = EventListener.getInstance();
    private static Recipes RecipeHandler = Recipes.getInstance();
    private static Blocks BlockHandler = Blocks.getInstance();

    @SidedProxy(clientSide = Reference.PROXY_LOCATION + ".ClientProxy", serverSide = Reference.PROXY_LOCATION + ".CommonProxy")
    public static CommonProxy proxy = new CommonProxy();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModCompat.checkForMods();
        config.initConfig(new Configuration(event.getSuggestedConfigurationFile()));
        EventHandler.setupEventListener();
        BlockHandler.setupBlocks();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.initRenderers();
        proxy.initSounds();
        new GuiHandler();
        BlockHandler.registerBlocks();
        BlockHandler.registerTileEntities();
        ModCompat.registerMicroblocks();
        RecipeHandler.initRecipes();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        RecipeHandler.removeRecipes();
    }


}
