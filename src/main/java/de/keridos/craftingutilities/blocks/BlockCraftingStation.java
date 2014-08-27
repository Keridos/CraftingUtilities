package de.keridos.craftingutilities.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.keridos.craftingutilities.CraftingUtilities;
import de.keridos.craftingutilities.lib.Reference;
import de.keridos.craftingutilities.tileentity.TileEntityCraftingStation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 14.11.13
 * Time: 14:08
 * To change this template use File | Settings | File Templates.
 */
public class BlockCraftingStation extends BlockContainer {

    @SideOnly(Side.CLIENT)
    public static IIcon topIcon;
    @SideOnly(Side.CLIENT)
    public static IIcon sideIcon;
    @SideOnly(Side.CLIENT)
    public static IIcon botIcon;

    public BlockCraftingStation(Material material) {
        super(material);
        setHardness(0.5F);
        setStepSound(Block.soundTypeWood);
        setBlockName("craftingutilities:blockCraftingStation");
        setCreativeTab(CreativeTabs.tabBlock);
        setHarvestLevel("axe", 0);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityCraftingStation();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        topIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "craftingstation_top");
        sideIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "craftingstation_side");
        botIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "craftingstation_bot");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
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
            player.openGui(CraftingUtilities.instance, 1, world, x, y, z);
        }
        return true;
    }
}
