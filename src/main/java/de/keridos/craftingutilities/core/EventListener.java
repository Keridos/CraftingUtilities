package de.keridos.craftingutilities.core;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import de.keridos.craftingutilities.data.Recipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class EventListener {
    private static EventListener instance = null;
    private static Recipes RecipeManager = Recipes.getInstance();

    private EventListener() {
    }

    public static EventListener getInstance() {
        if (instance == null) {
            instance = new EventListener();
        }
        return instance;
    }

    public void setupEventListener() {
        MinecraftForge.EVENT_BUS.register(new EventListener());
    }

    @SubscribeEvent
    public void handleEvent(OreDictionary.OreRegisterEvent event) {
        RecipeManager.registerOreRecipes(event.Name, event.Ore);
    }
}
