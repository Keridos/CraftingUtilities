package de.keridos.utilityrecipes.client.container;

import de.keridos.utilityrecipes.tileentity.TileEntityAutoCrafter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 12.11.13
 * Time: 20:10
 * To change this template use File | Settings | File Templates.
 */
public class ContainerAutoCrafter extends Container {
    private TileEntityAutoCrafter autoCrafter;

    public ContainerAutoCrafter(InventoryPlayer invPlayer, TileEntityAutoCrafter entity) {
        this.autoCrafter = entity;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return autoCrafter.isUseableByPlayer(player);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
