package dev.jolkert.perch.fabric;

import dev.jolkert.perch.Perch;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.InteractionResult;

public class PerchFabric implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		Perch.init(player -> !(player.getShoulderEntityLeft().isEmpty() && player.getShoulderEntityRight().isEmpty()));
		PerchCommonFabric.init(InteractionResult.SUCCESS_SERVER);
	}
}
