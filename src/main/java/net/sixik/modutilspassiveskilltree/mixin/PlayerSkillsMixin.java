package net.sixik.modutilspassiveskilltree.mixin;

import daripher.skilltree.capability.skill.PlayerSkills;
import daripher.skilltree.skill.PassiveSkill;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.sixik.modutilspassiveskilltree.api.IPlayerHelper;
import net.sixik.modutilspassiveskilltree.events.PSPlayerGrandSkillPointEvent;
import net.sixik.modutilspassiveskilltree.events.PSPlayerLearnSkillEvent;
import net.sixik.modutilspassiveskilltree.events.PSPlayerResetSkillEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PlayerSkills.class, remap = false)
public class PlayerSkillsMixin {

    @Shadow private int skillPoints;

    @Inject(method = "learnSkill", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/NonNullList;add(Ljava/lang/Object;)Z"), cancellable = true)
    public void sdm$learnSkill(PassiveSkill passiveSkill, CallbackInfoReturnable<Boolean> cir){
        if(IPlayerHelper.player != null) {
            PSPlayerLearnSkillEvent event = new PSPlayerLearnSkillEvent(IPlayerHelper.player, passiveSkill);
            MinecraftForge.EVENT_BUS.post(event);
            if(event.isCanceled()) cir.setReturnValue(false);
        }
    }

    @Inject(method = "resetTree", at = @At("HEAD"), cancellable = true)
    public void sdm$resetTree(ServerPlayer player, CallbackInfo ci){
        PSPlayerResetSkillEvent event = new PSPlayerResetSkillEvent(player);
        MinecraftForge.EVENT_BUS.post(event);
        if(event.isCanceled()) ci.cancel();
    }

    @Inject(method = "grantSkillPoints", at = @At("HEAD"), cancellable = true)
    public void sdm$grantSkillPoints(int skillPoints, CallbackInfo ci){
        if(IPlayerHelper.player != null) {
            ci.cancel();
            PSPlayerGrandSkillPointEvent event = new PSPlayerGrandSkillPointEvent(IPlayerHelper.player, this.skillPoints, skillPoints);
            MinecraftForge.EVENT_BUS.post(event);
            if(event.isCanceled()) {
                return;
            }

            if(event.playerSkillPoints != this.skillPoints) {
                this.skillPoints = event.playerSkillPoints;
                return;
            }

            this.skillPoints = event.getGrand();
        }
    }
}
