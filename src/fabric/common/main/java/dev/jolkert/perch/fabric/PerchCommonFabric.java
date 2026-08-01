package dev.jolkert.perch.fabric;

import net.minecraft.world.InteractionResult;

public class PerchCommonFabric
{
	public static InteractionResult DROP_SUCCESS;
	public static void init(InteractionResult success)
	{
		PerchCommonFabric.DROP_SUCCESS = success;
	}
}
