package de.keridos.craftingutilities.data;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import de.keridos.craftingutilities.blocks.Blocks;
import de.keridos.craftingutilities.compatability.IC2Compat;
import de.keridos.craftingutilities.compatability.ModCompatability;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

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

    public Item getItem(String name) {
        Item item;
        item = GameData.getItemRegistry().getRaw("minecraft:" + name);
        return item;
    }

    private void registerCraftingRecipes() {
        if (Configuration.chiseledStoneBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(getItem("stonebrick"), 4, 3), "BB", "BB", 'B', new ItemStack(getItem("stoneBrick"), 1, 0));
        }
        if (Configuration.crackedStoneBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(getItem("stonebrick"), 4, 2), "BB", "BB", 'B', new ItemStack(getItem("stoneBrick"), 1, 3));
        }                                                                                                                                           
        if (Configuration.grassCrafting) {
            GameRegistry.addRecipe(new ItemStack(getItem("grass"), 1), "SSS", "SDS", "SSS", 'D', new ItemStack(getItem("dirt"), 1), 'S',
                    new ItemStack(getItem("wheat_seeds"), 1));
        }
        if (Configuration.mossyCobbleCrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("mossy_cobblestone"), 1), getItem("cobblestone"), getItem("wheat_seeds"), getItem("wheat_seeds"), getItem("wheat_seeds"),
                    getItem("wheat_seeds"));
        }
        if (Configuration.mossyStoneBrickCrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("stonebrick"), 1, 1), getItem("stonebrick"), getItem("wheat_seeds"), getItem("wheat_seeds"), getItem("wheat_seeds"),
                    getItem("wheat_seeds"));
        }
        if (Configuration.slabToBlockCobbleCrafting) {
            GameRegistry.addRecipe(new ItemStack(getItem("cobblestone"), 1), "S", "S", 'S', new ItemStack(getItem("stone_slab"), 1, 3));
        }
        if (Configuration.slabToBlockBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(getItem("brick"), 1), "S", "S", 'S', new ItemStack(getItem("stone_slab"), 1, 4));
        }
        if (Configuration.slabToBlockStoneCrafting) {
            GameRegistry.addRecipe(new ItemStack(getItem("stone"), 1), "S", "S", 'S', new ItemStack(getItem("stone_slab"), 1, 0));
        }
        if (Configuration.slabToBlockNetherBrickCrafting) {
            GameRegistry.addRecipe(new ItemStack(getItem("nether_brick"), 1), "S", "S", 'S', new ItemStack(getItem("stone_slab"), 1, 6));
        }
        if (Configuration.slabToBlockOakWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(getItem("planks"), 1, 0), "S", "S", 'S', new ItemStack(getItem("wooden_slab"), 1, 0));
        }
        if (Configuration.slabToBlockSpruceWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(getItem("planks"), 1, 1), "S", "S", 'S', new ItemStack(getItem("wooden_slab"), 1, 1));
        }
        if (Configuration.slabToBlockBirchWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(getItem("planks"), 1, 2), "S", "S", 'S', new ItemStack(getItem("wooden_slab"), 1, 2));
        }
        if (Configuration.slabToBlockJungleWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(getItem("planks"), 1, 3), "S", "S", 'S', new ItemStack(getItem("wooden_slab"), 1, 3));
        }
        if (Configuration.slabToBlockAcaciaWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(getItem("planks"), 1, 4), "S", "S", 'S', new ItemStack(getItem("wooden_slab"), 1, 4));
        }
        if (Configuration.slabToBlockDarkOakWoodCrafting) {
            GameRegistry.addRecipe(new ItemStack(getItem("planks"), 1, 5), "S", "S", 'S', new ItemStack(getItem("wooden_slab"), 1, 5));
        }
        if (Configuration.brickUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("brick"), 4), getItem("brick"));
        }
        if (Configuration.chiseledSandstoneUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("stone_slab"), 2, 1), new ItemStack(getItem("sandstone"), 1, 1));
        }
        if (Configuration.clayUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("clay_ball"), 4), getItem("clay"));
        }
        if (Configuration.grassUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("dirt"), 1), getItem("grass"));
        }
        if (Configuration.myceliumUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("dirt"), 1), getItem("mycelium"));
        }
        if (Configuration.wheatUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("wheat_seeds"), 1), getItem("wheat"));
        }
        if (Configuration.stairsStoneUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("cobblestone"), 3), getItem("stone_stairs"), getItem("stone_stairs"));
        }
        if (Configuration.stairsBricksUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("brick_block"), 3), getItem("brick_stairs"), getItem("brick_stairs"));
        }
        if (Configuration.stairsStoneBricksUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("stonebrick"), 3, 0), getItem("stone_brick_stairs"), getItem("stone_brick_stairs"));
        }
        if (Configuration.stairsSandstoneUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("sandstone"), 3, 0), getItem("sandstone_stairs"), getItem("sandstone_stairs"));
        }
        if (Configuration.stairsNetherBrickUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("nether_brick"), 3), getItem("nether_brick_stairs"), getItem("nether_brick_stairs"));
        }
        if (Configuration.stairsOakWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("planks"), 3, 0), getItem("oak_stairs"), getItem("oak_stairs"));
        }
        if (Configuration.stairsSpruceWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("planks"), 3, 1), getItem("spruce_stairs"), getItem("spruce_stairs"));
        }
        if (Configuration.stairsBirchWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("planks"), 3, 2), getItem("birch_stairs"), getItem("birch_stairs"));
        }
        if (Configuration.stairsJungleWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("planks"), 3, 3), getItem("jungle_stairs"), getItem("jungle_stairs"));
        }
        if (Configuration.stairsAcaciaWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("planks"), 3, 4), getItem("acacia_stairs"), getItem("acacia_stairs"));
        }
        if (Configuration.stairsDarkOakWoodUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("planks"), 3, 5), getItem("dark_oak_stairs"), getItem("dark_oak_stairs"));
        }
        if (Configuration.stairsQuartzUncrafting) {
            GameRegistry.addShapelessRecipe(new ItemStack(getItem("quartz_block"), 3, 0), getItem("quartz_stairs"),
                    getItem("quartz_stairs"));
        }
    }

    private void registerSmeltingRecipes() {
        if (Configuration.ironPickaxeSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("iron_pickaxe"), 0), new ItemStack(getItem("iron_ingot"), 2), 0.1F);
        }
        if (Configuration.ironAxeSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("iron_axe"), 0), new ItemStack(getItem("iron_ingot"), 2), 0.1F);
        }
        if (Configuration.ironHoeSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("iron_hoe"), 0), new ItemStack(getItem("iron_ingot"), 1), 0.1F);
        }
        if (Configuration.ironSwordSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("iron_sword"), 0), new ItemStack(getItem("iron_ingot"), 1), 0.1F);
        }
        if (Configuration.ironHelmetSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("iron_helmet"), 0), new ItemStack(getItem("iron_ingot"), 4), 0.1F);
        }
        if (Configuration.ironChestplateSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("iron_chestplate"), 0), new ItemStack(getItem("iron_ingot"), 7), 0.1F);
        }
        if (Configuration.ironLeggingsSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("iron_leggings"), 0), new ItemStack(getItem("iron_ingot"), 6), 0.1F);
        }
        if (Configuration.ironBootsSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("iron_boots"), 0), new ItemStack(getItem("iron_ingot"), 3), 0.1F);
        }
        if (Configuration.goldPickaxeSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("golden_pickaxe"), 0), new ItemStack(getItem("gold_ingot"), 2), 0.1F);
        }
        if (Configuration.goldAxeSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("golden_axe"), 0), new ItemStack(getItem("gold_ingot"), 2), 0.1F);
        }
        if (Configuration.goldHoeSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("golden_hoe"), 0), new ItemStack(getItem("gold_ingot"), 1), 0.1F);
        }
        if (Configuration.goldSwordSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("golden_sword"), 0), new ItemStack(getItem("gold_ingot"), 1), 0.1F);
        }
        if (Configuration.goldHelmetSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("golden_helmet"), 0), new ItemStack(getItem("gold_ingot"), 4), 0.1F);
        }
        if (Configuration.goldChestplateSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("golden_chestplate"), 0), new ItemStack(getItem("gold_ingot"), 7), 0.1F);
        }
        if (Configuration.goldLeggingsSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("golden_leggings"), 0), new ItemStack(getItem("gold_ingot"), 6), 0.1F);
        }
        if (Configuration.goldBootsSmelting) {
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(getItem("golden_boots"), 0), new ItemStack(getItem("gold_ingot"), 3), 0.1F);
        }
    }

    private void registerIC2Recipes() {
        if (ModCompat.IC2Loaded) {
            IC2Compat IC2CompatHandler = IC2Compat.getInstance();

            if (Configuration.bronzePickaxeSmelting && !ModCompat.GTLoaded) {
                FurnaceRecipes.smelting().func_151394_a(new ItemStack(IC2Compat.getIC2Item("bronzePickaxe").getItem(), 0),
                        new ItemStack(IC2CompatHandler.getIC2Item("bronzeIngot").getItem(), 2), 0.1F);
            }
            if (Configuration.bronzeAxeSmelting && !ModCompat.GTLoaded) {
                FurnaceRecipes.smelting().func_151394_a(new ItemStack(IC2CompatHandler.getIC2Item("bronzeAxe").getItem(), 0),
                        new ItemStack(IC2CompatHandler.getIC2Item("bronzeIngot").getItem(), 2), 0.1F);
            }
            if (Configuration.bronzeHoeSmelting && !ModCompat.GTLoaded) {
                FurnaceRecipes.smelting().func_151394_a(new ItemStack(IC2CompatHandler.getIC2Item("bronzeHoe").getItem(), 0),
                        new ItemStack(IC2CompatHandler.getIC2Item("bronzeIngot").getItem(), 2), 0.1F);
            }
            if (Configuration.bronzeSwordSmelting && !ModCompat.GTLoaded) {
                FurnaceRecipes.smelting().func_151394_a(new ItemStack(IC2CompatHandler.getIC2Item("bronzeSword").getItem(), 0),
                        new ItemStack(IC2CompatHandler.getIC2Item("bronzeIngot").getItem(), 1), 0.1F);
            }
            if (Configuration.bronzeHelmetSmelting && !ModCompat.GTLoaded) {
                FurnaceRecipes.smelting().func_151394_a(new ItemStack(IC2CompatHandler.getIC2Item("bronzeHelmet").getItem(), 0),
                        new ItemStack(IC2CompatHandler.getIC2Item("bronzeIngot").getItem(), 4), 0.1F);
            }
            if (Configuration.bronzeChestplateSmelting && !ModCompat.GTLoaded) {
                FurnaceRecipes.smelting().func_151394_a(new ItemStack(IC2CompatHandler.getIC2Item("bronzeChestplate").getItem(), 0),
                        new ItemStack(IC2CompatHandler.getIC2Item("bronzeIngot").getItem(), 7), 0.1F);
            }
            if (Configuration.bronzeLeggingsSmelting && !ModCompat.GTLoaded) {
                FurnaceRecipes.smelting().func_151394_a(new ItemStack(IC2CompatHandler.getIC2Item("bronzeLeggings").getItem(), 0),
                        new ItemStack(IC2CompatHandler.getIC2Item("bronzeIngot").getItem(), 6), 0.1F);
            }
            if (Configuration.bronzeBootsSmelting && !ModCompat.GTLoaded) {
                FurnaceRecipes.smelting().func_151394_a(new ItemStack(IC2CompatHandler.getIC2Item("bronzeBoots").getItem(), 0),
                        new ItemStack(IC2CompatHandler.getIC2Item("bronzeIngot").getItem(), 3), 0.1F);
            }
        }
    }

    private void registerBlockRecipes() {
        if (Configuration.autoCrafter) {
            GameRegistry.addRecipe(new ItemStack(BlockHandler.blockAutoCrafter, 1), "IPI", "PWP", "LRL", 'I', new ItemStack(getItem("iron_ingot")), 'P',
                    new ItemStack(getItem("piston")), 'W', new ItemStack(getItem("crafting_table")), 'L', new ItemStack(getItem("planks")), 'R',
                    new ItemStack(getItem("redstone_block")));
        }
        if (Configuration.craftingStation) {
            /*GameRegistry.addRecipe(new ItemStack(BlockHandler.blockCraftingStation, 1), "IPP", "PWP", "LRL", 'I', new ItemStack(getItem("iron_ingot),
                    'P', new ItemStack(getItem("pistonBase), 'W', new ItemStack(getItem("workbench), 'L', new ItemStack(getItem("planks), 'R',
                    new ItemStack(getItem("blockRedstone)); */
        }
    }

    public void registerOreRecipes(String ItemName, ItemStack item) {
        if (Configuration.coalDustCompression && ModCompat.IC2Loaded && ItemName.equals("dustCoal")) {
            IC2Compat IC2CompatHandler = IC2Compat.getInstance();
            IC2CompatHandler.registerIC2CoalDustRecipe(item);
        }
    }

    public void removeRecipes() {
        if (ModCompat.AM2Loaded) {
            System.out.println("Attempting to fix Recipes overwritten by AM2");
            LocalInventoryCrafting craftingGrid = new LocalInventoryCrafting();
            craftingGrid.setInventorySlotContents(0, new ItemStack(getItem("stonebrick"), 1, 0));
            craftingGrid.setInventorySlotContents(1, new ItemStack(getItem("stonebrick"), 1, 0));
            craftingGrid.setInventorySlotContents(3, new ItemStack(getItem("stonebrick"), 1, 0));
            craftingGrid.setInventorySlotContents(4, new ItemStack(getItem("stonebrick"), 1, 0));
            RemoveRecipeByCraftingGrid(craftingGrid, new ItemStack(getItem("stonebrick"), 1, 3));
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
                if (recipeResult.getItem() == resultItem.getItem() && recipeResult.getItemDamage() == resultItem.getItemDamage() && recipeResult.stackSize == resultItem.stackSize) {
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
                if (tmpRecipe.matches(craftingGrid, null) && recipeResult.getItem() == overriddenOutput.getItem() && recipeResult.getItemDamage() == overriddenOutput.getItemDamage() && recipeResult.stackSize == overriddenOutput.stackSize) {
                    System.out.println("CraftingUtilities Removed Recipe by CraftingGrid: " + recipes.get(scan) + " ===> " + recipeResult);
                    recipes.remove(scan);
                    scan--;
                }

            }

        }
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
}
