package de.keridos.craftingutilities.compatability;

import cpw.mods.fml.common.Loader;
import de.keridos.craftingutilities.data.Config;

public class ModCompatability {
    private static ModCompatability instance = null;
    private static Config Configuration = Config.getInstance();
    private static MultipartSupport MultipartHandler = MultipartSupport.getInstance();
    private static FacadeSupport FacadeHandler = FacadeSupport.getInstance();

    public static boolean IC2Loaded = false;
    public static boolean GTLoaded = false;
    public static boolean AM2Loaded = false;
    public static boolean FMPLoaded = false;
    public static boolean BCLoaded = false;
    public static boolean MFRLoaded = false;
    public static boolean BoPLoaded = false;
    public static boolean EBXLLoaded = false;
    public static boolean PRLoaded = false;
    public static boolean ExtraUtilLoaded = false;


    private ModCompatability() {
    }

    public static ModCompatability getInstance() {
        if (instance == null) {
            instance = new ModCompatability();
        }
        return instance;
    }

    public void checkForMods() {
        IC2Loaded = Loader.isModLoaded("IC2");
        GTLoaded = Loader.isModLoaded("gregtech_addon");
        AM2Loaded = Loader.isModLoaded("arsmagica2");
        FMPLoaded = Loader.isModLoaded("ForgeMultipart");
        BCLoaded = Loader.isModLoaded("BuildCraft|Transport");
        MFRLoaded = Loader.isModLoaded("MineFactoryReloaded");
        BoPLoaded = Loader.isModLoaded("BiomesOPlenty");
        EBXLLoaded = Loader.isModLoaded("ExtraBiomesXL");
        ExtraUtilLoaded = Loader.isModLoaded("ExtraUtilities");
        PRLoaded = Loader.isModLoaded("ProjRed|Exploration");
    }


    public void registerModCompatBlocks() {
        if (FMPLoaded) {
            MultipartHandler.registerMicroblocks();
        }
        if (BCLoaded) {
            FacadeHandler.registerModFacades();
        }
    }
}
