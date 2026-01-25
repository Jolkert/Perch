package dev.jolkert.perch;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class Perch
{
	public static boolean hasShoulderEntity(Player player)
	{
		return !(player.getShoulderEntityLeft().isEmpty() && player.getShoulderEntityRight().isEmpty());
	}

	public static boolean shouldDrop(InteractionResult result, Player player, ItemStack stack)
	{
		return player != null && !result.consumesAction() && hasShoulderEntity(player) && player.isCrouching() && stack.isEmpty();
	}
}
