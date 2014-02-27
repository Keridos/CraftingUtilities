package de.keridos.craftingutilities.client.gui;

import de.keridos.craftingutilities.client.gui.container.ContainerCraftingStation;
import de.keridos.craftingutilities.lib.Reference;
import de.keridos.craftingutilities.tileentity.TileEntityCraftingStation;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 14.11.13
 * Time: 23:51
 * To change this template use File | Settings | File Templates.
 */
public class GuiCraftingStation extends GuiContainer {
    public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/gui/craftingstation.png");

    public GuiCraftingStation(InventoryPlayer invPlayer, TileEntityCraftingStation entity) {
        super(new ContainerCraftingStation(invPlayer, entity));
        xSize = 176;
        ySize = 213;
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float f, int j, int i) {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        mc.renderEngine.bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
