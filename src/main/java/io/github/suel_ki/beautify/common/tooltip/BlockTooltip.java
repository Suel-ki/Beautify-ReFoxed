package io.github.suel_ki.beautify.common.tooltip;

import io.github.suel_ki.beautify.client.tooltip.TooltipLore;
import net.minecraft.core.component.DataComponentType;

public interface BlockTooltip<T extends TooltipLore> {
    DataComponentType<T> getTooltipType();
    T getTooltipComponent();
}
