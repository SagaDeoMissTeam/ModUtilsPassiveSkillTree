package net.sixik.modutilspassiveskilltree.addons.crafttweaker.events;


import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import net.sixik.modutilspassiveskilltree.events.PSPlayerGrandSkillPointEvent;
import org.openzen.zencode.java.ZenCodeType;


@ZenRegister
@NativeTypeRegistration(value = PSPlayerGrandSkillPointEvent.class, zenCodeName = "mods.modutils.passiveskilltree.events.PSPlayerGrandSkillPointEvent")
public class ExpandPSPlayerGrandSkillPointEvent {

    @ZenCodeType.Method
    @ZenCodeType.Getter("playerSkillPoints")
    public static int getPlayerSkillPoints(PSPlayerGrandSkillPointEvent event){
        return event.getPlayerSkillPoints();
    }

    @ZenCodeType.Method
    @ZenCodeType.Getter("grandSillPoint")
    public static int getGrandSillPoint(PSPlayerGrandSkillPointEvent event){
        return event.getGrandSillPoint();
    }

    @ZenCodeType.Method
    @ZenCodeType.Getter("playerSkillPoints")
    public static void setPlayerSkillPoints(PSPlayerGrandSkillPointEvent event, int points){
        event.setPlayerSkillPoints(points);
    }

    @ZenCodeType.Method
    @ZenCodeType.Getter("grandSillPoint")
    public static void setGrandSillPoint(PSPlayerGrandSkillPointEvent event, int points){
        event.setGrandSillPoint(points);
    }
}
