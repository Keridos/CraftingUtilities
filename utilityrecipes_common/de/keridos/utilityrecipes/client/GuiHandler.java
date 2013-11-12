package de.keridos.utilityrecipes.client;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import de.keridos.utilityrecipes.UtilityRecipes;
import de.keridos.utilityrecipes.client.gui.GuiAutoCrafter;
import de.keridos.utilityrecipes.tileentity.TileEntityAutoCrafter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 12.11.13
 * Time: 20:15
 * To change this template use File | Settings | File Templates.
 */
public class GuiHandler implements IGuiHandler {

    public GuiHandler() {
        NetworkRegistry.instance().registerGuiHandler(UtilityRecipes.instance, this);
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getBlockTileEntity(x, y, z);

        switch (id) {
            case 0:
                if (entity != null && entity instanceof TileEntityAutoCrafter) {
                    return new GuiAutoCrafter(player.inventory, (TileEntityAutoCrafter) entity);
                } else {
                    return null;
                }
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getBlockTileEntity(x, y, z);

        switch (id) {
            case 0:
                if (entity != null && entity instanceof TileEntityAutoCrafter) {
                    return new GuiAutoCrafter(player.inventory, (TileEntityAutoCrafter) entity);
                } else {
                    return null;
                }
            default:
                return null;
        }
    }
}

