package dev.jolkert.perch;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.function.Predicate;

public class Perch
{
	public static final String MOD_ID = "perch";
	public static final Logger LOGGER = LoggerFactory.getLogger(Perch.MOD_ID);

	// TODO: *definitely* figure out @Expect/@Actual here
	// its very stupid, but this has to be separated because `getShoulderEntity(Left|Right)` are functions on
	// `Player` in 1.21.1, but they got moved to `ServerPlayer` in 26.2 and java (or at least cloche?) doesn't really
	// appreciate that
	// -morgan 2026-08-01
	private static Predicate<ServerPlayer> HAS_SHOULDER_ENTITY;

	public static void init(Predicate<ServerPlayer> hasShoulderEntity)
	{
		Perch.LOGGER.info("Intializing Perch...");
		Perch.HAS_SHOULDER_ENTITY = hasShoulderEntity;
	}

	public static boolean shouldDrop(InteractionResult result, @Nonnull ServerPlayer player, ItemStack stack)
	{
		return !result.consumesAction() && HAS_SHOULDER_ENTITY.test(player) && player.isCrouching() && stack.isEmpty();
	}
}
