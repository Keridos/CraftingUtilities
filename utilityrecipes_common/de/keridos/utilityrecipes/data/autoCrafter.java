package de.keridos.utilityrecipes.data;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.keridos.utilityrecipes.lib.Reference;
import de.keridos.utilityrecipes.tileentity.tileEntityAutoCrafter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
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
    private ItemStack[] inventory;
    private ItemStack output;

    public autoCrafter(int id, Material material) {
        super(id, material);
        setHardness(0.5F);
        setStepSound(Block.soundWoodFootstep);
        setUnlocalizedName("blockAutoCrafter");
        setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new tileEntityAutoCrafter();
    }


    @SideOnly(Side.CLIENT)
    public static Icon topIcon;
    @SideOnly(Side.CLIENT)
    public static Icon sideIcon;
    @SideOnly(Side.CLIENT)
    public static Icon frontIcon;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister icon) {
        topIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "autocrafter_top");

        sideIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "autocrafter_side");
        frontIcon = icon.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "autocrafter_front");
    }

    @Override
    public Icon getIcon(int side, int meta) {
        if (side == 0 || side == 1) {
            return topIcon;
        } else if (side == 2) {
            return frontIcon;
        } else {
            return sideIcon;
        }
    }
}
