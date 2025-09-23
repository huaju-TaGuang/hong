package com.huaju.hong.datagen;

import com.huaju.hong.Hong;
import com.huaju.hong.common.HongEnchantmentEffects;
import com.huaju.hong.enchantment.effect.HongEnhanceEffect;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class EnchantmentGenerator extends FabricDynamicRegistryProvider {

    public EnchantmentGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture){
        super(output, registriesFuture);
        System.out.println("[Hong.Print] 注册附魔 .");
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries) {
        register(entries, HongEnchantmentEffects.HONG_ENHANCEMENT_KEY, Enchantment.builder(
                                Enchantment.definition(
                                        // 可附魔物
                                        wrapperLookup.getOrThrow(RegistryKeys.ITEM).getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                                        // 附魔出现权重
                                        10,
                                        // 最大等级
                                        8,
                                        // 附魔需求
                                        Enchantment.leveledCost(1, 10),
                                        // 最大附魔需求
                                        Enchantment.leveledCost(1, 15),
                                        // 铁砧成本
                                        5,
                                        // 插槽
                                        AttributeModifierSlot.HAND
                                )
                        )
                        .addEffect(
                                // 触发时机 攻击后触发
                                EnchantmentEffectComponentTypes.POST_ATTACK,
                                //效果目标
                                EnchantmentEffectTarget.ATTACKER,   // 攻击者
                                EnchantmentEffectTarget.VICTIM,     // 受害者
                                // 定义效果实例
                                new HongEnhanceEffect(EnchantmentLevelBasedValue.linear(2f, 1f))
                        )
        );
    }

    @Override
    public String getName() {
        return "Hong Enchantments";
    }

    /**
     * 注册
     * @param entries
     * @param key
     * @param builder
     * @param resourceConditions
     */
    private void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
        entries.add(key, builder.build(key.getValue()), resourceConditions);
    }
}
