package io.github.suel_ki.beautify.core.init;

import com.mojang.serialization.Codec;
import io.github.suel_ki.beautify.Beautify;
import io.github.suel_ki.beautify.client.tooltip.TooltipLore;
import io.github.suel_ki.beautify.common.block.*;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ComponentInit {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE = DeferredRegister
            .create(BuiltInRegistries.DATA_COMPONENT_TYPE, Beautify.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TooltipLore>> BLINDS_TOOLTIP = register(
            "blinds_tooltip",
            TooltipLore.CODEC,
            TooltipLore.STREAM_CODEC
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TooltipLore>> BOOKSTACK_TOOLTIP = register(
            "bookstack_tooltip",
            BookStack.TooltipComponent.CODEC,
            BookStack.TooltipComponent.STREAM_CODEC
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TooltipLore>> BOTANIST_WORKBENCH_TOOLTIP = register(
            "botanist_workbench_tooltip",
            BotanistWorkbench.TooltipComponent.CODEC,
            BotanistWorkbench.TooltipComponent.STREAM_CODEC
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TooltipLore>> HANGING_POT_TOOLTIP = register(
            "hanging_pot_tooltip",
            HangingPot.TooltipComponent.CODEC,
            HangingPot.TooltipComponent.STREAM_CODEC
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TooltipLore>> LAMP_BAMBOO_TOOLTIP = register(
            "lamp_bamboo_tooltip",
            LampBamboo.TooltipComponent.CODEC,
            LampBamboo.TooltipComponent.STREAM_CODEC
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TooltipLore>> LAMP_CANDELABRA_TOOLTIP = register(
            "lamp_candelabra_tooltip",
            LampCandelabra.TooltipComponent.CODEC,
            LampCandelabra.TooltipComponent.STREAM_CODEC
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TooltipLore>> LAMP_JAR_TOOLTIP = register(
            "lamp_jar_tooltip",
            LampJar.TooltipComponent.CODEC,
            LampJar.TooltipComponent.STREAM_CODEC
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TooltipLore>> LAMP_LIGHTBULB_TOOLTIP = register(
            "lamp_lightbulb_tooltip",
            LampLightBulb.TooltipComponent.CODEC,
            LampLightBulb.TooltipComponent.STREAM_CODEC
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TooltipLore>> PICTURE_FRAME_TOOLTIP = register(
            "picture_frame_tooltip",
            PictureFrame.TooltipComponent.CODEC,
            PictureFrame.TooltipComponent.STREAM_CODEC
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TooltipLore>> ROPE_TOOLTIP = register(
            "rope_tooltip",
            Rope.TooltipComponent.CODEC,
            Rope.TooltipComponent.STREAM_CODEC
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TooltipLore>> TRELLIS_TOOLTIP = register(
            "trellis_tooltip",
            Trellis.TooltipComponent.CODEC,
            Trellis.TooltipComponent.STREAM_CODEC
    );

    private static <T extends TooltipLore> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(
            String id, Codec<T> codec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec
    ) {
        return DATA_COMPONENT_TYPE.register(
                id,
                () -> DataComponentType.<T>builder()
                        .persistent(codec)
                        .networkSynchronized(streamCodec)
                        .build()
        );
    }
    
}
