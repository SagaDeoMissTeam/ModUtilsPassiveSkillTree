package net.sixik.modutilspassiveskilltree.addons.crafttweaker;


import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import daripher.skilltree.skill.PassiveSkill;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

import java.util.List;

@ZenRegister
@NativeTypeRegistration(value = PassiveSkill.class, zenCodeName = "mods.modutils.passiveskilltree.PassiveSkill")
public class ExpandPassiveSkill {

    @ZenCodeType.Method
    @ZenCodeType.Getter("id")
    public static ResourceLocation getId(PassiveSkill passiveSkill) {
        return passiveSkill.getId();
    }

    @ZenCodeType.Method
    @ZenCodeType.Getter("title")
    public static String getTitle(PassiveSkill passiveSkill) {
        return passiveSkill.getTitle();
    }

    @ZenCodeType.Method
    @ZenCodeType.Getter("tags")
    public static List<String> getTags(PassiveSkill passiveSkill) {
        return passiveSkill.getTags();
    }
}
