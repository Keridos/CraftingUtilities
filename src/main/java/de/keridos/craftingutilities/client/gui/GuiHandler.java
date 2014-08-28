package de.keridos.craftingutilities.client.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import de.keridos.craftingutilities.CraftingUtilities;
import de.keridos.craftingutilities.client.gui.container.ContainerAutoCrafter;
import de.keridos.craftingutilities.client.gui.container.ContainerCraftingStation;
import de.keridos.craftingutilities.tileentity.TileEntityAutoCrafter;
import de.keridos.craftingutilities.tileentity.TileEntityCraftingStation;
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
    private static GuiHandler instance = null;

    private GuiHandler() {
        NetworkRegistry.INSTANCE.registerGuiHandler(CraftingUtilities.instance, this);
    }

    public static GuiHandler getInstance() {
        if (instance == null) {
            instance = new GuiHandler();
        }
        return instance;
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        switch (id) {
            case 0:
                if (entity != null && entity instanceof TileEntityAutoCrafter) {
                    return new ContainerAutoCrafter(player.inventory, (TileEntityAutoCrafter) entity);
                } else {
                    return null;
                }
            case 1:
                if (entity != null && entity instanceof TileEntityCraftingStation) {
                    return new ContainerCraftingStation(player.inventory, (TileEntityCraftingStation) entity);
                } else {
                    return null;
                }
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

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

