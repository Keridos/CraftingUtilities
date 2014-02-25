package de.keridos.craftingutilities.compatability;

import codechicken.microblock.BlockMicroMaterial;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import de.keridos.craftingutilities.data.Config;
import gregtechmod.api.GregTech_API;
import net.minecraft.item.ItemStack;
import powercrystals.minefactoryreloaded.MineFactoryReloadedCore;

public class ModCompatability {
    private static ModCompatability instance = null;
    private static Config Configuration = Config.getInstance();

    private Class Ic2Items;

    public boolean IC2Loaded;
    public boolean GTLoaded;
    public boolean AM2Loaded;
    public boolean FMPLoaded;
    public boolean BCLoaded;
    public boolean MFRLoaded;

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
    }

    public ItemStack getIC2Item(String name) {
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

    private void registerFacade(int id, int c) {
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", String.format("%d@%d", id, c));
    }

    public void registerMicroblocks() {
        registerGTMicroblocks();
        registerMFRMicroblocks();
    }

    private void registerGTMicroblocks() {
        if (FMPLoaded && GTLoaded && Configuration.addGTMicroblocks) {
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
        if (BCLoaded && GTLoaded && Configuration.addGTMicroblocks) {
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

    private void registerMFRMicroblocks() {
        if (BCLoaded && MFRLoaded && Configuration.addMFRMicroblocks) {
            for (int i = 0; i < 11; i++) {
                registerFacade(MineFactoryReloadedCore.factoryDecorativeBrickBlock.blockID, i);
            }
            for (int i = 0; i < 12; i++) {
                registerFacade(MineFactoryReloadedCore.factoryDecorativeStoneBlock.blockID, i);
            }
        }
    }
}
