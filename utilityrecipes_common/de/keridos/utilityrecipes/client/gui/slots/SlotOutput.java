package de.keridos.utilityrecipes.client.gui.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 12.11.13
 * Time: 23:56
 * To change this template use File | Settings | File Templates.
 */
public class SlotOutput extends Slot {

    public SlotOutput(IInventory par1IInventory, int par3, int par4, int par5) {
        super(par1IInventory, par3, par4, par5);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return false;
    }
}

