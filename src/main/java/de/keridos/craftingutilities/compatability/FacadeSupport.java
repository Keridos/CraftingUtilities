package de.keridos.craftingutilities.compatability;


import Reika.GeoStrata.Registry.GeoBlocks;
import biomesoplenty.configuration.BOPConfigurationIDs;
import cpw.mods.fml.common.event.FMLInterModComms;
import de.keridos.craftingutilities.data.Config;
import extrabiomes.api.Stuff;
import extrabiomes.lib.BlockSettings;
import gregtechmod.api.GregTech_API;
import ic2.core.Ic2Items;
import magicalcrops.ConfigHandler;
import mrtjp.projectred.core.Configurator;
import powercrystals.minefactoryreloaded.MineFactoryReloadedCore;

/**
 * Created by Nico on 26.02.14.
 */
public class FacadeSupport {
    private static FacadeSupport instance = null;
    private static Config Configuration = Config.getInstance();

    private FacadeSupport() {
    }

    public static FacadeSupport getInstance() {
        if (instance == null) {
            instance = new FacadeSupport();
        }
        return instance;
    }

    private void registerFacade(int id, int c) {
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", String.format("%d@%d", id, c));
    }

    public void registerModFacades() {
        registerMFRFacades();
        registerGTFacades();
        registerBoPFacades();
        registerEBXLFacades();
        registerPRFacades();
        registerIC2Facades();
        registerGSFacades();
        registerMagCropsFacades();
    }

    private void registerMFRFacades() {
        if (ModCompatability.MFRLoaded && Configuration.addMFRMicroblocks) {
            for (int i = 0; i < 11; i++) {
                registerFacade(MineFactoryReloadedCore.factoryDecorativeBrickBlock.blockID, i);
            }
            for (int i = 0; i < 12; i++) {
                registerFacade(MineFactoryReloadedCore.factoryDecorativeStoneBlock.blockID, i);
            }
        }
    }

    private void registerPRFacades() {
        if (ModCompatability.PRLoaded && Configuration.addProjRedMicroblocks) {
            registerFacade(Configurator.block_oresID.getInt(), 0);
            registerFacade(Configurator.block_oresID.getInt(), 1);
            registerFacade(Configurator.block_oresID.getInt(), 2);
            for (int i = 0; i <= 7; i++) {
                registerFacade(Configurator.block_stonesID.getInt(), i);
            }
        }
    }

    private void registerGTFacades() {
        if (ModCompatability.GTLoaded && Configuration.addGTMicroblocks) {
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

    private void registerBoPFacades() {
        if (ModCompatability.BoPLoaded && Configuration.addBoPMicroblocks) {
            registerFacade(BOPConfigurationIDs.mudBrickBlockID, 0);
            registerFacade(BOPConfigurationIDs.redRockID, 0);
            registerFacade(BOPConfigurationIDs.redRockID, 1);
            registerFacade(BOPConfigurationIDs.redRockID, 2);
            registerFacade(BOPConfigurationIDs.hardDirtID, 0);
            registerFacade(BOPConfigurationIDs.hardSandID, 0);
            registerFacade(BOPConfigurationIDs.holyStoneID, 0);
            registerFacade(BOPConfigurationIDs.holyStoneID, 1);
            registerFacade(BOPConfigurationIDs.holyStoneID, 2);
            registerFacade(BOPConfigurationIDs.cragRockID, 0);
            for (int i = 0; i < 14; i++) {
                registerFacade(BOPConfigurationIDs.planksID, i);
            }
            for (int i = 0; i < 14; i++) {
                registerFacade(BOPConfigurationIDs.amethystOreID, i);
            }
        }
    }

    private void registerEBXLFacades() {
        if (ModCompatability.EBXLLoaded && Configuration.addEBXLMicroblocks) {
            registerFacade(BlockSettings.REDROCK.getID(), 0);
            registerFacade(BlockSettings.REDROCK.getID(), 1);
            registerFacade(BlockSettings.REDROCK.getID(), 2);
            for (int i = 0; i < 14; i++) {
                registerFacade(Stuff.planks.get().blockID, i);
            }
            for (int i = 0; i < 14; i++) {
                registerFacade(BlockSettings.NEWLOG.getID(), 0);
            }
        }
    }

    private void registerIC2Facades() {
        if (ModCompatability.IC2Loaded && Configuration.addIC2Microblocks) {
            if (Ic2Items.copperOre != null) {
                registerFacade(Ic2Items.copperOre.itemID, 0);
            }
            if (Ic2Items.tinOre != null) {
                registerFacade(Ic2Items.tinOre.itemID, 0);
            }
            if (Ic2Items.uraniumOre != null) {
                registerFacade(Ic2Items.uraniumOre.itemID, 0);
            }
            if (Ic2Items.leadOre != null) {
                registerFacade(Ic2Items.leadOre.itemID, 0);
            }
            if (Ic2Items.reinforcedStone != null) {
                registerFacade(Ic2Items.reinforcedStone.itemID, 0);
            }
            if (Ic2Items.reinforcedGlass != null) {
                registerFacade(Ic2Items.reinforcedGlass.itemID, 0);
            }
            if (Ic2Items.copperBlock != null) {
                for (int i = 0; i < 4; i++) {
                    registerFacade(Ic2Items.copperBlock.itemID, i);
                }
            }
        }
    }

    private void registerGSFacades() {
        try {
            if (ModCompatability.GSLoaded && Configuration.addGSMicroblocks) {
                int[] blockArray1 = {GeoBlocks.BRICK.getBlockID(), GeoBlocks.COBBLE.getBlockID(), GeoBlocks.ENGRAVED.getBlockID(), GeoBlocks.FITTED.getBlockID(), GeoBlocks.INSCRIBED.getBlockID(), GeoBlocks.ROUND.getBlockID(), GeoBlocks.SMOOTH.getBlockID(), GeoBlocks.TILE.getBlockID()};
                int[] blockArray2 = {GeoBlocks.BRICK2.getBlockID(), GeoBlocks.COBBLE2.getBlockID(), GeoBlocks.ENGRAVED2.getBlockID(), GeoBlocks.FITTED2.getBlockID(), GeoBlocks.INSCRIBED2.getBlockID(), GeoBlocks.ROUND2.getBlockID(), GeoBlocks.SMOOTH2.getBlockID(), GeoBlocks.TILE2.getBlockID()};
                for (int j = 0; j < blockArray1.length; j++) {
                    for (int i = 0; i < 16; i++) {
                        registerFacade(blockArray1[j], i);
                    }
                }

                //for (int j = 0; j < blockArray2.length; j++) {
                //    registerFacade(blockArray2[j], 0);
                //}
            }
        } catch (Exception e) {
        }
    }

    private void registerMagCropsFacades() {
        try {
            if (ModCompatability.MagCropsLoaded && Configuration.addMagCropsMicroblocks) {
                for (int i = 0; i < 12; i++) {
                    registerFacade(ConfigHandler.BlockEssenceBrickID, i);
                }
                for (int i = 0; i < 12; i++) {
                    registerFacade(ConfigHandler.BlockEssenceGlassID, i);
                }
                for (int i = 0; i < 12; i++) {
                    registerFacade(ConfigHandler.BlockEssenceStoneID, i);
                }
            }
        } catch (Exception e) {
        }
    }
}
