package net.sixik.modutilspassiveskilltree.addons.crafttweaker;


import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import daripher.skilltree.capability.skill.PlayerSkillsProvider;
import daripher.skilltree.data.reloader.SkillTreesReloader;
import daripher.skilltree.skill.PassiveSkill;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.openzen.zencode.java.ZenCodeType;

import java.util.List;

@ZenRegister
@ZenCodeType.Expansion("crafttweaker.api.entity.type.player.Player")
public class ExpandPlayer {

    @ZenCodeType.Method
    public static void removeSkill(Player player, ResourceLocation skillId){
        int i = -1;
        for (int i1 = 0; i1 < PlayerSkillsProvider.get(player).getPlayerSkills().size(); i1++) {
            PassiveSkill skill = PlayerSkillsProvider.get(player).getPlayerSkills().get(i1);
            if(skill.getId().equals(skillId)){
                i = i1;
                break;
            }
        }

        if(i != -1) {
            PlayerSkillsProvider.get(player).getPlayerSkills().remove(i);
        }
    }

    @ZenCodeType.Method
    @ZenCodeType.Getter("playerSkills")
    public static List<PassiveSkill> getPlayerSkills(Player player){
       return PlayerSkillsProvider.get(player).getPlayerSkills().stream().toList();
    }

    @ZenCodeType.Method
    public static List<ResourceLocation> getAllSkills(Player player, ResourceLocation skillTreeID){
       return SkillTreesReloader.getSkillTreeById(skillTreeID).getSkillIds();
    }

    @ZenCodeType.Method
    @ZenCodeType.Getter("skillPoints")
    public static int getSkillPoints(Player player){
       return PlayerSkillsProvider.get(player).getSkillPoints();
    }

    @ZenCodeType.Method
    @ZenCodeType.Setter("skillPoints")
    public static void setSkillPoints(Player player, int count){
       PlayerSkillsProvider.get(player).setSkillPoints(count);
    }

    @ZenCodeType.Method
    @ZenCodeType.Setter("skillPoints")
    public static void grantSkillPoints(Player player, int count){
       PlayerSkillsProvider.get(player).grantSkillPoints(count);
    }

    @ZenCodeType.Method
    @ZenCodeType.Getter("isTreeReset")
    public static boolean isTreeReset(Player player){
      return PlayerSkillsProvider.get(player).isTreeReset();
    }

    @ZenCodeType.Method
    public static void resetTree(Player player){
      PlayerSkillsProvider.get(player).resetTree((ServerPlayer) player);
    }

    @ZenCodeType.Method
    @ZenCodeType.Setter("treeReset")
    public static void setTreeReset(Player player, boolean v){
       PlayerSkillsProvider.get(player).setTreeReset(v);
    }
}
