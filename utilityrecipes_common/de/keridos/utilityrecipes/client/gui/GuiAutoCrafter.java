package de.keridos.utilityrecipes.client.gui;

import de.keridos.utilityrecipes.client.container.ContainerAutoCrafter;
import de.keridos.utilityrecipes.lib.Reference;
import de.keridos.utilityrecipes.tileentity.TileEntityAutoCrafter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created with IntelliJ IDEA.
 * User: Nico
 * Date: 12.11.13
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public class GuiAutoCrafter extends GuiContainer {
    public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/gui/autocrafter.png");

    public GuiAutoCrafter(InventoryPlayer invPlayer, TileEntityAutoCrafter entity) {
        super(new ContainerAutoCrafter(invPlayer, entity));
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
