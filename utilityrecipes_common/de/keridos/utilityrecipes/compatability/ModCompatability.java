package de.keridos.utilityrecipes.compatability;

import cpw.mods.fml.common.Loader;
import net.minecraft.item.ItemStack;

public class ModCompatability {
    private static Class Ic2Items;

    public static boolean IC2Loaded;
    public static boolean TELoaded;
    public static boolean GTLoaded;

    public static void checkForMods() {
        IC2Loaded = Loader.isModLoaded("IC2");
        TELoaded = Loader.isModLoaded("ThermalExpansion");
        GTLoaded = Loader.isModLoaded("GregTech_Addon");
    }

    public static ItemStack getIC2Item(String name) {
        try {
            if (Ic2Items == null) Ic2Items = Class.forName("ic2.core.Ic2Items");

            Object ret = Ic2Items.getField(name).get(null);

            if (ret instanceof ItemStack) {
                return ((ItemStack) ret).copy();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
