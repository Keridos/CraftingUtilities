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
public class TileEntityAutoCrafter extends TileEntity implements ISidedInventory {
    public InventoryCrafting craftMatrix = new LocalInventoryCrafting();
    private ItemStack[] inventory;
    int timeout = 7;
    long[] timedifference = {0, 0};

    public TileEntityAutoCrafter() {
        inventory = new ItemStack[28];
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int par1) {
        int[] slots = new int[19];
        int i;
        for (i = 0; i < 18; i++) {
            slots[i] = i;
        }
        slots[18] = 27;
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
        if (i == 27) {
            return true;
        }
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

    private boolean checkTimeout() {
        timedifference[1] = timedifference[0];
        timedifference[0] = getWorldObj().getWorldTime();
        if (timedifference[0] - timedifference[1] <= timeout) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkResources() {
        int i;
        int j;
        ItemStack[] CraftResources = new ItemStack[18];
        int recipe_completion = 0;
        for (j = 0; j < 18; j++) {
            if (getStackInSlot(j) != null) {
                CraftResources[j] = getStackInSlot(j).copy();
            }
        }
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 18; j++) {
                if (craftMatrix.getStackInSlot(i) == null) {
                    recipe_completion++;
                    break;
                } else if (CraftResources[j] != null) {
                    if (craftMatrix.getStackInSlot(i).getItem() == CraftResources[j].getItem()) {
                        if (CraftResources[j].stackSize > 1) {
                            CraftResources[j].stackSize--;
                        } else {
                            CraftResources[j] = null;
                        }
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

    public void craftRun() {
        int i;
        int j;
        int output_stacksize = 0;
        IRecipe recipe = findRecipe();
        if (recipe == null || checkTimeout()) {
            return;
        }
        ItemStack result = recipe.getCraftingResult(craftMatrix);
        if (result == null || !checkResources()) {
            return;
        }
        if (getStackInSlot(27) == null) {
            output_stacksize = 0;
        } else {
            output_stacksize = getStackInSlot(27).stackSize;
        }
        result = result.copy();
        if (output_stacksize + result.stackSize <= 64) {
            for (i = 0; i < 9; i++) {
                for (j = 0; j < 18; j++) {
                    if (craftMatrix.getStackInSlot(i) == null) {
                        break;
                    } else if (getStackInSlot(j) != null) {
                        if ((craftMatrix.getStackInSlot(i).getItem() == getStackInSlot(j).getItem())) {
                            if (getStackInSlot(j).stackSize > 1) {
                                getStackInSlot(j).stackSize--;
                            } else {
                                setInventorySlotContents(j, null);
                            }
                            break;
                        }
                    }
                }
            }
            if (!(output_stacksize == 0)) {
                if (result.getItem() == getStackInSlot(27).getItem()) {
                    setInventorySlotContents(27, null);
                    setInventorySlotContents(27,
                            new ItemStack(result.getItem(), result.stackSize + output_stacksize, result.getItemDamage()));
                }
            } else {
                setInventorySlotContents(27, new ItemStack(result.getItem(), result.stackSize, result.getItemDamage()));
            }
            return;
        } else {
            return;
        }
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
