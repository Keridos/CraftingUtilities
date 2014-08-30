package de.keridos.craftingutilities.data;

import net.minecraftforge.common.config.Configuration;

public class Config {
    public static boolean chiseledStoneBrickCrafting;
    public static boolean crackedStoneBrickCrafting;
    public static boolean grassCrafting;
    public static boolean mossyCobbleCrafting;
    public static boolean mossyStoneBrickCrafting;
    public static boolean slabToBlockCobbleCrafting;
    public static boolean slabToBlockStoneCrafting;
    public static boolean slabToBlockStoneBrickCrafting;
    public static boolean slabToBlockBrickCrafting;
    public static boolean slabToBlockNetherBrickCrafting;
    public static boolean slabToBlockOakWoodCrafting;
    public static boolean slabToBlockSpruceWoodCrafting;
    public static boolean slabToBlockBirchWoodCrafting;
    public static boolean slabToBlockJungleWoodCrafting;
    public static boolean slabToBlockAcaciaWoodCrafting;
    public static boolean slabToBlockDarkOakWoodCrafting;
    public static boolean chiseledSandstoneUncrafting;
    public static boolean clayUncrafting;
    public static boolean brickUncrafting;
    public static boolean grassUncrafting;
    public static boolean myceliumUncrafting;
    public static boolean wheatUncrafting;
    public static boolean stairsOakWoodUncrafting;
    public static boolean stairsStoneUncrafting;
    public static boolean stairsBricksUncrafting;
    public static boolean stairsStoneBricksUncrafting;
    public static boolean stairsSandstoneUncrafting;
    public static boolean stairsNetherBrickUncrafting;
    public static boolean stairsSpruceWoodUncrafting;
    public static boolean stairsBirchWoodUncrafting;
    public static boolean stairsJungleWoodUncrafting;
    public static boolean stairsAcaciaWoodUncrafting;
    public static boolean stairsDarkOakWoodUncrafting;
    public static boolean stairsQuartzUncrafting;
    public static boolean ironPickaxeSmelting;
    public static boolean ironAxeSmelting;
    public static boolean ironHoeSmelting;
    public static boolean ironSwordSmelting;
    public static boolean ironHelmetSmelting;
    public static boolean ironLeggingsSmelting;
    public static boolean ironBootsSmelting;
    public static boolean ironChestplateSmelting;
    public static boolean goldPickaxeSmelting;
    public static boolean goldAxeSmelting;
    public static boolean goldHoeSmelting;
    public static boolean goldSwordSmelting;
    public static boolean goldHelmetSmelting;
    public static boolean goldLeggingsSmelting;
    public static boolean goldBootsSmelting;
    public static boolean goldChestplateSmelting;
    public static boolean bronzePickaxeSmelting;
    public static boolean bronzeAxeSmelting;
    public static boolean bronzeHoeSmelting;
    public static boolean bronzeSwordSmelting;
    public static boolean bronzeHelmetSmelting;
    public static boolean bronzeChestplateSmelting;
    public static boolean bronzeLeggingsSmelting;
    public static boolean bronzeBootsSmelting;
    public static boolean coalDustCompression;
    public static boolean addGTMicroblocks;
    public static boolean overwriteConflictingRecipes;
    public static boolean autoCrafter;
    public static boolean craftingStation;
    private static Config instance = null;

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
        slabToBlockStoneCrafting = config.get("crafting", "slabToBlockStoneCrafting", true).getBoolean(true);
        slabToBlockStoneBrickCrafting = config.get("crafting", "slabToBlockStoneBrickCrafting", true).getBoolean(true);
        slabToBlockBrickCrafting = config.get("crafting", "slabToBlockBrickCrafting", true).getBoolean(true);
        slabToBlockNetherBrickCrafting = config.get("crafting", "slabToBlockNetherBrickCrafting", true).getBoolean(true);
        slabToBlockOakWoodCrafting = config.get("crafting", "slabToBlockOakWoodCrafting", true).getBoolean(true);
        slabToBlockSpruceWoodCrafting = config.get("crafting", "slabToBlockSpruceWoodCrafting", true).getBoolean(true);
        slabToBlockBirchWoodCrafting = config.get("crafting", "slabToBlockBirchWoodCrafting", true).getBoolean(true);
        slabToBlockJungleWoodCrafting = config.get("crafting", "slabToBlockJungleWoodCrafting", true).getBoolean(true);
        slabToBlockAcaciaWoodCrafting = config.get("crafting", "slabToBlockAcaciaWoodCrafting", true).getBoolean(true);
        slabToBlockDarkOakWoodCrafting = config.get("crafting", "slabToBlockDarkOakWoodCrafting", true).getBoolean(true);
    }

    private void uncraftingConfig(Configuration config) {
        config.getCategory("uncrafting");
        chiseledSandstoneUncrafting = config.get("uncrafting", "chiseledSandstoneUncrafting", true).getBoolean(true);
        clayUncrafting = config.get("uncrafting", "clayUncrafting", true).getBoolean(true);
        brickUncrafting = config.get("uncrafting", "brickUncrafting", true).getBoolean(true);
        grassUncrafting = config.get("uncrafting", "grassUncrafting", true).getBoolean(true);
        myceliumUncrafting = config.get("uncrafting", "myceliumUncrafting", true).getBoolean(true);
        wheatUncrafting = config.get("uncrafting", "wheatUncrafting", true).getBoolean(true);
        stairsStoneUncrafting = config.get("uncrafting", "stairsStoneUncrafting", true).getBoolean(true);
        stairsBricksUncrafting = config.get("uncrafting", "stairsBricksUncrafting", true).getBoolean(true);
        stairsStoneBricksUncrafting = config.get("uncrafting", "stairsStoneBricksUncrafting", true).getBoolean(true);
        stairsSandstoneUncrafting = config.get("uncrafting", "stairsSandstoneUncrafting", true).getBoolean(true);
        stairsNetherBrickUncrafting = config.get("uncrafting", "stairsNetherBrickUncrafting", true).getBoolean(true);
        stairsOakWoodUncrafting = config.get("uncrafting", "stairsOakWoodUncrafting", true).getBoolean(true);
        stairsSpruceWoodUncrafting = config.get("uncrafting", "stairsSpruceWoodUncrafting", true).getBoolean(true);
        stairsBirchWoodUncrafting = config.get("uncrafting", "stairsBirchWoodUncrafting", true).getBoolean(true);
        stairsJungleWoodUncrafting = config.get("uncrafting", "stairsJungleWoodUncrafting", true).getBoolean(true);
        stairsAcaciaWoodUncrafting = config.get("uncrafting", "stairsAcaciaWoodUncrafting", true).getBoolean(true);
        stairsDarkOakWoodUncrafting = config.get("uncrafting", "stairsDarkOakWoodUncrafting", true).getBoolean(true);
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
        config.addCustomCategoryComment("blocks", "Setting a setting to false will neither register the block, nor its recipes.");
        autoCrafter = config.get("blocks", "autoCrafterEnabled", true).getBoolean(true);
        craftingStation = config.get("blocks", "craftingStationEnabled", true).getBoolean(true);
    }

    public void featureConfig(Configuration config) {
        config.getCategory("microblocks");
        config.addCustomCategoryComment("microblocks", "Facades Support for Mods");
        addGTMicroblocks = config.get("microblocks", "addGTMicroblocks", true).getBoolean(true);
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
