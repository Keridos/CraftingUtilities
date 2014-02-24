package de.keridos.utilityrecipes.compatability;

import codechicken.microblock.BlockMicroMaterial;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import de.keridos.utilityrecipes.data.Config;
import gregtechmod.api.GregTech_API;
import net.minecraft.item.ItemStack;

public class ModCompatability {
    private static Class Ic2Items;

    public static boolean IC2Loaded;
    public static boolean GTLoaded;
    public static boolean AM2Loaded;
    public static boolean FMPLoaded;
    public static boolean BCLoaded;

    public static void checkForMods() {
        IC2Loaded = Loader.isModLoaded("IC2");
        GTLoaded = Loader.isModLoaded("gregtech_addon");
        AM2Loaded = Loader.isModLoaded("arsmagica2");
        FMPLoaded = Loader.isModLoaded("ForgeMultipart");
        BCLoaded = Loader.isModLoaded("BuildCraft|Transport");
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

    private static void registerFacade(int id, int c) {
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", String.format("%d@%d", id, c));
    }

    public static void registerGTMicroblocks() {
        if (FMPLoaded && GTLoaded && Config.addGTMicroblocks) {
            for (int i = 0; i < 16; i++) {
                BlockMicroMaterial.createAndRegister(GregTech_API.sBlockList[5], i);
            }
            for (int i = 0; i < 16; i++) {
                BlockMicroMaterial.createAndRegister(GregTech_API.sBlockList[4], i);
            }
            BlockMicroMaterial.createAndRegister(GregTech_API.sBlockList[0], 2);
            BlockMicroMaterial.createAndRegister(GregTech_API.sBlockList[0], 3);
            BlockMicroMaterial.createAndRegister(GregTech_API.sBlockList[0], 4);
            BlockMicroMaterial.createAndRegister(GregTech_API.sBlockList[0], 5);
            BlockMicroMaterial.createAndRegister(GregTech_API.sBlockList[0], 7);
            BlockMicroMaterial.createAndRegister(GregTech_API.sBlockList[0], 8);
            BlockMicroMaterial.createAndRegister(GregTech_API.sBlockList[0], 9);
            BlockMicroMaterial.createAndRegister(GregTech_API.sBlockList[0], 11);
            BlockMicroMaterial.createAndRegister(GregTech_API.sBlockList[0], 12);
        }
        if (BCLoaded && GTLoaded && Config.addGTMicroblocks) {
            for (int i = 0; i < 16; i++) {
                registerFacade(GregTech_API.sBlockList[5].blockID, i);
            }
            for (int i = 0; i < 16; i++) {
                registerFacade(GregTech_API.sBlockList[4].blockID, i);
            }
            registerFacade(GregTech_API.sBlockList[0].blockID, 2);
            registerFacade(GregTech_API.sBlockList[0].blockID, 3);
            registerFacade(GregTech_API.sBlockList[0].blockID, 4);
            registerFacade(GregTech_API.sBlockList[0].blockID, 5);
            registerFacade(GregTech_API.sBlockList[0].blockID, 7);
            registerFacade(GregTech_API.sBlockList[0].blockID, 8);
            registerFacade(GregTech_API.sBlockList[0].blockID, 9);
            registerFacade(GregTech_API.sBlockList[0].blockID, 11);
            registerFacade(GregTech_API.sBlockList[0].blockID, 12);
        }
    }
}
