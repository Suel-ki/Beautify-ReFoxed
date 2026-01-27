package io.github.suel_ki.beautify.core.init;

import io.github.suel_ki.beautify.Beautify;
import io.github.suel_ki.beautify.common.block.BookStack;
import io.github.suel_ki.beautify.common.block.BotanistWorkbench;
import io.github.suel_ki.beautify.common.block.HangingPot;
import io.github.suel_ki.beautify.common.block.LampBamboo;
import io.github.suel_ki.beautify.common.block.LampCandelabra;
import io.github.suel_ki.beautify.common.block.LampJar;
import io.github.suel_ki.beautify.common.block.LampLightBulb;
import io.github.suel_ki.beautify.common.block.Blinds;
import io.github.suel_ki.beautify.common.block.PictureFrame;
import io.github.suel_ki.beautify.common.block.Trellis;
import io.github.suel_ki.beautify.common.block.Rope;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class BlockInit {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Beautify.MODID);

    // BLOCKS
    public static final DeferredBlock<BookStack> BOOKSTACK = register("bookstack",
            BookStack::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .strength(0.2F, 0.2F).sound(SoundInit.BOOKSTACK_SOUNDS).noOcclusion());

    public static final DeferredBlock<Rope> ROPE = register("rope",
            Rope::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.NONE)
                    .strength(0.2F, 0.2F).sound(SoundType.WOOL).noOcclusion());

    public static final DeferredBlock<HangingPot> HANGING_POT = register("hanging_pot",
            HangingPot::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN)
                    .noOcclusion().strength(0.1f, 0.1f).sound(SoundType.STONE).lightLevel((state) -> {
                        if (state.getValue(HangingPot.POTFLOWER) == 15) {
                            return 7;
                        } else if (state.getValue(HangingPot.POTFLOWER) == 22) {
                            return 14;
                        } else {
                            return 0;
                        }
                    }));

    // trellis
    public static final DeferredBlock<Trellis> OAK_TRELLIS = registerTrellis("oak_trellis");

    public static final DeferredBlock<Trellis> SPRUCE_TRELLIS = registerTrellis("spruce_trellis");

    public static final DeferredBlock<Trellis> BIRCH_TRELLIS = registerTrellis("birch_trellis");

    public static final DeferredBlock<Trellis> JUNGLE_TRELLIS = registerTrellis("jungle_trellis");

    public static final DeferredBlock<Trellis> ACACIA_TRELLIS = registerTrellis("acacia_trellis");

    public static final DeferredBlock<Trellis> DARK_OAK_TRELLIS = registerTrellis("dark_oak_trellis");

    public static final DeferredBlock<Trellis> MANGROVE_TRELLIS = registerTrellis("mangrove_trellis");

    public static final DeferredBlock<Trellis> CRIMSON_TRELLIS = registerTrellis("crimson_trellis");

    public static final DeferredBlock<Trellis> CHERRY_TRELLIS = registerTrellis("cherry_trellis");

    public static final DeferredBlock<Trellis> WARPED_TRELLIS = registerTrellis("warped_trellis");

    // lamps
    public static final DeferredBlock<LampLightBulb> LAMP_LIGHT_BULB = register("lamp_light_bulb",
            LampLightBulb::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion()
                    .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                        if (state.getValue(LampLightBulb.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    }));

    public static final DeferredBlock<LampBamboo> LAMP_BAMBOO = register("lamp_bamboo",
            LampBamboo::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noOcclusion()
                    .strength(0.1f, 0.1f).sound(SoundType.SCAFFOLDING).lightLevel((state) -> {
                        if (state.getValue(LampBamboo.ON)) {
                            return 14;
                        } else {
                            return 0;
                        }
                    }));

    public static final DeferredBlock<LampJar> LAMP_JAR = register("lamp_jar",
            LampJar::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.NONE).noOcclusion()
                    .strength(0.05f, 0.05f).sound(SoundType.GLASS).lightLevel((state) -> {
                        final int fill = state.getValue(LampJar.FILL_LEVEL);
                        return switch (fill) {
                            case 5 -> 8;
                            case 10 -> 11;
                            case 15 -> 14;
                            default -> 0;
                        };
                    }));

    // candelabras
    public static final DeferredBlock<LampCandelabra> LAMP_CANDELABRA = registerLampCandelabra("lamp_candelabra");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_LIGHT_BLUE = registerLampCandelabra("lamp_candelabra_light_blue");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_LIGHT_GRAY = registerLampCandelabra("lamp_candelabra_light_gray");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_BLACK = registerLampCandelabra("lamp_candelabra_black");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_BLUE = registerLampCandelabra("lamp_candelabra_blue");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_BROWN = registerLampCandelabra("lamp_candelabra_brown");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_CYAN = registerLampCandelabra("lamp_candelabra_cyan");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_GRAY = registerLampCandelabra("lamp_candelabra_gray");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_GREEN = registerLampCandelabra("lamp_candelabra_green");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_LIME = registerLampCandelabra("lamp_candelabra_lime");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_MAGENTA = registerLampCandelabra("lamp_candelabra_magenta");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_ORANGE = registerLampCandelabra("lamp_candelabra_orange");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_PINK = registerLampCandelabra("lamp_candelabra_pink");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_PURPLE = registerLampCandelabra("lamp_candelabra_purple");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_RED = registerLampCandelabra("lamp_candelabra_red");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_WHITE = registerLampCandelabra("lamp_candelabra_white");

    public static DeferredBlock<LampCandelabra> LAMP_CANDELABRA_YELLOW = registerLampCandelabra("lamp_candelabra_yellow");

    // blinds
    public static final DeferredBlock<Blinds> SPRUCE_BLINDS = registerBlinds(
            "spruce_blinds", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<Blinds> DARK_OAK_BLINDS = registerBlinds(
            "dark_oak_blinds", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<Blinds> CRIMSON_BLINDS = registerBlinds(
            "crimson_blinds", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<Blinds> CHERRY_BLINDS = registerBlinds(
            "cherry_blinds", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<Blinds> ACACIA_BLINDS = registerBlinds(
            "acacia_blinds", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<Blinds> JUNGLE_BLINDS = registerBlinds(
            "jungle_blinds", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<Blinds> OAK_BLINDS = registerBlinds(
            "oak_blinds", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<Blinds> BIRCH_BLINDS = registerBlinds(
            "birch_blinds", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<Blinds> WARPED_BLINDS = registerBlinds(
            "warped_blinds", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<Blinds> MANGROVE_BLINDS = registerBlinds(
            "mangrove_blinds", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<Blinds> IRON_BLINDS = registerBlinds(
            "iron_blinds", MapColor.METAL, SoundType.CHAIN);

    // picture frames
    public static final DeferredBlock<PictureFrame> SPRUCE_PICTURE_FRAME = registerPictureFrame(
            "spruce_picture_frame", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<PictureFrame> DARK_OAK_PICTURE_FRAME = registerPictureFrame(
            "dark_oak_picture_frame", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<PictureFrame> CRIMSON_PICTURE_FRAME = registerPictureFrame(
            "crimson_picture_frame", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<PictureFrame> CHERRY_PICTURE_FRAME = registerPictureFrame(
            "cherry_picture_frame", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<PictureFrame> ACACIA_PICTURE_FRAME = registerPictureFrame(
            "acacia_picture_frame", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<PictureFrame> JUNGLE_PICTURE_FRAME = registerPictureFrame(
            "jungle_picture_frame", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<PictureFrame> OAK_PICTURE_FRAME = registerPictureFrame(
            "oak_picture_frame", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<PictureFrame> BIRCH_PICTURE_FRAME = registerPictureFrame(
            "birch_picture_frame", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<PictureFrame> WARPED_PICTURE_FRAME = registerPictureFrame(
            "warped_picture_frame", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<PictureFrame> MANGROVE_PICTURE_FRAME = registerPictureFrame(
            "mangrove_picture_frame", MapColor.WOOD, SoundType.WOOD);

    public static final DeferredBlock<PictureFrame> QUARTZ_PICTURE_FRAME = registerPictureFrame(
            "quartz_picture_frame", MapColor.QUARTZ, SoundType.STONE);

    // workbench
    public static final DeferredBlock<BotanistWorkbench> BOTANIST_WORKBENCH = register("botanist_workbench",
            BotanistWorkbench::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE));

    private static <T extends Block> DeferredBlock<T> register(String name, Function<BlockBehaviour.Properties, ? extends T> func, BlockBehaviour.Properties props) {
        return BLOCKS.registerBlock(name, func, props);
    }

    private static DeferredBlock<LampCandelabra> registerLampCandelabra(String name) {
        return register(name, LampCandelabra::new, BlockBehaviour.Properties.of().mapColor(MapColor.METAL).noOcclusion()
                .strength(0.2f, 0.2f).sound(SoundType.LANTERN).lightLevel((state) -> {
                    if (state.getValue(LampCandelabra.ON)) {
                        return 14;
                    } else {
                        return 0;
                    }
                }));
    }

    private static DeferredBlock<Trellis> registerTrellis(String name) {
        return register(name, Trellis::new, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).mapColor(MapColor.WOOD)
                .strength(0.3F, 0.3F).sound(SoundType.BAMBOO).noOcclusion());
    }

    private static DeferredBlock<PictureFrame> registerPictureFrame(String name, MapColor color, SoundType type) {
        return register(name, PictureFrame::new, BlockBehaviour.Properties.of().mapColor(color).noOcclusion()
                .strength(0.1f, 0.1f).sound(type).noOcclusion().pushReaction(PushReaction.DESTROY));
    }

    private static DeferredBlock<Blinds> registerBlinds(String name, MapColor color, SoundType type) {
        return register(name, Blinds::new, BlockBehaviour.Properties.of().mapColor(color).noOcclusion()
                .strength(0.4f, 0.4f).sound(type));
    }
}
