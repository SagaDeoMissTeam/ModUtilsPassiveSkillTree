package net.sixik.modutilspassiveskilltree.events;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PSPlayerGrandSkillPointEvent extends PlayerEvent {

    public int playerSkillPoints;
    public int grandSillPoint;

    public PSPlayerGrandSkillPointEvent(Player player, int playerSkillPoints, int grandSillPoint) {
        super(player);
        this.grandSillPoint = grandSillPoint;
        this.playerSkillPoints = playerSkillPoints;
    }

    public int getGrandSillPoint() {
        return grandSillPoint;
    }

    public int getPlayerSkillPoints() {
        return playerSkillPoints;
    }

    public void setPlayerSkillPoints(int playerSkillPoints) {
        this.playerSkillPoints = playerSkillPoints;
    }

    public void setGrandSillPoint(int grandSillPoint) {
        this.grandSillPoint = grandSillPoint;
    }

    public int getGrand() {
        return this.playerSkillPoints + grandSillPoint;
    }
}
