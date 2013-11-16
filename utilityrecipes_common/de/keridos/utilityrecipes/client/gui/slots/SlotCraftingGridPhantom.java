package de.keridos.utilityrecipes.client.gui.slots;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 12.11.13
 * Time: 23:38
 * To change this template use File | Settings | File Templates.
 */

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotCraftingGridPhantom extends Slot implements IPhantomSlot {

    public SlotCraftingGridPhantom(IInventory iinventory, int slotIndex, int posX, int posY) {
        super(iinventory, slotIndex, posX, posY);
    }

    @Override
    public boolean canAdjust() {
        return true;
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }

    @Override
    public boolean canTakeStack(EntityPlayer par1EntityPlayer) {
        return true;
    }
}