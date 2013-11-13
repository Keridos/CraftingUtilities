package de.keridos.utilityrecipes.tileentity;

import de.keridos.utilityrecipes.core.SlotPhantom;
import de.keridos.utilityrecipes.data.CraftingHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * Date: 12.11.13
 * Time: 17:52
 * To change this template use File | Settings | File Templates.
 */
public class TileEntityAutoCrafter extends TileEntity implements IInventory, ISidedInventory {
    private static Logger LOGGER = Logger.getLogger("InfoLogging");
    public InventoryCrafting craftMatrix = new LocalInventoryCrafting();
    private ItemStack[] inventory;
    private SlotPhantom craftSlot;

    public TileEntityAutoCrafter() {
        inventory = new ItemStack[28];
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int var1) {
        return new int[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public IRecipe findRecipe() {
        int i;
        for (i = 0; i < 9; i++) {
            ItemStack stack = getStackInSlot(i + 18);
            if (!(stack == null)) {
                craftMatrix.setInventorySlotContents(i, stack);
                continue;
            }
        }
        return CraftingHelper.findMatchingRecipe(craftMatrix, worldObj);
    }

    private boolean checkResources() {
        int i;
        int j;
        int recipe_completion = 0;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 18; j++) {
                if (craftMatrix.getStackInSlot(i) == null) {
                    recipe_completion++;
                    break;
                } else if (craftMatrix.getStackInSlot(i) == getStackInSlot(j) && (!(craftMatrix.getStackInSlot(i) == null))) {
                    recipe_completion++;
                    break;
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
        LOGGER.severe("craftRun");
        IRecipe recipe = findRecipe();
        if (recipe == null) {
            return;
        }
        ItemStack result = recipe.getCraftingResult(craftMatrix);
        if (result == null) {
            return;
        }
        if (!checkResources()) {
            return;

        }
        if (getStackInSlot(27) == null) {
            output_stacksize = 0;
        } else {
            output_stacksize = getStackInSlot(27).stackSize;
        }
        result = result.copy();
        if (output_stacksize + result.stackSize < 64) {
            for (i = 0; i < 9; i++) {
                for (j = 0; j < 18; j++) {
                    if (craftMatrix.getStackInSlot(i) == getStackInSlot(j) && (!(craftMatrix.getStackInSlot(i) == null))) {
                        getStackInSlot(j).stackSize--;
                        break;
                    }
                }
            }
            if (!(output_stacksize == 0)) {
                if (result.getItem() == getStackInSlot(27).getItem()) {
                    setInventorySlotContents(27, new ItemStack(result.getItem(), result.stackSize + output_stacksize));
                }
            } else {
                setInventorySlotContents(27, new ItemStack(result.getItem(), result.stackSize + output_stacksize));
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
        // TODO Auto-generated method stub

    }

    @Override
    public void closeChest() {
        // TODO Auto-generated method stub

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
