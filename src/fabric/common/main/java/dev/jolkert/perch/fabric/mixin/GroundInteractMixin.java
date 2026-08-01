package dev.jolkert.perch.fabric.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.jolkert.perch.Perch;
import dev.jolkert.perch.fabric.PerchCommonFabric;
import dev.jolkert.perch.mixin.ShoulderDropInvoker;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ServerPlayerGameMode.class)
public class GroundInteractMixin
{
	@ModifyReturnValue(method = "useItemOn", at = @At("RETURN"))
	InteractionResult interactWithGround(InteractionResult original, @Local(argsOnly = true) ServerPlayer player, @Local(argsOnly = true) ItemStack stack)
	{
		if (Perch.shouldDrop(original, player, stack))
		{
			((ShoulderDropInvoker) player).perch$removeEntitiesOnShoulder();
			return PerchCommonFabric.DROP_SUCCESS;
		}
		else
		{
			return original;
		}
	}
}
