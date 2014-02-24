package de.keridos.utilityrecipes.core;

import de.keridos.utilityrecipes.data.Recipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.OreDictionary;

public class EventListener {

    public static void setupEventListener() {
        MinecraftForge.EVENT_BUS.register(new EventListener());
    }

    @ForgeSubscribe
    public void handleEvent(OreDictionary.OreRegisterEvent event) {
        Recipes.registerOreRecipes(event.Name, event.Ore);
    }
}
