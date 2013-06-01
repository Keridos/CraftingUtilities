/**
 *
 */
package de.keridos.utilityrecipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class Recipes {

    public static void registerRecipes() {
        if (Config.chiseledStoneBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 4, 3), "BB", "BB", Character.valueOf('B'),
                    new ItemStack(Block.stoneBrick, 1, 0));
        }
        if (Config.crackedStoneBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 4, 2), "BB", "BB", Character.valueOf('B'),
                    new ItemStack(Block.stoneBrick, 1, 3));
        }
        if (Config.grassCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.grass, 1), "SSS", "SDS", "SSS", Character.valueOf('D'),
                    new ItemStack(Block.dirt, 1), Character.valueOf('S'), new ItemStack(Item.seeds, 1));
        }
        if (Config.mossyCobbleCrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestoneMossy, 1), Block.cobblestone, Item.seeds,
                    Item.seeds, Item.seeds, Item.seeds);
        }
        if (Config.mossyStoneBrickCrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.stoneBrick, 1, 1), Block.stoneBrick, Item.seeds,
                    Item.seeds, Item.seeds, Item.seeds);
        }
        if (Config.slabToBlockCobbleCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.cobblestone, 1), "S", "S", Character.valueOf('S'), new ItemStack(Block.stoneSingleSlab, 1, 3));
        }
        if (Config.slabToBlockBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.brick, 1), "S", "S", Character.valueOf('S'), new ItemStack(Block.stoneSingleSlab, 1, 4));
        }
        if (Config.slabToBlockStoneBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 1, 0), "S", "S", Character.valueOf('S'), new ItemStack(Block.stoneSingleSlab, 1, 5));
        }
        if (Config.slabToBlockNetherBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.netherBrick, 1), "S", "S", Character.valueOf('S'), new ItemStack(Block.stoneSingleSlab, 1, 6));
        }
        if (Config.slabToBlockOakWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 0), "S", "S", Character.valueOf('S'), new ItemStack(Block.woodSingleSlab, 1, 0));
        }
        if (Config.slabToBlockSpruceWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 1), "S", "S", Character.valueOf('S'), new ItemStack(Block.woodSingleSlab, 1, 1));
        }
        if (Config.slabToBlockBirchWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 2), "S", "S", Character.valueOf('S'), new ItemStack(Block.woodSingleSlab, 1, 2));
        }
        if (Config.slabToBlockJungleWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 3), "S", "S", Character.valueOf('S'), new ItemStack(Block.woodSingleSlab, 1, 3));
        }
        if (Config.stoneDoubleSlabCrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.stoneDoubleSlab, 1, 0), new ItemStack(Block.stoneDoubleSlab, 1, 8));
        }
        if (Config.stoneSlabToFullSlabCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.stoneDoubleSlab, 1, 8), "S", "S", Character.valueOf('S'), new ItemStack(Block.stoneSingleSlab, 1, 0));
        }
        if (Config.brickUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Item.brick, 4), Block.brick);
        }
        if (Config.chiseledSandstoneUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.stoneSingleSlab, 2, 1), new ItemStack(Block.sandStone, 1, 1));
        }
        if (Config.clayUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Item.clay, 4), Block.blockClay);
        }
        if (Config.grassUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.dirt, 1), Block.grass);
        }
        if (Config.myceliumUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.dirt, 1), Block.mycelium);
        }
        if (Config.wheatUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Item.seeds, 1), Item.wheat);
        }
        if (Config.stairsOakWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 3, 0), Block.stairsWoodOak, Block.stairsWoodOak);
        }
        if (Config.stairsStoneUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone, 3), Block.stairsCobblestone, Block.stairsCobblestone);
        }
        if (Config.stairsBricksUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.brick, 3), Block.stairsBrick, Block.stairsBrick);
        }
        if (Config.stairsStoneBricksUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.stoneBrick, 3, 0), Block.stairsStoneBrick, Block.stairsStoneBrick);
        }
        if (Config.stairsSandstoneUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.sandStone, 3, 0), Block.stairsSandStone, Block.stairsSandStone);
        }
        if (Config.stairsNetherBrickUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.netherBrick, 3), Block.stairsNetherBrick, Block.stairsNetherBrick);
        }
        if (Config.stairsSpruceWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 3, 1), Block.stairsWoodSpruce, Block.stairsWoodSpruce);
        }
        if (Config.stairsBirchWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 3, 2), Block.stairsWoodBirch, Block.stairsWoodBirch);
        }
        if (Config.stairsJungleWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 3, 4), Block.stairsWoodJungle, Block.stairsWoodJungle);
        }
        if (Config.stairsQuartzUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.blockNetherQuartz, 3, 0), Block.stairsNetherQuartz, Block.stairsNetherQuartz);
        }
    }
}
