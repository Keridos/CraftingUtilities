package de.keridos.utilityrecipes;

import net.minecraftforge.common.Configuration;

public class Config {
    public static boolean chiseledStoneBrickCrafting;
    public static boolean crackedStoneBrickCrafting;
    public static boolean grassCrafting;
    public static boolean mossyCobbleCrafting;
    public static boolean mossyStoneBrickCrafting;
    public static boolean stoneDoubleSlabCrafting;
    public static boolean slabToBlockCobbleCrafting;
    public static boolean slabToBlockBrickCrafting;
    public static boolean slabToBlockNetherBrickCrafting;
    public static boolean slabToBlockOakWoodCrafting;
    public static boolean slabToBlockSpruceWoodCrafting;
    public static boolean slabToBlockBirchWoodCrafting;
    public static boolean slabToBlockJungleWoodCrafting;
    public static boolean slabToBlockStoneBrickCrafting;
    public static boolean stoneSlabToFullSlabCrafting;
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
    public static boolean stairsQuartzUncrafting;

    public static boolean ironPickaxeUnsmelting;
    public static boolean ironAxeUnsmelting;
    public static boolean ironHoeUnsmelting;
    public static boolean ironSwordUnsmelting;
    public static boolean goldPickaxeUnsmelting;
    public static boolean goldAxeUnsmelting;
    public static boolean goldHoeUnsmelting;
    public static boolean goldSwordUnsmelting;


    public static void initConfig(Configuration config) {
        config.load();
        config.getCategory("crafting");
        config.getCategory("uncrafting");
        config.getCategory("smelting");
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

        ironPickaxeUnsmelting = config.get("smelting", "ironPickaxeUnsmelting", true).getBoolean(true);
        ironAxeUnsmelting = config.get("smelting", "ironAxeUnsmelting", true).getBoolean(true);
        ironHoeUnsmelting = config.get("smelting", "ironHoeUnsmelting", true).getBoolean(true);
        ironSwordUnsmelting = config.get("smelting", "ironSwordUnsmelting", true).getBoolean(true);
        goldPickaxeUnsmelting = config.get("smelting", "goldPickaxeUnsmelting", true).getBoolean(true);
        goldAxeUnsmelting = config.get("smelting", "goldAxeUnsmelting", true).getBoolean(true);
        goldHoeUnsmelting = config.get("smelting", "goldHoeUnsmelting", true).getBoolean(true);
        goldSwordUnsmelting = config.get("smelting", "goldSwordUnsmelting", true).getBoolean(true);

        config.save();
    }
}
