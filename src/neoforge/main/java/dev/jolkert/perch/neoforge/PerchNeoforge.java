package dev.jolkert.perch.neoforge;

import dev.jolkert.perch.Perch;
import dev.jolkert.perch.PerchCommonLts;
import dev.jolkert.perch.mixin.ShoulderDropInvoker;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.UseItemOnBlockEvent;

@Mod(Perch.MOD_ID)
@EventBusSubscriber
public class PerchNeoforge
{
	public PerchNeoforge()
	{
		PerchCommonLts.init();
	}

	@SubscribeEvent
	static void onItemUse(UseItemOnBlockEvent event)
	{
		Player player = event.getPlayer();
		if (
			player instanceof ServerPlayer serverPlayer
				&& Perch.shouldDrop(event.getCancellationResult().result(), serverPlayer, event.getItemStack())
		)
		{
			((ShoulderDropInvoker) serverPlayer).perch$removeEntitiesOnShoulder();
			event.cancelWithResult(ItemInteractionResult.SUCCESS);
		}
	}
}
