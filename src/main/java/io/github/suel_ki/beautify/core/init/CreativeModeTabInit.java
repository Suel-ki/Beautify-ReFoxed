package io.github.suel_ki.beautify.core.init;

import io.github.suel_ki.beautify.Beautify;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeModeTabInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Beautify.MODID);

    // TAB
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BEAUTIFY_TAB = CREATIVE_MODE_TABS.register("beautify", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.beautify.group"))
            .icon(ItemInit.HANGING_POT_ITEM.get()::getDefaultInstance)
            .displayItems((enabledFeatures, entries) -> entries.acceptAll(ItemInit.ITEMS.getEntries().stream().map(ItemStack::new).toList())) // adds items to itemgroup
            .build());

}
