package de.keridos.utilityrecipes.blocks;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.keridos.utilityrecipes.UtilityRecipes;
import de.keridos.utilityrecipes.lib.Reference;
import de.keridos.utilityrecipes.tileentity.TileEntityCraftingStation;
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
 * Date: 14.11.13
 * Time: 14:08
 * To change this template use File | Settings | File Templates.
 */
public class BlockCraftingStation extends BlockContainer {

    public BlockCraftingStation(int id, Material material) {
        super(id, material);
        setHardness(0.5F);
        setStepSound(Block.soundWoodFootstep);
        setUnlocalizedName("blockCraftingStation");
        setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityCraftingStation();
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
        topIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "craftingstation_top");
        sideIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "craftingstation_side");
        botIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "craftingstation_bot");
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
