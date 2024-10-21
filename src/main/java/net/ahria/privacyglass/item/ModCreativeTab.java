package net.ahria.privacyglass.item;

import net.ahria.privacyglass.PrivacyGlass;
import net.ahria.privacyglass.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CreativeTabs =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PrivacyGlass.ModId);

    public static final RegistryObject<CreativeModeTab> PrivacyGlassTab = CreativeTabs.register("privacy_glass_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PurpleTint.get())).title(Component.translatable("creativetab.privacy_glass_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.PurpleTintedGlass.get());
                    })
                    .build() );

    public static void register(IEventBus eventBus){
        CreativeTabs.register(eventBus);
    }
}
