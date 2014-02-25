package de.keridos.craftingutilities.data;

import cpw.mods.fml.common.registry.GameRegistry;
import de.keridos.craftingutilities.blocks.Blocks;
import de.keridos.craftingutilities.compatability.ModCompatability;
import ic2.api.recipe.RecipeInputItemStack;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;

public class Recipes {
    private static Recipes instance = null;
    private static Config Configuration = Config.getInstance();
    private static ModCompatability ModCompat = ModCompatability.getInstance();
    private static Blocks BlockHandler = Blocks.getInstance();

    private Recipes() {
    }

    public static Recipes getInstance() {
        if (instance == null) {
            instance = new Recipes();
        }
        return instance;
    }

    private class LocalInventoryCrafting extends InventoryCrafting {
        private int inventoryWidth = 3;
        private ItemStack[] stackList = new ItemStack[9];

        public LocalInventoryCrafting() {
            super(new Container() {
                @Override
                public boolean canInteractWith(EntityPlayer entityplayer) {
                    return false;
                }
            }, 3, 3);
        }

        @Override
        public void setInventorySlotContents(int slot, ItemStack itemstack) {
            stackList[slot] = itemstack;
        }

        @Override
        public ItemStack getStackInSlot(int par1) {
            return par1 >= this.getSizeInventory() ? null : this.stackList[par1];
        }

        @Override
        public ItemStack getStackInRowAndColumn(int par1, int par2) {
            if (par1 >= 0 && par1 < this.inventoryWidth) {
                int k = par1 + par2 * this.inventoryWidth;
                return this.getStackInSlot(k);
            } else {
                return null;
            }
        }
    }


