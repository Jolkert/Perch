package dev.jolkert.perch.fabric.mixin;

import dev.jolkert.perch.Perch;
import dev.jolkert.perch.mixin.ShoulderDropInvoker;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerGameMode.class)
public class GroundInteractParrotDropMixin
{
	@Inject(method = "useItemOn", at = @At("RETURN"), cancellable = true)
	void useItem(ServerPlayer player, Level _level, ItemStack stack, InteractionHand _hand, BlockHitResult _hitResult, CallbackInfoReturnable<InteractionResult> cir)
	{
		if (Perch.shouldDrop(cir.getReturnValue(), player, stack))
		{
			((ShoulderDropInvoker) player).removeEntitiesOnShoulder();
			cir.setReturnValue(InteractionResult.SUCCESS_NO_ITEM_USED);
		}
	}
}
