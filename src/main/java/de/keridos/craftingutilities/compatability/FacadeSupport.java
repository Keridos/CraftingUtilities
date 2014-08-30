package de.keridos.craftingutilities.compatability;


import cpw.mods.fml.common.event.FMLInterModComms;
import de.keridos.craftingutilities.data.Config;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * Created by Nico on 26.02.14.
 */
public class FacadeSupport {
    private static FacadeSupport instance = null;
    private static Config Configuration = Config.getInstance();

    private FacadeSupport() {
    }

    public static FacadeSupport getInstance() {
        if (instance == null) {
            instance = new FacadeSupport();
        }
        return instance;
    }

    private Block getBlock(String name) {
        return (Block) Block.blockRegistry.getObject(name);
    }

    private void registerFacade(Block block, int c) {
        FMLInterModComms.sendMessage("BuildCraft|Transport", "add-facade", new ItemStack(block, 1, c));
    }

    public void registerModFacades() {
        registerGTFacades();
    }

    private void registerGTFacades() {
        if (ModCompatability.GTLoaded && Configuration.addGTMicroblocks) {
            for (int i = 0; i < 16; i++) {
                registerFacade(getBlock("gregtech:gt.blocks.blockcasings"), i);
            }
            for (int i = 0; i < 16; i++) {
                registerFacade(getBlock("gregtech:gt.blocks.blockcasings2"), i);
            }
            for (int i = 0; i < 16; i++) {
                registerFacade(getBlock("gregtech:gt.blocks.blockcasings3"), i);
            }
            for (int i = 0; i < 16; i++) {
                //registerFacade(getBlock("gregtech:gt.blocks.blockcasings4"), i);      not finished yet in GT
            }
            for (int i = 0; i < 16; i++) {
                registerFacade(getBlock("gregtech:gt.blocks.blockgranites"), i);
            }
            for (int i = 0; i < 16; i++) {
                registerFacade(getBlock("gregtech:gt.blocks.blockconcretes"), i);
            }
        }
    }
}
