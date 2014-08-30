package de.keridos.craftingutilities.compatability;

import cpw.mods.fml.common.Loader;

public class ModCompatability {
    public static boolean IC2Loaded = false;
    public static boolean GTLoaded = false;
    public static boolean AM2Loaded = false;
    public static boolean BCLoaded = false;
    public static boolean ExtraUtilLoaded = false;
    private static ModCompatability instance = null;
    private static FacadeSupport FacadeHandler = FacadeSupport.getInstance();


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
        BCLoaded = Loader.isModLoaded("BuildCraft|Transport");
        ExtraUtilLoaded = Loader.isModLoaded("ExtraUtilities");
    }


    public void registerModCompatBlocks() {
        if (BCLoaded) {
            FacadeHandler.registerModFacades();
        }
    }
}
