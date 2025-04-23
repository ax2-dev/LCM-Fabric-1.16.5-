package penip.strokinmypenip;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import penip.strokinmypenip.events.*;

public class PenipLuckyBlocks implements ModInitializer {
	public static final String MOD_ID = "strokin-my-penip";

	public static final Block LUCKY_BLOCK = new Block(
			FabricBlockSettings.of(Material.METAL)
					.requiresTool()
					.breakByTool(FabricToolTags.PICKAXES, 2)
					.dropsNothing()
					.strength(1.0f)
	);

	public static final Item LUCKY_BLOCK_ITEM = new BlockItem(
			LUCKY_BLOCK,
			new Item.Settings().group(ItemGroup.MISC)
	);

	@Override
	public void onInitialize() {
		LuckyBlockEventManager.register(new ChangeToSandEffect());
		LuckyBlockEventManager.register(new LaunchExperienceBottlesEffect());
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "lucky_block"), LUCKY_BLOCK);
		Registry.register(Registry.ITEM,  new Identifier(MOD_ID, "lucky_block"), LUCKY_BLOCK_ITEM);

		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, be) -> {
			if (!world.isClient() && state.getBlock() == LUCKY_BLOCK) {
				LuckyBlockEventManager.triggerRandom(world, pos);
			}
		});
	}
}
