package net.sixik.modutilspassiveskilltree.mixin;

import daripher.skilltree.capability.skill.IPlayerSkills;
import daripher.skilltree.capability.skill.PlayerSkillsProvider;
import net.minecraft.world.entity.player.Player;
import net.sixik.modutilspassiveskilltree.api.IPlayerHelper;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PlayerSkillsProvider.class, remap = false)
public class PlayerSkillsProviderMixin {

    @Inject(method = "get", at = @At("HEAD"))
    private static void sdm$get(Player player, CallbackInfoReturnable<IPlayerSkills> cir){
        IPlayerHelper.player = player;
    }
}
