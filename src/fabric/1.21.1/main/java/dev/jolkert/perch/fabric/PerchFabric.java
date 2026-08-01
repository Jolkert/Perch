package dev.jolkert.perch.fabric;

import dev.jolkert.perch.PerchCommonLts;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.InteractionResult;

public class PerchFabric implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		PerchCommonLts.init();
		PerchCommonFabric.init(InteractionResult.SUCCESS_NO_ITEM_USED);
	}
}
