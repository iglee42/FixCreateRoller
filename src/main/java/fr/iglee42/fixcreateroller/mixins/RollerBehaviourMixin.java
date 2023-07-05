package fr.iglee42.fixcreateroller.mixins;

import com.simibubi.create.content.contraptions.actors.roller.RollerMovementBehaviour;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RollerMovementBehaviour.class,remap = false)
public class RollerBehaviourMixin {

    @Inject(method = "testBreakerTarget",at = @At("HEAD"),cancellable = true)
    private void inject(MovementContext context, BlockPos target, int columnY, CallbackInfoReturnable<Boolean> cir){
        if (context == null || context.world == null || context.world.getBlockState(target) == null) cir.setReturnValue(true);
    }

}
