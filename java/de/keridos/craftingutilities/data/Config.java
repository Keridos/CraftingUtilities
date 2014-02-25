package de.keridos.craftingutilities.data;

import net.minecraftforge.common.Configuration;

public class Config {
    private static Config instance = null;
    public boolean chiseledStoneBrickCrafting;
    public boolean crackedStoneBrickCrafting;
    public boolean grassCrafting;
    public boolean mossyCobbleCrafting;
    public boolean mossyStoneBrickCrafting;
    public boolean stoneDoubleSlabCrafting;
    public boolean slabToBlockCobbleCrafting;
    public boolean slabToBlockBrickCrafting;
    public boolean slabToBlockNetherBrickCrafting;
    public boolean slabToBlockOakWoodCrafting;
    public boolean slabToBlockSpruceWoodCrafting;
    public boolean slabToBlockBirchWoodCrafting;
    public boolean slabToBlockJungleWoodCrafting;
    public boolean slabToBlockStoneBrickCrafting;
    public boolean stoneSlabToFullSlabCrafting;
    public boolean chiseledSandstoneUncrafting;

    public boolean clayUncrafting;
    public boolean brickUncrafting;
    public boolean grassUncrafting;
    public boolean myceliumUncrafting;
    public boolean wheatUncrafting;
    public boolean stairsOakWoodUncrafting;
    public boolean stairsStoneUncrafting;
    public boolean stairsBricksUncrafting;
    public boolean stairsStoneBricksUncrafting;
    public boolean stairsSandstoneUncrafting;
    public boolean stairsNetherBrickUncrafting;
    public boolean stairsSpruceWoodUncrafting;
    public boolean stairsBirchWoodUncrafting;
    public boolean stairsJungleWoodUncrafting;
    public boolean stairsQuartzUncrafting;

    public boolean ironPickaxeSmelting;
    public boolean ironAxeSmelting;
    public boolean ironHoeSmelting;
    public boolean ironSwordSmelting;
    public boolean ironHelmetSmelting;
    public boolean ironLeggingsSmelting;
    public boolean ironBootsSmelting;
    public boolean ironChestplateSmelting;
    public boolean goldPickaxeSmelting;
    public boolean goldAxeSmelting;
    public boolean goldHoeSmelting;
    public boolean goldSwordSmelting;
    public boolean goldHelmetSmelting;
    public boolean goldLeggingsSmelting;
    public boolean goldBootsSmelting;
    public boolean goldChestplateSmelting;

    public boolean bronzePickaxeSmelting;
    public boolean bronzeAxeSmelting;
    public boolean bronzeHoeSmelting;
    public boolean bronzeSwordSmelting;
    public boolean bronzeHelmetSmelting;
    public boolean bronzeChestplateSmelting;
    public boolean bronzeLeggingsSmelting;
    public boolean bronzeBootsSmelting;
    public boolean coalDustCompression;

    public boolean addGTMicroblocks;
    public boolean addMFRMicroblocks;
    public boolean overwriteConflictingRecipes;

    public int autoCrafterID;
    public int craftingStationID;

