package de.keridos.utilityrecipes.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 12.11.13
 * Time: 17:52
 * To change this template use File | Settings | File Templates.
 */
public class tileEntityAutoCrafter extends TileEntity implements IInventory, ISidedInventory {


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

    @Override
    public int getSizeInventory() {
// TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
// TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
// TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
// TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
// TODO Auto-generated method stub

    }

    @Override
    public String getInvName() {
// TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isInvNameLocalized() {
// TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
// TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
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
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
