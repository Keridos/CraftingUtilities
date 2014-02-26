package de.keridos.craftingutilities.compatability;


import biomesoplenty.configuration.BOPConfigurationIDs;
import cpw.mods.fml.common.event.FMLInterModComms;
import de.keridos.craftingutilities.data.Config;
import extrabiomes.api.Stuff;
import extrabiomes.lib.BlockSettings;
import gregtechmod.api.GregTech_API;
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
    }

    private void registerMFRFacades() {
        if (ModCompatability.BCLoaded && ModCompatability.MFRLoaded && Configuration.addMFRMicroblocks) {
            for (int i = 0; i < 11; i++) {
                registerFacade(MineFactoryReloadedCore.factoryDecorativeBrickBlock.blockID, i);
            }
            for (int i = 0; i < 12; i++) {
                registerFacade(MineFactoryReloadedCore.factoryDecorativeStoneBlock.blockID, i);
            }
        }
    }

    private void registerGTFacades() {
        if (ModCompatability.BCLoaded && ModCompatability.GTLoaded && Configuration.addGTMicroblocks) {
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
        if (ModCompatability.BoPLoaded && ModCompatability.BCLoaded && Configuration.addBoPMicroblocks) {
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
        if (ModCompatability.EBXLLoaded && ModCompatability.BCLoaded && Configuration.addEBXLMicroblocks) {
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
}
