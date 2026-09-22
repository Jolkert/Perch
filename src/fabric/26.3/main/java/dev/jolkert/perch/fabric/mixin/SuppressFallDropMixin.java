package dev.jolkert.perch.fabric.mixin;

import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerPlayer.class)
public class SuppressFallDropMixin
{
	// i think this is the smartest way to do this? it should certainly be the most compatible with other implementations
	// of this behavior. it also seems like itll require the least maintenance going forward
	// -morgan 2026-01-25
	@ModifyConstant(method = "handleShoulderEntities", constant = @Constant(doubleValue = 0.5f))
	double setFallDistanceRequirementImpossiblyHigh(double _original)
	{
		return Float.POSITIVE_INFINITY;
	}
}
