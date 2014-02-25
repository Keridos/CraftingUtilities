package de.keridos.utilityrecipes.core;

import de.keridos.utilityrecipes.data.Recipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
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

    @ForgeSubscribe
    public void handleEvent(OreDictionary.OreRegisterEvent event) {
        RecipeManager.registerOreRecipes(event.Name, event.Ore);
    }
}
