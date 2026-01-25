package dev.jolkert.perch.mixin;

import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Player.class)
public class SuppressFallDropMixin
{
	// i think this is the smartest way to do this? it should certainly be the most compatible with other implementations
	// of this behavior. it also seems like itll require the least maintenance going forward
	// -morgan 2026-01-25
	@ModifyConstant(method = "aiStep", constant = @Constant(floatValue = 0.5f))
	float setFallDistanceRequirementImpossiblyHigh(float _original)
	{
		return Float.POSITIVE_INFINITY;
	}
}
