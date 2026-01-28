package io.github.suel_ki.beautify.core.init;

import io.github.suel_ki.beautify.Beautify;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;
import java.util.function.Supplier;


public class ModVillagers {

    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, Beautify.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, Beautify.MODID);

    public static final Supplier<PoiType> BOTANIST_WORKBENCH_POI = POI_TYPES.register("botanist_workbench_poi",
            () -> new PoiType(
                    ImmutableSet.copyOf(BlockInit.BOTANIST_WORKBENCH.get().getStateDefinition().getPossibleStates()), 1,
                    1));

    public static final ResourceKey<VillagerProfession> BOTANIST = register("botanist",
            holder -> holder.value().equals(BOTANIST_WORKBENCH_POI.get()), holder -> holder.value().equals(BOTANIST_WORKBENCH_POI.get()), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.CAVE_VINES_PLACE);

    private static ResourceKey<VillagerProfession> register
            (
                    String name, Predicate<Holder<PoiType>> heldWorkstation,
                    Predicate<Holder<PoiType>> acquirableWorkstation,
                    ImmutableSet<Item> gatherableItems,
                    ImmutableSet<Block> secondaryJobSites,
                    @Nullable SoundEvent workSound) {

        ResourceKey<VillagerProfession> key = ResourceKey.create(Registries.VILLAGER_PROFESSION, Beautify.id(name));

        VILLAGER_PROFESSIONS.register(name, () -> new VillagerProfession(
                Component.translatable("entity." + key.identifier().getNamespace() + ".villager." + key.identifier().getPath()),
                heldWorkstation, acquirableWorkstation, gatherableItems, secondaryJobSites, workSound)
        );
        return key;
    }
}
