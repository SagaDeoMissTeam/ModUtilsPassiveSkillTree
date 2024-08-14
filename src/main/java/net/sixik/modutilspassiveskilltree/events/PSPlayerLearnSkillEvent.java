package net.sixik.modutilspassiveskilltree.events;

import daripher.skilltree.skill.PassiveSkill;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Cancelable;

@Cancelable
public class PSPlayerLearnSkillEvent extends PlayerEvent {

    public PassiveSkill passiveSkill;

    public PSPlayerLearnSkillEvent(Player player,PassiveSkill passiveSkill) {
        super(player);
        this.passiveSkill = passiveSkill;
    }

    public PassiveSkill getPassiveSkill() {
        return passiveSkill;
    }
}
