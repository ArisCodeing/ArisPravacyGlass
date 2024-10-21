package net.ahria.privacyglass.item;

import net.ahria.privacyglass.PrivacyGlass;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister <Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PrivacyGlass.ModId);


    public static final RegistryObject<Item> PurpleTint = ITEMS.register("purple_tint",
            () -> new Item(new Item.Properties()));








    public static void  register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}
