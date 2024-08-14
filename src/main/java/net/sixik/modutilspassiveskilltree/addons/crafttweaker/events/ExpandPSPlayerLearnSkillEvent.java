package net.sixik.modutilspassiveskilltree.addons.crafttweaker.events;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import daripher.skilltree.skill.PassiveSkill;
import net.sixik.modutilspassiveskilltree.events.PSPlayerLearnSkillEvent;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@NativeTypeRegistration(value = PSPlayerLearnSkillEvent.class, zenCodeName = "mods.modutils.passiveskilltree.events.PSPlayerLearnSkillEvent")
public class ExpandPSPlayerLearnSkillEvent {


    @ZenCodeType.Getter("passiveSkill")
    @ZenCodeType.Method
    public static PassiveSkill getPassiveSkill(PSPlayerLearnSkillEvent event){
        return event.getPassiveSkill();
    }
}
