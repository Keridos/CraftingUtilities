package de.keridos.craftingutilities.compatability;

import ic2.api.recipe.RecipeInputItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by Nico on 26.02.14.
 */
public class IC2Compat {
    private static IC2Compat instance = null;
    private static Class Ic2Items;

    private IC2Compat() {
    }

    public static IC2Compat getInstance() {
        if (instance == null) {
            instance = new IC2Compat();
        }
        return instance;
    }

    public void registerIC2CoalDustRecipe(ItemStack item) {

        if (ic2.api.recipe.Recipes.compressor.getOutputFor(item, true) == null) {
            ic2.api.recipe.Recipes.compressor.addRecipe(new RecipeInputItemStack(item, 1), new NBTTagCompound("0"),
                    new ItemStack(Item.coal, 1));
        }
    }

    public static ItemStack getIC2Item(String name) {
        try {
            if (Ic2Items == null) Ic2Items = Class.forName("ic2.core.Ic2Items");

            Object ret = Ic2Items.getField(name).get(null);

            if (ret instanceof ItemStack) {
                return ((ItemStack) ret).copy();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}