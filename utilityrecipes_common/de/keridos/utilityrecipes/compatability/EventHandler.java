package de.keridos.utilityrecipes.compatability;

import de.keridos.utilityrecipes.data.Recipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.OreDictionary;

public class EventHandler {

    public static void setupEventListener() {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    @ForgeSubscribe
    public void handleEvent(OreDictionary.OreRegisterEvent event) {
        Recipes.registerOreRecipes(event.Name, event.Ore);
    }
}
