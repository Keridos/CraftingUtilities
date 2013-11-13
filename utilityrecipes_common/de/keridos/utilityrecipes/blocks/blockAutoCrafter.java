package de.keridos.utilityrecipes.blocks;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.keridos.utilityrecipes.UtilityRecipes;
import de.keridos.utilityrecipes.lib.Reference;
import de.keridos.utilityrecipes.tileentity.TileEntityAutoCrafter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;


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
            if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4) && !this.was_powered) {
                TileEntityAutoCrafter tile = (TileEntityAutoCrafter) par1World.getBlockTileEntity(par2, par3, par4);
                tile.craftRun();
                this.was_powered = true;
            } else if (!par1World.isBlockIndirectlyGettingPowered(par2, par3, par4) && this.was_powered) {
                this.was_powered = false;
            }
        }
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
            FMLNetworkHandler.openGui(player, UtilityRecipes.instance, 0, world, x, y, z);
        }
        return true;
    }
}
