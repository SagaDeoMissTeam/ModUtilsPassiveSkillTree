package net.sixik.modutilspassiveskilltree.events;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Cancelable;

@Cancelable
public class PSPlayerResetSkillEvent extends PlayerEvent {

    public PSPlayerResetSkillEvent(Player player) {
        super(player);
    }
}
