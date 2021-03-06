package de.keridos.craftingutilities.client.gui.container;

import de.keridos.craftingutilities.client.gui.slots.SlotCraftingGridPhantom;
import de.keridos.craftingutilities.client.gui.slots.SlotOutput;
import de.keridos.craftingutilities.tileentity.TileEntityCraftingStation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 12.11.13
 * Time: 20:10
 * To change this template use File | Settings | File Templates.
 */
public class ContainerCraftingStation extends Container {
    private TileEntityCraftingStation craftingStation;

    public ContainerCraftingStation(InventoryPlayer invPlayer, TileEntityCraftingStation entity) {
        this.craftingStation = entity;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                this.addSlotToContainer(new Slot(invPlayer, 9 + x + y * 9, 8 + x * 18, 131 + y * 18));
            }
        }
        for (int x = 0; x < 9; x++) {
            this.addSlotToContainer(new Slot(invPlayer, x, 8 + x * 18, 189));
        }
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 9; x++) {
                this.addSlotToContainer(new Slot(entity, x + y * 9, 8 + x * 18, 82 + y * 18));
            }
        }
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                this.addSlotToContainer(new SlotCraftingGridPhantom(entity, 18 + x + y * 3, 30 + x * 18, 17 + y * 18));
            }
        }
        this.addSlotToContainer(new SlotOutput(entity, 27, 124, 35));
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int i) {
        Slot slot = getSlot(i);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack = slot.getStack();
            ItemStack result = itemstack.copy();

            if (i >= 36) {
                if (!mergeItemStack(itemstack, 0, 36, false)) {
                    return null;
                }
            } else if (!mergeItemStack(itemstack, 36, 36 + 18, false)) {
                return null;
            }

            if (itemstack.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            slot.onPickupFromSlot(player, itemstack);
            return result;
        }
        return null;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return craftingStation.isUseableByPlayer(player);  //To change body of implemented methods use File | Settings | File Templates.
    }


}
