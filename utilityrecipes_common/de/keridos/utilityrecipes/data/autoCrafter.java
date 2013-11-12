package de.keridos.utilityrecipes.data;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.keridos.utilityrecipes.lib.Reference;
import de.keridos.utilityrecipes.tileentity.TileEntityAutoCrafter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
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
public class autoCrafter extends BlockContainer {


    public autoCrafter(int id, Material material) {
        super(id, material);
        setHardness(0.5F);
        setStepSound(Block.soundWoodFootstep);
        setUnlocalizedName("blockAutoCrafter");
        setCreativeTab(CreativeTabs.tabBlock);
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
}
