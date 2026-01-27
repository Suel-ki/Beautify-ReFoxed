package io.github.suel_ki.beautify.core.init;

import io.github.suel_ki.beautify.Beautify;
import io.github.suel_ki.beautify.common.block.HangingPot;
import io.github.suel_ki.beautify.common.block.Trellis;
import io.github.suel_ki.beautify.common.tooltip.PlantableItemStackTooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Supplier;

public final class ItemInit {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Beautify.MODID);

	// trellis
	public static final DeferredItem<BlockItem> OAK_TRELLIS_ITEM = registerTrellis(BlockInit.OAK_TRELLIS, 300);

	public static final DeferredItem<BlockItem> SPRUCE_TRELLIS_ITEM = registerTrellis(BlockInit.SPRUCE_TRELLIS, 300);

	public static final DeferredItem<BlockItem> BIRCH_TRELLIS_ITEM = registerTrellis(BlockInit.BIRCH_TRELLIS, 300);

	public static final DeferredItem<BlockItem> JUNGLE_TRELLIS_ITEM = registerTrellis(BlockInit.JUNGLE_TRELLIS, 300);

	public static final DeferredItem<BlockItem> ACACIA_TRELLIS_ITEM = registerTrellis(BlockInit.ACACIA_TRELLIS, 300);

	public static final DeferredItem<BlockItem> DARK_OAK_TRELLIS_ITEM = registerTrellis( BlockInit.DARK_OAK_TRELLIS, 300);

	public static final DeferredItem<BlockItem> MANGROVE_TRELLIS_ITEM = registerTrellis(BlockInit.MANGROVE_TRELLIS, 300);

	public static final DeferredItem<BlockItem> CRIMSON_TRELLIS_ITEM = registerTrellis(BlockInit.CRIMSON_TRELLIS, 300);

	public static final DeferredItem<BlockItem> CHERRY_TRELLIS_ITEM = registerTrellis(BlockInit.CHERRY_TRELLIS, 300);

	public static final DeferredItem<BlockItem> WARPED_TRELLIS_ITEM = registerTrellis(BlockInit.WARPED_TRELLIS, 300);

	// blinds
	public static final DeferredItem<BlockItem> OAK_BLINDS_ITEM = registerBurnBlockItem(BlockInit.OAK_BLINDS, 300);

	public static final DeferredItem<BlockItem> SPRUCE_BLINDS_ITEM = registerBurnBlockItem(BlockInit.SPRUCE_BLINDS, 300);

	public static final DeferredItem<BlockItem> BIRCH_BLINDS_ITEM = registerBurnBlockItem(BlockInit.BIRCH_BLINDS, 300);

	public static final DeferredItem<BlockItem> JUNGLE_BLINDS_ITEM = registerBurnBlockItem(BlockInit.JUNGLE_BLINDS, 300);

	public static final DeferredItem<BlockItem> ACACIA_BLINDS_ITEM = registerBurnBlockItem(BlockInit.ACACIA_BLINDS, 300);

	public static final DeferredItem<BlockItem> DARK_OAK_BLINDS_ITEM = registerBurnBlockItem(BlockInit.DARK_OAK_BLINDS, 300);

	public static final DeferredItem<BlockItem> CRIMSON_BLINDS_ITEM = registerBurnBlockItem(BlockInit.CRIMSON_BLINDS, 300);

	public static final DeferredItem<BlockItem> CHERRY_BLINDS_ITEM = registerBurnBlockItem(BlockInit.CHERRY_BLINDS, 300);

	public static final DeferredItem<BlockItem> WARPED_BLINDS_ITEM = registerBurnBlockItem(BlockInit.WARPED_BLINDS, 300);

	public static final DeferredItem<BlockItem> MANGROVE_BLINDS_ITEM = registerBurnBlockItem(BlockInit.MANGROVE_BLINDS, 300);

	public static final DeferredItem<BlockItem> IRON_BLINDS_ITEM = registerBlockItem(BlockInit.IRON_BLINDS);

	// picture frame
	public static final DeferredItem<BlockItem> OAK_PICTURE_FRAME_ITEM = registerBurnBlockItem( BlockInit.OAK_PICTURE_FRAME, 300);

	public static final DeferredItem<BlockItem> SPRUCE_PICTURE_FRAME_ITEM = registerBurnBlockItem(BlockInit.SPRUCE_PICTURE_FRAME, 300);

	public static final DeferredItem<BlockItem> BIRCH_PICTURE_FRAME_ITEM = registerBurnBlockItem(BlockInit.BIRCH_PICTURE_FRAME, 300);

	public static final DeferredItem<BlockItem> JUNGLE_PICTURE_FRAME_ITEM = registerBurnBlockItem( BlockInit.JUNGLE_PICTURE_FRAME, 300);

	public static final DeferredItem<BlockItem> ACACIA_PICTURE_FRAME_ITEM = registerBurnBlockItem(BlockInit.ACACIA_PICTURE_FRAME, 300);

	public static final DeferredItem<BlockItem> DARK_OAK_PICTURE_FRAME_ITEM = registerBurnBlockItem(BlockInit.DARK_OAK_PICTURE_FRAME, 300);

	public static final DeferredItem<BlockItem> CRIMSON_PICTURE_FRAME_ITEM = registerBurnBlockItem(BlockInit.CRIMSON_PICTURE_FRAME, 300);

	public static final DeferredItem<BlockItem> CHERRY_PICTURE_FRAME_ITEM = registerBurnBlockItem(BlockInit.CHERRY_PICTURE_FRAME, 300);

	public static final DeferredItem<BlockItem> WARPED_PICTURE_FRAME_ITEM = registerBurnBlockItem(BlockInit.WARPED_PICTURE_FRAME, 300);

	public static final DeferredItem<BlockItem> MANGROVE_PICTURE_FRAME_ITEM = registerBurnBlockItem(BlockInit.MANGROVE_PICTURE_FRAME, 300);

	public static final DeferredItem<BlockItem> QUARTZ_PICTURE_FRAME_ITEM = registerBurnBlockItem(BlockInit.QUARTZ_PICTURE_FRAME, 300);

	public static final DeferredItem<BlockItem> ROPE_ITEM = registerBurnBlockItem(BlockInit.ROPE, 100);

	public static final DeferredItem<BlockItem> HANGING_POT_ITEM = registerBlockItem(BlockInit.HANGING_POT,
            () -> new BlockItem(BlockInit.HANGING_POT.get(),
					new Item.Properties()) {
				@Override
				public Optional<TooltipComponent> getTooltipImage(@NotNull ItemStack stack) {
					if (Screen.hasControlDown()) {

						List<ItemStack> plants = HangingPot.VALID_FLOWERS
								.stream()
								.filter(item -> item != Items.AIR)
								.map(ItemStack::new)
								.toList();
						return Optional.of(new PlantableItemStackTooltip(plants));
					} else {
						return super.getTooltipImage(stack);
					}
				}

			});

	public static final DeferredItem<BlockItem> BOOKSTACK_ITEM = registerBlockItem(BlockInit.BOOKSTACK);

	public static final DeferredItem<BlockItem> LAMP_LIGHT_BULB_ITEM = registerBlockItem(BlockInit.LAMP_LIGHT_BULB);

	public static final DeferredItem<BlockItem> LAMP_BAMBOO_ITEM = registerBlockItem(BlockInit.LAMP_BAMBOO);

	public static final DeferredItem<BlockItem> LAMP_JAR_ITEM = registerBlockItem( BlockInit.LAMP_JAR);

	// candelabras
	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_LIGHT_BLUE_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_LIGHT_BLUE);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_LIGHT_GRAY_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_LIGHT_GRAY);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_BLACK_ITEM =registerBlockItem(BlockInit.LAMP_CANDELABRA_BLACK);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_BLUE_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_BLUE);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_BROWN_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_BROWN);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_CYAN_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_CYAN);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_GRAY_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_GRAY);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_GREEN_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_GREEN);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_LIME_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_LIME);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_MAGENTA_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_MAGENTA);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_ORANGE_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_ORANGE);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_PINK_ITEM = registerBlockItem( BlockInit.LAMP_CANDELABRA_PINK);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_PURPLE_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_PURPLE);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_RED_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_RED);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_WHITE_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_WHITE);

	public static final DeferredItem<BlockItem> LAMP_CANDELABRA_YELLOW_ITEM = registerBlockItem(BlockInit.LAMP_CANDELABRA_YELLOW);

	// workbench
	public static final DeferredItem<BlockItem> BOTANIST_WORKBENCH_ITEM = registerBlockItem(BlockInit.BOTANIST_WORKBENCH);

    private static DeferredItem<BlockItem> registerBlockItem(Holder<Block> holder, Supplier<BlockItem> item) {
        return ITEMS.register(key(holder), item);
    }

	private static DeferredItem<BlockItem> registerBlockItem(Holder<Block> block) {
		return ITEMS.registerSimpleBlockItem(block);
	}

    private static DeferredItem<BlockItem> registerBurnBlockItem(Holder<Block> holder, int burnTime) {
        return ITEMS.register(key(holder),
                () -> new BlockItem(holder.value(), new Item.Properties()) {
                    @Override
                    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                        return burnTime;
                    }
                });
    }
    
	private static DeferredItem<BlockItem> registerTrellis(Holder<Block> holder, int burnTime) {
		return ITEMS.register(key(holder),
                () -> new BlockItem(holder.value(), new Item.Properties()) {
			@Override
			public Optional<TooltipComponent> getTooltipImage(@NotNull ItemStack stack) {
				if (Screen.hasControlDown()) {

					List<ItemStack> plants = Trellis.VALID_FLOWERS
							.stream()
							.filter(item -> item != Items.AIR)
							.map(ItemStack::new)
							.toList();
					return Optional.of(new PlantableItemStackTooltip(plants));
				} else {
					return super.getTooltipImage(stack);
				}
			}

            @Override
            public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                return burnTime;
            }

		});
	}

    private static String key(Holder<Block> holder) {
        return holder.unwrapKey().map(ResourceKey::location).map(ResourceLocation::getPath).orElseThrow();
    }
}