    private void registerCraftingRecipes() {
        if (Configuration.chiseledStoneBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 4, 3), "BB", "BB", 'B', new ItemStack(Block.stoneBrick, 1, 0));
        }
        if (Configuration.crackedStoneBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 4, 2), "BB", "BB", 'B', new ItemStack(Block.stoneBrick, 1, 3));
        }
        if (Configuration.grassCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.grass, 1), "SSS", "SDS", "SSS", 'D', new ItemStack(Block.dirt, 1), 'S',
                    new ItemStack(Item.seeds, 1));
        }
        if (Configuration.mossyCobbleCrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestoneMossy, 1), Block.cobblestone, Item.seeds, Item.seeds, Item.seeds,
                    Item.seeds);
        }
        if (Configuration.mossyStoneBrickCrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.stoneBrick, 1, 1), Block.stoneBrick, Item.seeds, Item.seeds, Item.seeds,
                    Item.seeds);
        }
        if (Configuration.slabToBlockCobbleCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.cobblestone, 1), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 3));
        }
        if (Configuration.slabToBlockBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.brick, 1), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 4));
        }
        if (Configuration.slabToBlockStoneBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 1, 0), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 5));
        }
        if (Configuration.slabToBlockNetherBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.netherBrick, 1), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 6));
        }
        if (Configuration.slabToBlockOakWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 0), "S", "S", 'S', new ItemStack(Block.woodSingleSlab, 1, 0));
        }
        if (Configuration.slabToBlockSpruceWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 1), "S", "S", 'S', new ItemStack(Block.woodSingleSlab, 1, 1));
        }
        if (Configuration.slabToBlockBirchWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 2), "S", "S", 'S', new ItemStack(Block.woodSingleSlab, 1, 2));
        }
        if (Configuration.slabToBlockJungleWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.planks, 1, 3), "S", "S", 'S', new ItemStack(Block.woodSingleSlab, 1, 3));
        }
        if (Configuration.stoneDoubleSlabCrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.stoneDoubleSlab, 1, 0), new ItemStack(Block.stoneDoubleSlab, 1, 8));
        }
        if (Configuration.stoneSlabToFullSlabCrafting) {
            GameRegistry.addRecipe(new ItemStack(Block.stoneDoubleSlab, 1, 8), "S", "S", 'S', new ItemStack(Block.stoneSingleSlab, 1, 0));
        }
        if (Configuration.brickUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Item.brick, 4), Block.brick);
        }
        if (Configuration.chiseledSandstoneUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.stoneSingleSlab, 2, 1), new ItemStack(Block.sandStone, 1, 1));
        }
        if (Configuration.clayUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Item.clay, 4), Block.blockClay);
        }
        if (Configuration.grassUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.dirt, 1), Block.grass);
        }
        if (Configuration.myceliumUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.dirt, 1), Block.mycelium);
        }
        if (Configuration.wheatUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Item.seeds, 1), Item.wheat);
        }
        if (Configuration.stairsOakWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 3, 0), Block.stairsWoodOak, Block.stairsWoodOak);
        }
        if (Configuration.stairsStoneUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone, 3), Block.stairsCobblestone, Block.stairsCobblestone);
        }
        if (Configuration.stairsBricksUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.brick, 3), Block.stairsBrick, Block.stairsBrick);
        }
        if (Configuration.stairsStoneBricksUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.stoneBrick, 3, 0), Block.stairsStoneBrick, Block.stairsStoneBrick);
        }
        if (Configuration.stairsSandstoneUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.sandStone, 3, 0), Block.stairsSandStone, Block.stairsSandStone);
        }
        if (Configuration.stairsNetherBrickUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.netherBrick, 3), Block.stairsNetherBrick, Block.stairsNetherBrick);
        }
        if (Configuration.stairsSpruceWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 3, 1), Block.stairsWoodSpruce, Block.stairsWoodSpruce);
        }
        if (Configuration.stairsBirchWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 3, 2), Block.stairsWoodBirch, Block.stairsWoodBirch);
        }
        if (Configuration.stairsJungleWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.planks, 3, 4), Block.stairsWoodJungle, Block.stairsWoodJungle);
        }
        if (Configuration.stairsQuartzUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(Block.blockNetherQuartz, 3, 0), Block.stairsNetherQuartz,
                    Block.stairsNetherQuartz);
        }
    }

    private void registerSmeltingRecipes() {
        if (Configuration.ironPickaxeSmelting) {
            FurnaceRecipes.smelting().addSmelting(257, 0, new ItemStack(Item.ingotIron, 2), 0.1F);
        }
        if (Configuration.ironAxeSmelting) {
            FurnaceRecipes.smelting().addSmelting(258, 0, new ItemStack(Item.ingotIron, 2), 0.1F);
        }
        if (Configuration.ironHoeSmelting) {
            FurnaceRecipes.smelting().addSmelting(292, 0, new ItemStack(Item.ingotIron, 1), 0.1F);
        }
        if (Configuration.ironSwordSmelting) {
            FurnaceRecipes.smelting().addSmelting(267, 0, new ItemStack(Item.ingotIron, 1), 0.1F);
        }
        if (Configuration.ironHelmetSmelting) {
            FurnaceRecipes.smelting().addSmelting(306, 0, new ItemStack(Item.ingotIron, 4), 0.1F);
        }
        if (Configuration.ironChestplateSmelting) {
            FurnaceRecipes.smelting().addSmelting(307, 0, new ItemStack(Item.ingotIron, 7), 0.1F);
        }
        if (Configuration.ironLeggingsSmelting) {
            FurnaceRecipes.smelting().addSmelting(308, 0, new ItemStack(Item.ingotIron, 6), 0.1F);
        }
        if (Configuration.ironBootsSmelting) {
            FurnaceRecipes.smelting().addSmelting(309, 0, new ItemStack(Item.ingotIron, 3), 0.1F);
        }
        if (Configuration.goldPickaxeSmelting) {
            FurnaceRecipes.smelting().addSmelting(285, 0, new ItemStack(Item.ingotGold, 2), 0.1F);
        }
        if (Configuration.goldAxeSmelting) {
            FurnaceRecipes.smelting().addSmelting(286, 0, new ItemStack(Item.ingotGold, 2), 0.1F);
        }
        if (Configuration.goldHoeSmelting) {
            FurnaceRecipes.smelting().addSmelting(294, 0, new ItemStack(Item.ingotGold, 1), 0.1F);
        }
        if (Configuration.goldSwordSmelting) {
            FurnaceRecipes.smelting().addSmelting(283, 0, new ItemStack(Item.ingotGold, 1), 0.1F);
        }
        if (Configuration.goldHelmetSmelting) {
            FurnaceRecipes.smelting().addSmelting(314, 0, new ItemStack(Item.ingotGold, 4), 0.1F);
        }
        if (Configuration.goldChestplateSmelting) {
            FurnaceRecipes.smelting().addSmelting(315, 0, new ItemStack(Item.ingotGold, 7), 0.1F);
        }
        if (Configuration.goldLeggingsSmelting) {
            FurnaceRecipes.smelting().addSmelting(316, 0, new ItemStack(Item.ingotGold, 6), 0.1F);
        }
        if (Configuration.goldBootsSmelting) {
            FurnaceRecipes.smelting().addSmelting(317, 0, new ItemStack(Item.ingotGold, 3), 0.1F);
        }
    }

    private void registerIC2Recipes() {
        if (Configuration.bronzePickaxeSmelting && !ModCompat.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompat.getIC2Item("bronzePickaxe").itemID, 0,
                    new ItemStack(ModCompat.getIC2Item("bronzeIngot").getItem(), 2), 0.1F);
        }
        if (Configuration.bronzeAxeSmelting && !ModCompat.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompat.getIC2Item("bronzeAxe").itemID, 0,
                    new ItemStack(ModCompat.getIC2Item("bronzeIngot").getItem(), 2), 0.1F);
        }
        if (Configuration.bronzeHoeSmelting && !ModCompat.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompat.getIC2Item("bronzeHoe").itemID, 0,
                    new ItemStack(ModCompat.getIC2Item("bronzeIngot").getItem(), 2), 0.1F);
        }
        if (Configuration.bronzeSwordSmelting && !ModCompat.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompat.getIC2Item("bronzeSword").itemID, 0,
                    new ItemStack(ModCompat.getIC2Item("bronzeIngot").getItem(), 1), 0.1F);
        }
        if (Configuration.bronzeHelmetSmelting && !ModCompat.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompat.getIC2Item("bronzeHelmet").itemID, 0,
                    new ItemStack(ModCompat.getIC2Item("bronzeIngot").getItem(), 4), 0.1F);
        }
        if (Configuration.bronzeChestplateSmelting && !ModCompat.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompat.getIC2Item("bronzeChestplate").itemID, 0,
                    new ItemStack(ModCompat.getIC2Item("bronzeIngot").getItem(), 7), 0.1F);
        }
        if (Configuration.bronzeLeggingsSmelting && !ModCompat.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompat.getIC2Item("bronzeLeggings").itemID, 0,
                    new ItemStack(ModCompat.getIC2Item("bronzeIngot").getItem(), 6), 0.1F);
        }
        if (Configuration.bronzeBootsSmelting && !ModCompat.GTLoaded) {
            FurnaceRecipes.smelting().addSmelting(ModCompat.getIC2Item("bronzeBoots").itemID, 0,
                    new ItemStack(ModCompat.getIC2Item("bronzeIngot").getItem(), 3), 0.1F);
        }
    }

    private void registerBlockRecipes() {
        if (Configuration.autoCrafterID > 0) {
            GameRegistry.addRecipe(new ItemStack(BlockHandler.blockAutoCrafter, 1), "IPI", "PWP", "LRL", 'I', new ItemStack(Item.ingotIron), 'P',
                    new ItemStack(Block.pistonBase), 'W', new ItemStack(Block.workbench), 'L', new ItemStack(Block.planks), 'R',
                    new ItemStack(Block.blockRedstone));
        }
        if (Configuration.craftingStationID < 0) {
            GameRegistry.addRecipe(new ItemStack(BlockHandler.blockCraftingStation, 1), "IPP", "PWP", "LRL", 'I', new ItemStack(Item.ingotIron),
                    'P', new ItemStack(Block.pistonBase), 'W', new ItemStack(Block.workbench), 'L', new ItemStack(Block.planks), 'R',
                    new ItemStack(Block.blockRedstone));
        }
    }

    public void registerOreRecipes(String ItemName, ItemStack item) {
        if ((Configuration.coalDustCompression) && (ModCompat.IC2Loaded) && (ItemName.equals("dustCoal"))) {
            if (ic2.api.recipe.Recipes.compressor.getOutputFor(item, true) == null) {
                ic2.api.recipe.Recipes.compressor.addRecipe(new RecipeInputItemStack(item, 1), new NBTTagCompound("0"),
                        new ItemStack(Item.coal, 1));
            }
        }
    }

    public void removeRecipes() {
        if (ModCompat.AM2Loaded) {
            System.out.println("Attempting to fix Recipes overwritten by AM2");
            LocalInventoryCrafting craftingGrid = new LocalInventoryCrafting();
            craftingGrid.setInventorySlotContents(0, new ItemStack(Block.stoneBrick, 1, 0));
            craftingGrid.setInventorySlotContents(1, new ItemStack(Block.stoneBrick, 1, 0));
            craftingGrid.setInventorySlotContents(3, new ItemStack(Block.stoneBrick, 1, 0));
            craftingGrid.setInventorySlotContents(4, new ItemStack(Block.stoneBrick, 1, 0));
            RemoveRecipeByCraftingGrid(craftingGrid, new ItemStack(Block.stoneBrick, 1, 3));
        }
    }

    public void initRecipes() {
        registerCraftingRecipes();
        if (!ModCompat.GTLoaded) {
            registerSmeltingRecipes();
        }
        if (ModCompat.IC2Loaded) {
            registerIC2Recipes();
        }
        registerBlockRecipes();
    }

    private void RemoveRecipeByOutput(ItemStack resultItem) {
        ItemStack recipeResult;
        ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

        for (int scan = 0; scan < recipes.size(); scan++) {
            IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
            recipeResult = tmpRecipe.getRecipeOutput();
            if (recipeResult != null) {
                if (recipeResult.itemID == resultItem.itemID && recipeResult.getItemDamage() == resultItem.getItemDamage() && recipeResult.stackSize == resultItem.stackSize) {
                    System.out.println("Removed Recipes for " + recipeResult.getDisplayName() + " :" + recipes.get(scan) + " ===> " + recipeResult);
                    recipes.remove(scan);
                    scan--;
                }
            }
        }
    }

    private void RemoveRecipeByCraftingGrid(InventoryCrafting craftingGrid, ItemStack overriddenOutput) {
        ItemStack recipeResult;
        ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

        for (int scan = 0; scan < recipes.size(); scan++) {
            IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
            recipeResult = tmpRecipe.getRecipeOutput();
            if (recipeResult != null) {
                if (tmpRecipe.matches(craftingGrid, null) && recipeResult.itemID == overriddenOutput.itemID && recipeResult.getItemDamage() == overriddenOutput.getItemDamage() && recipeResult.stackSize == overriddenOutput.stackSize) {
                    System.out.println("CraftingUtilities Removed Recipe by CraftingGrid: " + recipes.get(scan) + " ===> " + recipeResult);
                    recipes.remove(scan);
                    scan--;
                }

            }

        }
    }
}
