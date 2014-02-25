package de.keridos.craftingutilities.blocks;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.keridos.craftingutilities.CraftingUtilities;
import de.keridos.craftingutilities.lib.Reference;
import de.keridos.craftingutilities.tileentity.TileEntityAutoCrafter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;


/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 12.11.13
 * Time: 17:06
 * To change this template use File | Settings | File Templates.
 */
public class BlockAutoCrafter extends BlockContainer {
    private boolean powered = false;
    private boolean was_powered = false;

    public BlockAutoCrafter(int id, Material material) {
        super(id, material);
        setHardness(0.5F);
        setStepSound(Block.soundWoodFootstep);
        setUnlocalizedName("blockAutoCrafter");
        setCreativeTab(CreativeTabs.tabBlock);
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
        if (!par1World.isRemote) {
            if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
                TileEntityAutoCrafter tile = (TileEntityAutoCrafter) par1World.getBlockTileEntity(par2, par3, par4);
                tile.craftRun();
                this.was_powered = true;
            } else if (!par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
                this.was_powered = false;
            }
        }
    }

    public boolean canConnectRedstone(IBlockAccess iba, int i, int j, int k, int dir) {
        return true;
    }


    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityAutoCrafter();
    }


    @SideOnly(Side.CLIENT)
    public static Icon topIcon;
    @SideOnly(Side.CLIENT)
    public static Icon sideIcon;
    @SideOnly(Side.CLIENT)
    public static Icon botIcon;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister icon) {
        topIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "autocrafter_top");
        sideIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "autocrafter_side");
        botIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "autocrafter_bot");
    }

    @Override
    public Icon getIcon(int side, int meta) {
        if (side == 0) {
            return botIcon;
        } else if (side == 1) {
            return topIcon;
        } else {
            return sideIcon;
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            FMLNetworkHandler.openGui(player, CraftingUtilities.instance, 0, world, x, y, z);
        }
        return true;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
        dropItems(world, x, y, z);
        super.breakBlock(world, x, y, z, par5, par6);
    }

    private void dropItems(World world, int x, int y, int z) {
        Random rand = new Random();

        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (!(tileEntity instanceof IInventory)) {
            return;
        }
        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack item = inventory.getStackInSlot(i);

            if (item != null && item.stackSize > 0) {
                float rx = rand.nextFloat() * 0.8F + 0.1F;
                float ry = rand.nextFloat() * 0.8F + 0.1F;
                float rz = rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz,
                        new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

                if (item.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                item.stackSize = 0;
            }
        }
    }
}
