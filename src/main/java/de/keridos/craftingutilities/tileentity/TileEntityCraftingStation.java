package de.keridos.craftingutilities.tileentity;

import de.keridos.craftingutilities.util.CraftingHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

/**
 * Created with IntelliJ IDEA.
 * Date: 12.11.13
 * Time: 17:52
 * To change this template use File | Settings | File Templates.
 */
public class TileEntityCraftingStation extends TileEntity implements ISidedInventory {
    public InventoryCrafting craftMatrix = new LocalInventoryCrafting();
    private ItemStack[] inventory;

    public TileEntityCraftingStation() {
        inventory = new ItemStack[28];
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int par1) {
        int[] slots = new int[18];
        int i;
        for (i = 0; i < 18; i++) {
            slots[i] = i;
        }
        return slots;
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        if (i <= 18) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return false;
    }

    public IRecipe findRecipe() {
        int i;
        for (i = 0; i < 9; i++) {
            ItemStack stack = getStackInSlot(i + 18);
            craftMatrix.setInventorySlotContents(i, stack);
        }
        return CraftingHelper.findMatchingRecipe(craftMatrix, worldObj);
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return inventory[i];
    }

    @Override
    public ItemStack decrStackSize(int slot, int count) {
        ItemStack itemstack = getStackInSlot(slot);

        if (itemstack != null) {
            if (itemstack.stackSize <= count) {
                setInventorySlotContents(slot, null);
            } else {
                itemstack = itemstack.splitStack(count);
                onInventoryChanged();
            }
        }
        return itemstack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack itemstack = getStackInSlot(slot);
        setInventorySlotContents(slot, null);
        return itemstack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemstack) {
        inventory[slot] = itemstack;

        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
            itemstack.stackSize = getInventoryStackLimit();
        }
        onInventoryChanged();
    }

    @Override
    public String getInvName() {
        return "AutoCrafter";
    }

    @Override
    public boolean isInvNameLocalized() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
    }

    @Override
    public void openChest() {

    }

    @Override
    public void closeChest() {

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        NBTTagList list = new NBTTagList();

        for (int i = 0; i < getSizeInventory(); i++) {
            ItemStack itemstack = getStackInSlot(i);

            if (itemstack != null) {
                NBTTagCompound item = new NBTTagCompound();

                item.setByte("ItemsAutoCrafter", (byte) i);
                itemstack.writeToNBT(item);
                list.appendTag(item);
            }
        }
        compound.setTag("ItemsAutoCrafter", list);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        NBTTagList list = compound.getTagList("ItemsAutoCrafter");

        for (int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound item = (NBTTagCompound) list.tagAt(i);
            int slot = item.getByte("ItemsAutoCrafter");

            if (slot >= 0 && slot < getSizeInventory()) {
                setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
            }
        }
    }

    private class LocalInventoryCrafting extends InventoryCrafting {

        public LocalInventoryCrafting() {
            super(new Container() {
                @Override
                public boolean canInteractWith(EntityPlayer entityplayer) {
                    return false;
                }
            }, 3, 3);
        }
    }
}
