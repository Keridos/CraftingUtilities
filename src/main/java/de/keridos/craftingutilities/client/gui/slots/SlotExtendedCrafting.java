package de.keridos.craftingutilities.client.gui.slots;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 14.11.13
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class SlotExtendedCrafting extends SlotCrafting {
    private final IInventory craftMatrix;
    private final IInventory resources;
    private EntityPlayer thePlayer;

    public SlotExtendedCrafting(EntityPlayer par1EntityPlayer, IInventory par2IInventory, IInventory par3IInventory,
                                IInventory par4IInventory, int par4, int par5, int par6) {
        super(par1EntityPlayer, par2IInventory, par3IInventory, par4, par5, par6);
        this.thePlayer = par1EntityPlayer;
        this.craftMatrix = par2IInventory;
        this.resources = par4IInventory;
    }

    public boolean checkResources() {
        int i;
        int j;
        int recipe_completion = 0;
        for (i = 0; i < craftMatrix.getSizeInventory(); i++) {
            for (j = 0; j < resources.getSizeInventory(); j++) {
                if (craftMatrix.getStackInSlot(i) == null) {
                    recipe_completion++;
                    break;
                } else if (resources.getStackInSlot(j) != null) {
                    if (craftMatrix.getStackInSlot(i).getItem() == resources.getStackInSlot(j).getItem()) {
                        recipe_completion++;
                        break;
                    }
                }
            }
        }
        if (recipe_completion == 9) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack) {
        FMLCommonHandler.instance().firePlayerCraftingEvent(par1EntityPlayer, par2ItemStack, craftMatrix);
        this.onCrafting(par2ItemStack);
        if (!checkResources()) {
            return;
        }
        for (int i = 0; i < this.craftMatrix.getSizeInventory(); ++i) {
            ItemStack itemstack1 = this.craftMatrix.getStackInSlot(i);

            if (itemstack1 != null) {
                for (int j = 0; i < this.resources.getSizeInventory(); i++) {
                    if (resources.getStackInSlot(j) != null) {
                        if ((craftMatrix.getStackInSlot(i).getItem() == resources.getStackInSlot(j).getItem())) {
                            if (resources.getStackInSlot(j).stackSize > 2) {
                                resources.getStackInSlot(j).stackSize--;
                            } else {
                                resources.setInventorySlotContents(j, null);
                            }
                            break;
                        }
                    }

                }
            }
        }
    }
}
