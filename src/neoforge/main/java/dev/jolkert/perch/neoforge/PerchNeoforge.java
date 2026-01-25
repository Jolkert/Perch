package dev.jolkert.perch.neoforge;

import dev.jolkert.perch.Perch;
import dev.jolkert.perch.mixin.ShoulderDropInvoker;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.UseItemOnBlockEvent;

@Mod("perch")
@EventBusSubscriber
public class PerchNeoforge
{
	public PerchNeoforge()
	{
	}

	@SubscribeEvent
	static void onItemUse(UseItemOnBlockEvent event)
	{
		Player player = event.getPlayer();
		if (Perch.shouldDrop(event.getCancellationResult().result(), player, event.getItemStack()))
		{
			((ShoulderDropInvoker)player).removeEntitiesOnShoulder();
			event.cancelWithResult(ItemInteractionResult.SUCCESS);
		}
	}
}
