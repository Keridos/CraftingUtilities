package de.keridos.utilityrecipes.data;

import de.keridos.utilityrecipes.blocks.Blocks;
import de.keridos.utilityrecipes.compatability.ModCompatability;
import ic2.api.recipe.RecipeInputItemStack;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes {
    private static void registerCraftingRecipes() {
        if (Config.chiseledStoneBrickCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapedOreRecipe(new ItemStack(Block.stoneBrick, 4, 3), "BB", "BB", 'B', new ItemStack(Block.stoneBrick, 1, 0)));
        }
        if (Config.crackedStoneBrickCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapedOreRecipe(new ItemStack(Block.stoneBrick, 4, 2), "BB", "BB", 'B', new ItemStack(Block.stoneBrick, 1, 3)));
        }
        if (Config.grassCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapedOreRecipe(new ItemStack(Block.grass, 1), "SSS", "SDS", "SSS", 'D', new ItemStack(Block.dirt, 1), 'S',
                            new ItemStack(Item.seeds, 1)));
        }
        if (Config.mossyCobbleCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.cobblestoneMossy, 1), Block.cobblestone, Item.seeds, Item.seeds, Item.seeds,
                            Item.seeds));
        }
        if (Config.mossyStoneBrickCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.stoneBrick, 1, 1), Block.stoneBrick, Item.seeds, Item.seeds, Item.seeds,
                            Item.seeds));
        }
        if (Config.slabToBlockCobbleCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapedOreRecipe(new ItemStack(Block.cobblestone, 1), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 3)));
        }
        if (Config.slabToBlockBrickCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapedOreRecipe(new ItemStack(Block.brick, 1), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 4)));
        }
        if (Config.slabToBlockStoneBrickCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapedOreRecipe(new ItemStack(Block.stoneBrick, 1, 0), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 5)));
        }
        if (Config.slabToBlockNetherBrickCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapedOreRecipe(new ItemStack(Block.netherBrick, 1), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 6)));
        }
        if (Config.slabToBlockOakWoodCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapedOreRecipe(new ItemStack(Block.planks, 1, 0), "S", "S", 'S', new ItemStack(Block.woodSingleSlab, 1, 0)));
        }
        if (Config.slabToBlockSpruceWoodCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapedOreRecipe(new ItemStack(Block.planks, 1, 1), "S", "S", 'S', new ItemStack(Block.woodSingleSlab, 1, 1)));
        }
        if (Config.slabToBlockBirchWoodCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapedOreRecipe(new ItemStack(Block.planks, 1, 2), "S", "S", 'S', new ItemStack(Block.woodSingleSlab, 1, 2)));
        }
        if (Config.slabToBlockJungleWoodCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapedOreRecipe(new ItemStack(Block.planks, 1, 3), "S", "S", 'S', new ItemStack(Block.woodSingleSlab, 1, 3)));
        }
        if (Config.stoneDoubleSlabCrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.stoneDoubleSlab, 1, 0), new ItemStack(Block.stoneDoubleSlab, 1, 8)));
        }
        if (Config.stoneSlabToFullSlabCrafting) {
            CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Block.stoneDoubleSlab, 1, 8), "S", "S", 'S',
                    new ItemStack(Block.stoneSingleSlab, 1, 0)));
        }
        if (Config.brickUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(Item.brick, 4), Block.brick));
        }
        if (Config.chiseledSandstoneUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.stoneSingleSlab, 2, 1), new ItemStack(Block.sandStone, 1, 1)));
        }
        if (Config.clayUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(Item.clay, 4), Block.blockClay));
        }
        if (Config.grassUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(Block.dirt, 1), Block.grass));
        }
        if (Config.myceliumUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(Block.dirt, 1), Block.mycelium));
        }
        if (Config.wheatUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(Item.seeds, 1), Item.wheat));
        }
        if (Config.stairsOakWoodUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.planks, 3, 0), Block.stairsWoodOak, Block.stairsWoodOak));
        }
        if (Config.stairsStoneUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.cobblestone, 3), Block.stairsCobblestone, Block.stairsCobblestone));
        }
        if (Config.stairsBricksUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.brick, 3), Block.stairsBrick, Block.stairsBrick));
        }
        if (Config.stairsStoneBricksUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.stoneBrick, 3, 0), Block.stairsStoneBrick, Block.stairsStoneBrick));
        }
        if (Config.stairsSandstoneUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.sandStone, 3, 0), Block.stairsSandStone, Block.stairsSandStone));
        }
        if (Config.stairsNetherBrickUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.netherBrick, 3), Block.stairsNetherBrick, Block.stairsNetherBrick));
        }
        if (Config.stairsSpruceWoodUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.planks, 3, 1), Block.stairsWoodSpruce, Block.stairsWoodSpruce));
        }
        if (Config.stairsBirchWoodUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.planks, 3, 2), Block.stairsWoodBirch, Block.stairsWoodBirch));
        }
        if (Config.stairsJungleWoodUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.planks, 3, 4), Block.stairsWoodJungle, Block.stairsWoodJungle));
        }
        if (Config.stairsQuartzUncrafting) {
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapelessOreRecipe(new ItemStack(Block.blockNetherQuartz, 3, 0), Block.stairsNetherQuartz,
                            Block.stairsNetherQuartz));
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
            CraftingManager.getInstance().getRecipeList().add(
                    new ShapedOreRecipe(new ItemStack(Blocks.blockAutoCrafter, 1), "IPI", "PWP", "LRL", 'I', new ItemStack(Item.ingotIron),
                            'P', new ItemStack(Block.pistonBase), 'W', new ItemStack(Block.workbench), 'L', new ItemStack(Block.planks),
                            'R', new ItemStack(Block.blockRedstone)));
        }
    }

    public static void registerOreRecipes(String ItemName, ItemStack item) {
        if ((Config.coalDustCompression) && (ModCompatability.IC2Loaded) && (ItemName.equals("dustCoal"))) {
            if (ic2.api.recipe.Recipes.compressor.getOutputFor(item, true) == null) {
                ic2.api.recipe.Recipes.compressor.addRecipe(new RecipeInputItemStack(item, 1), new NBTTagCompound("0"),
                        new ItemStack(Item.coal, 1));
            }
        }
    }

    public static void initRecipes() {
        registerCraftingRecipes();
        if (!ModCompatability.GTLoaded) {
            registerSmeltingRecipes();
        }
        if (ModCompatability.IC2Loaded) {
            registerIC2Recipes();
        }
        registerBlockRecipes();
    }
}
