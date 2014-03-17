package de.keridos.craftingutilities.compatability;


import biomesoplenty.configuration.BOPConfigurationIDs;
import codechicken.microblock.BlockMicroMaterial;
import de.keridos.craftingutilities.data.Config;
import extrabiomes.api.Stuff;
import extrabiomes.lib.BlockSettings;
import gregtechmod.api.GregTech_API;
import ic2.core.Ic2Items;
import net.minecraft.block.Block;

/**
 * Created by Nico on 26.02.14.
 */
public class MultipartSupport {
    private static MultipartSupport instance = null;
    private static Config Configuration = Config.getInstance();

    private MultipartSupport() {
    }

    public static MultipartSupport getInstance() {
        if (instance == null) {
            instance = new MultipartSupport();
        }
        return instance;
    }

    public void registerMicroblocks() {
        registerGTMicroblocks();
        registerBoPMicroblocks();
        registerEBXLMicroblocks();
        registerIC2Microblocks();
    }

    private void registerGTMicroblocks() {
        try {
            if (ModCompatability.GTLoaded && Configuration.addGTMicroblocks) {
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
        } catch (Exception e) {
        }
    }

    private void registerBoPMicroblocks() {
        try {
            if (ModCompatability.BoPLoaded && !ModCompatability.ExtraUtilLoaded && Configuration.addBoPMicroblocks) {
                BlockMicroMaterial.createAndRegister(Block.blocksList[BOPConfigurationIDs.redRockID], 0);
                BlockMicroMaterial.createAndRegister(Block.blocksList[BOPConfigurationIDs.redRockID], 1);
                BlockMicroMaterial.createAndRegister(Block.blocksList[BOPConfigurationIDs.redRockID], 2);
                BlockMicroMaterial.createAndRegister(Block.blocksList[BOPConfigurationIDs.holyStoneID], 0);
                BlockMicroMaterial.createAndRegister(Block.blocksList[BOPConfigurationIDs.holyStoneID], 1);
                BlockMicroMaterial.createAndRegister(Block.blocksList[BOPConfigurationIDs.holyStoneID], 2);
                for (int i = 0; i < 14; i++) {
                    BlockMicroMaterial.createAndRegister(Block.blocksList[BOPConfigurationIDs.planksID], i);
                }
                for (int i = 0; i < 14; i++) {
                    BlockMicroMaterial.createAndRegister(Block.blocksList[BOPConfigurationIDs.amethystOreID], i);
                }
            }
        } catch (Exception e) {
        }
    }

    private void registerEBXLMicroblocks() {
        try {
            if (ModCompatability.EBXLLoaded && !ModCompatability.ExtraUtilLoaded && Configuration.addEBXLMicroblocks) {
                BlockMicroMaterial.createAndRegister(Block.blocksList[BlockSettings.REDROCK.getID()], 0);
                BlockMicroMaterial.createAndRegister(Block.blocksList[BlockSettings.REDROCK.getID()], 1);
                BlockMicroMaterial.createAndRegister(Block.blocksList[BlockSettings.REDROCK.getID()], 2);
                for (int i = 0; i < 14; i++) {
                    BlockMicroMaterial.createAndRegister(Block.blocksList[Stuff.planks.get().blockID], i);
                }
                for (int i = 0; i < 14; i++) {
                    BlockMicroMaterial.createAndRegister(Block.blocksList[BlockSettings.NEWLOG.getID()], 0);
                }
            }
        } catch (Exception e) {
        }
    }

    private void registerIC2Microblocks() {
        try {
            if (ModCompatability.IC2Loaded && Configuration.addIC2Microblocks) {
                if (Ic2Items.copperOre != null) {
                    BlockMicroMaterial.createAndRegister(Block.blocksList[Ic2Items.copperOre.itemID], 0);
                }
                if (Ic2Items.tinOre != null) {
                    BlockMicroMaterial.createAndRegister(Block.blocksList[Ic2Items.tinOre.itemID], 0);
                }
                if (Ic2Items.uraniumOre != null) {
                    BlockMicroMaterial.createAndRegister(Block.blocksList[Ic2Items.uraniumOre.itemID], 0);
                }
                if (Ic2Items.leadOre != null) {
                    BlockMicroMaterial.createAndRegister(Block.blocksList[Ic2Items.leadOre.itemID], 0);
                }
                BlockMicroMaterial.createAndRegister(Block.blocksList[Ic2Items.copperBlock.itemID], 0);
                BlockMicroMaterial.createAndRegister(Block.blocksList[Ic2Items.copperBlock.itemID], 1);
                BlockMicroMaterial.createAndRegister(Block.blocksList[Ic2Items.copperBlock.itemID], 2);
                BlockMicroMaterial.createAndRegister(Block.blocksList[Ic2Items.copperBlock.itemID], 3);
                BlockMicroMaterial.createAndRegister(Block.blocksList[Ic2Items.copperBlock.itemID], 4);
                BlockMicroMaterial.createAndRegister(Block.blocksList[Ic2Items.reinforcedStone.itemID], 0);
                BlockMicroMaterial.createAndRegister(Block.blocksList[Ic2Items.reinforcedGlass.itemID], 0);
            }
        } catch (Exception e) {
        }
    }
}