    private Config() {
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    private void craftingConfig(Configuration config) {
        config.getCategory("crafting");
        chiseledStoneBrickCrafting = config.get("crafting", "chiseledStoneBrickCrafting", true).getBoolean(true);
        crackedStoneBrickCrafting = config.get("crafting", "crackedStoneBrickCrafting", true).getBoolean(true);
        grassCrafting = config.get("crafting", "grassCrafting", true).getBoolean(true);
        mossyCobbleCrafting = config.get("crafting", "mossyCobbleCrafting", true).getBoolean(true);
        mossyStoneBrickCrafting = config.get("crafting", "mossyStoneBrickCrafting", true).getBoolean(true);
        slabToBlockCobbleCrafting = config.get("crafting", "slabToBlockCobbleCrafting", true).getBoolean(true);
        slabToBlockBrickCrafting = config.get("crafting", "slabToBlockBrickCrafting", true).getBoolean(true);
        slabToBlockStoneBrickCrafting = config.get("crafting", "slabToBlockStoneBrickCrafting", true).getBoolean(true);
        slabToBlockStoneBrickCrafting = config.get("crafting", "stoneBrickSlabToBlockCrafting", true).getBoolean(true);
        slabToBlockNetherBrickCrafting = config.get("crafting", "slabToBlockNetherBrickCrafting", true).getBoolean(true);
        slabToBlockOakWoodCrafting = config.get("crafting", "slabToBlockOakWoodCrafting", true).getBoolean(true);
        slabToBlockSpruceWoodCrafting = config.get("crafting", "slabToBlockSpruceWoodCrafting", true).getBoolean(true);
        slabToBlockBirchWoodCrafting = config.get("crafting", "slabToBlockBirchWoodCrafting", true).getBoolean(true);
        slabToBlockJungleWoodCrafting = config.get("crafting", "slabToBlockJungleWoodCrafting", true).getBoolean(true);
        stoneDoubleSlabCrafting = config.get("crafting", "stoneDoubleSlabCrafting", true).getBoolean(true);
        stoneSlabToFullSlabCrafting = config.get("crafting", "stoneSlabToSlabBlockCrafting", true).getBoolean(true);
    }

    private void uncraftingConfig(Configuration config) {
        config.getCategory("uncrafting");
        chiseledSandstoneUncrafting = config.get("uncrafting", "chiseledSandstoneUncrafting", true).getBoolean(true);
        clayUncrafting = config.get("uncrafting", "clayUncrafting", true).getBoolean(true);
        brickUncrafting = config.get("uncrafting", "brickUncrafting", true).getBoolean(true);
        grassUncrafting = config.get("uncrafting", "grassUncrafting", true).getBoolean(true);
        myceliumUncrafting = config.get("uncrafting", "myceliumUncrafting", true).getBoolean(true);
        wheatUncrafting = config.get("uncrafting", "wheatUncrafting", true).getBoolean(true);
        stairsOakWoodUncrafting = config.get("uncrafting", "stairsOakWoodUncrafting", true).getBoolean(true);
        stairsStoneUncrafting = config.get("uncrafting", "stairsStoneUncrafting", true).getBoolean(true);
        stairsBricksUncrafting = config.get("uncrafting", "stairsBricksUncrafting", true).getBoolean(true);
        stairsStoneBricksUncrafting = config.get("uncrafting", "stairsStoneBricksUncrafting", true).getBoolean(true);
        stairsSandstoneUncrafting = config.get("uncrafting", "stairsSandstoneUncrafting", true).getBoolean(true);
        stairsNetherBrickUncrafting = config.get("uncrafting", "stairsNetherBrickUncrafting", true).getBoolean(true);
        stairsSpruceWoodUncrafting = config.get("uncrafting", "stairsSpruceWoodUncrafting", true).getBoolean(true);
        stairsBirchWoodUncrafting = config.get("uncrafting", "stairsBirchWoodUncrafting", true).getBoolean(true);
        stairsJungleWoodUncrafting = config.get("uncrafting", "stairsJungleWoodUncrafting", true).getBoolean(true);
        stairsQuartzUncrafting = config.get("uncrafting", "stairsQuartzUncrafting", true).getBoolean(true);
    }

    private void smeltingConfig(Configuration config) {
        config.getCategory("smelting");
        ironPickaxeSmelting = config.get("smelting", "ironPickaxeSmelting", true).getBoolean(true);
        ironAxeSmelting = config.get("smelting", "ironAxeSmelting", true).getBoolean(true);
        ironHoeSmelting = config.get("smelting", "ironHoeSmelting", true).getBoolean(true);
        ironSwordSmelting = config.get("smelting", "ironSwordSmelting", true).getBoolean(true);
        ironHelmetSmelting = config.get("smelting", "ironHelmetSmelting", true).getBoolean(true);
        ironChestplateSmelting = config.get("smelting", "ironChestplateSmelting", true).getBoolean(true);
        ironLeggingsSmelting = config.get("smelting", "ironLeggingsSmelting", true).getBoolean(true);
        ironBootsSmelting = config.get("smelting", "ironBootsSmelting", true).getBoolean(true);
        goldPickaxeSmelting = config.get("smelting", "goldPickaxeSmelting", true).getBoolean(true);
        goldAxeSmelting = config.get("smelting", "goldAxeSmelting", true).getBoolean(true);
        goldHoeSmelting = config.get("smelting", "goldHoeSmelting", true).getBoolean(true);
        goldSwordSmelting = config.get("smelting", "goldSwordSmelting", true).getBoolean(true);
        goldHelmetSmelting = config.get("smelting", "goldHelmetSmelting", true).getBoolean(true);
        goldChestplateSmelting = config.get("smelting", "goldChestplateSmelting", true).getBoolean(true);
        goldLeggingsSmelting = config.get("smelting", "goldLeggingsSmelting", true).getBoolean(true);
        goldBootsSmelting = config.get("smelting", "goldBootsSmelting", true).getBoolean(true);
    }

    private void IC2Config(Configuration config) {
        config.getCategory("ic2");
        bronzePickaxeSmelting = config.get("ic2", "bronzePickaxeSmelting", true).getBoolean(true);
        bronzeAxeSmelting = config.get("ic2", "bronzeAxeSmelting", true).getBoolean(true);
        bronzeHoeSmelting = config.get("ic2", "bronzeHoeSmelting", true).getBoolean(true);
        bronzeSwordSmelting = config.get("ic2", "bronzeSwordSmelting", true).getBoolean(true);
        bronzeHelmetSmelting = config.get("ic2", "bronzeHelmetSmelting", true).getBoolean(true);
        bronzeChestplateSmelting = config.get("ic2", "bronzeChestplateSmelting", true).getBoolean(true);
        bronzeLeggingsSmelting = config.get("ic2", "bronzeLeggingsSmelting", true).getBoolean(true);
        bronzeBootsSmelting = config.get("ic2", "bronzeBootsSmelting", true).getBoolean(true);
        coalDustCompression = config.get("ic2", "coalDustCompression", true).getBoolean(true);
    }

    public void blockConfig(Configuration config) {
        config.getCategory("blocks");
        config.addCustomCategoryComment("blocks", "Setting an ID to 0 will not register the block, nor its recipes.");
        autoCrafterID = config.get("blocks", "autoCrafterID", 3974).getInt();
        autoCrafterID = config.get("blocks", "autoCrafterID", 3975).getInt();
    }

    public void featureConfig(Configuration config) {
        config.getCategory("microblocks");
        config.addCustomCategoryComment("microblocks", "Forge Multipart and Facades Support for Mods");
        addGTMicroblocks = config.get("microblocks", "addGTMicroblocks", true).getBoolean(true);
        addMFRMicroblocks = config.get("microblocks", "addMFRMicroblocks", true).getBoolean(true);
        config.getCategory("general");
        overwriteConflictingRecipes = config.get("general", "overwriteConflictingRecipes", true).getBoolean(true);
    }

    public void initConfig(Configuration config) {
        config.load();
        craftingConfig(config);
        uncraftingConfig(config);
        smeltingConfig(config);
        IC2Config(config);
        blockConfig(config);
        featureConfig(config);
        config.save();
    }
}
