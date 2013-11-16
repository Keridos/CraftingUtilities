package de.keridos.utilityrecipes.data;

import cpw.mods.fml.common.registry.GameRegistry;
import de.keridos.utilityrecipes.blocks.Blocks;
import de.keridos.utilityrecipes.compatability.ModCompatability;
import ic2.api.recipe.RecipeInputItemStack;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;

public class Recipes {
    private static void registerCraftingRecipes() {
        if (Config.chiseledStoneBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 4, 3), "BB", "BB", 'B', new ItemStack(Block.stoneBrick, 1, 0));
        }
        if (Config.crackedStoneBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 4, 2), "BB", "BB", 'B', new ItemStack(Block.stoneBrick, 1, 3));
        }
        if (Config.grassCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.grass, 1), "SSS", "SDS", "SSS", 'D', new ItemStack(Block.dirt, 1), 'S',
                    new ItemStack(Item.seeds, 1));
        }
        if (Config.mossyCobbleCrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestoneMossy, 1), Block.cobblestone, Item.seeds, Item.seeds, Item.seeds,
                    Item.seeds);
        }
        if (Config.mossyStoneBrickCrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.stoneBrick, 1, 1), Block.stoneBrick, Item.seeds, Item.seeds, Item.seeds,
                    Item.seeds);
        }
        if (Config.slabToBlockCobbleCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.cobblestone, 1), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 3));
        }
        if (Config.slabToBlockBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.brick, 1), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 4));
        }
        if (Config.slabToBlockStoneBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 1, 0), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 5));
        }
        if (Config.slabToBlockNetherBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.netherBrick, 1), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 6));
        }
        if (Config.slabToBlockOakWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 0), "S", "S", 'S', new ItemStack(Block.woodSingleSlab, 1, 0));
        }
        if (Config.slabToBlockSpruceWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 1), "S", "S", 'S', new ItemStack(Block.woodSingleSlab, 1, 1));
        }
        if (Config.slabToBlockBirchWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 2), "S", "S", 'S', new ItemStack(Block.woodSingleSlab, 1, 2));
        }
        if (Config.slabToBlockJungleWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 3), "S", "S", 'S', new ItemStack(Block.woodSingleSlab, 1, 3));
        }
        if (Config.stoneDoubleSlabCrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.stoneDoubleSlab, 1, 0), new ItemStack(Block.stoneDoubleSlab, 1, 8));
        }
        if (Config.stoneSlabToFullSlabCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.stoneDoubleSlab, 1, 8), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 0));
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
            GameRegistry.addShapelessRecipe(new ItemStack(Block.blockNetherQuartz, 3, 0), Block.stairsNetherQuartz,
                    Block.stairsNetherQuartz);
        }
    }

    private static void registerSmeltingRecipes() {
        if (Config.ironPickaxeSmelting) {
            FurnaceRecipes.smelting().addSmelting(257, 0, new ItemStack(Item.ingotIron, 2), 0.1F);
        }
        if (Config.ironAxeSmelting) {
            FurnaceRecipes.smelting().addSmelting(258, 0, new ItemStack(Item.ingotIron, 2), 0.1F);
        }
        if (Config.ironHoeSmelting) {
            FurnaceRecipes.smelting().addSmelting(292, 0, new ItemStack(Item.ingotIron, 1), 0.1F);
        }
        if (Config.ironSwordSmelting) {
            FurnaceRecipes.smelting().addSmelting(267, 0, new ItemStack(Item.ingotIron, 1), 0.1F);
        }
        if (Config.ironHelmetSmelting) {
            FurnaceRecipes.smelting().addSmelting(306, 0, new ItemStack(Item.ingotIron, 4), 0.1F);
        }
        if (Config.ironChestplateSmelting) {
            FurnaceRecipes.smelting().addSmelting(307, 0, new ItemStack(Item.ingotIron, 7), 0.1F);
        }
        if (Config.ironLeggingsSmelting) {
            FurnaceRecipes.smelting().addSmelting(308, 0, new ItemStack(Item.ingotIron, 6), 0.1F);
        }
        if (Config.ironBootsSmelting) {
            FurnaceRecipes.smelting().addSmelting(309, 0, new ItemStack(Item.ingotIron, 3), 0.1F);
        }
        if (Config.goldPickaxeSmelting) {
            FurnaceRecipes.smelting().addSmelting(285, 0, new ItemStack(Item.ingotGold, 2), 0.1F);
        }
        if (Config.goldAxeSmelting) {
            FurnaceRecipes.smelting().addSmelting(286, 0, new ItemStack(Item.ingotGold, 2), 0.1F);
        }
        if (Config.goldHoeSmelting) {
            FurnaceRecipes.smelting().addSmelting(294, 0, new ItemStack(Item.ingotGold, 1), 0.1F);
        }
        if (Config.goldSwordSmelting) {
            FurnaceRecipes.smelting().addSmelting(283, 0, new ItemStack(Item.ingotGold, 1), 0.1F);
        }
        if (Config.goldHelmetSmelting) {
            FurnaceRecipes.smelting().addSmelting(314, 0, new ItemStack(Item.ingotGold, 4), 0.1F);
        }
        if (Config.goldChestplateSmelting) {
            FurnaceRecipes.smelting().addSmelting(315, 0, new ItemStack(Item.ingotGold, 7), 0.1F);
        }
        if (Config.goldLeggingsSmelting) {
            FurnaceRecipes.smelting().addSmelting(316, 0, new ItemStack(Item.ingotGold, 6), 0.1F);
        }
        if (Config.goldBootsSmelting) {
            FurnaceRecipes.smelting().addSmelting(317, 0, new ItemStack(Item.ingotGold, 3), 0.1F);
        }
    }

    private static void registerIC2Recipes() {
        if (Config.bronzePickaxeSmelting && !ModCompatability.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompatability.getIC2Item("bronzePickaxe").itemID, 0,
                    new ItemStack(ModCompatability.getIC2Item("bronzeIngot").getItem(), 2), 0.1F);
        }
        if (Config.bronzeAxeSmelting && !ModCompatability.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompatability.getIC2Item("bronzeAxe").itemID, 0,
                    new ItemStack(ModCompatability.getIC2Item("bronzeIngot").getItem(), 2), 0.1F);
        }
        if (Config.bronzeHoeSmelting && !ModCompatability.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompatability.getIC2Item("bronzeHoe").itemID, 0,
                    new ItemStack(ModCompatability.getIC2Item("bronzeIngot").getItem(), 2), 0.1F);
        }
        if (Config.bronzeSwordSmelting && !ModCompatability.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompatability.getIC2Item("bronzeSword").itemID, 0,
                    new ItemStack(ModCompatability.getIC2Item("bronzeIngot").getItem(), 1), 0.1F);
        }
        if (Config.bronzeHelmetSmelting && !ModCompatability.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompatability.getIC2Item("bronzeHelmet").itemID, 0,
                    new ItemStack(ModCompatability.getIC2Item("bronzeIngot").getItem(), 4), 0.1F);
        }
        if (Config.bronzeChestplateSmelting && !ModCompatability.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompatability.getIC2Item("bronzeChestplate").itemID, 0,
                    new ItemStack(ModCompatability.getIC2Item("bronzeIngot").getItem(), 7), 0.1F);
        }
        if (Config.bronzeLeggingsSmelting && !ModCompatability.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompatability.getIC2Item("bronzeLeggings").itemID, 0,
                    new ItemStack(ModCompatability.getIC2Item("bronzeIngot").getItem(), 6), 0.1F);
        }
        if (Config.bronzeBootsSmelting && !ModCompatability.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompatability.getIC2Item("bronzeBoots").itemID, 0,
                    new ItemStack(ModCompatability.getIC2Item("bronzeIngot").getItem(), 3), 0.1F);
        }
    }

    private static void registerBlockRecipes() {
        if (Config.autoCrafterID > 0) {
            GameRegistry.addRecipe(new ItemStack(Blocks.blockAutoCrafter, 1), "IPI", "PWP", "LRL", 'I', new ItemStack(Item.ingotIron), 'P',
                    new ItemStack(Block.pistonBase), 'W', new ItemStack(Block.workbench), 'L', new ItemStack(Block.planks), 'R',
                    new ItemStack(Block.blockRedstone));
        }
        if (Config.craftingStationID < 0) {
            GameRegistry.addRecipe(new ItemStack(Blocks.blockCraftingStation, 1), "IPP", "PWP", "LRL", 'I', new ItemStack(Item.ingotIron),
                    'P', new ItemStack(Block.pistonBase), 'W', new ItemStack(Block.workbench), 'L', new ItemStack(Block.planks), 'R',
                    new ItemStack(Block.blockRedstone));
        }
    }

    public static void registerRecipes(String ItemName, ItemStack item) {
        if ((Config.coalDustCompression) && (ModCompatability.IC2Loaded) && (ItemName.equals("dustCoal"))) {
            if (ic2.api.recipe.Recipes.compressor.getOutputFor(item, true) == null) {
                ic2.api.recipe.Recipes.compressor.addRecipe(new RecipeInputItemStack(item, 1), new NBTTagCompound("0"),
                        new ItemStack(Item.coal, 1));
            }
        }
    }

    public static void removeRecipes() {
        if (ModCompatability.AM2Loaded) {
            RemoveRecipe(new ItemStack(Block.stoneBrick, 1, 3));
        }
    }

    public static void initRecipes() {
        removeRecipes();
        registerCraftingRecipes();
        if (!ModCompatability.GTLoaded) {
            registerSmeltingRecipes();
        }
        if (ModCompatability.IC2Loaded) {
            registerIC2Recipes();
        }
        registerBlockRecipes();
    }

    static void RemoveRecipe(ItemStack resultItem) {
        ItemStack recipeResult = null;
        ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

        for (int scan = 0; scan < recipes.size(); scan++) {
            IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
            recipeResult = tmpRecipe.getRecipeOutput();
            if (recipeResult != null) {
                if (recipeResult.itemID == resultItem.itemID && recipeResult.getItemDamage() == resultItem.getItemDamage()) {
                    System.out.println("Removed Recipe: " + recipes.get(scan) + " ===> " + recipeResult);
                    recipes.remove(scan);
                    scan--;
                }
            }
        }
    }
}
