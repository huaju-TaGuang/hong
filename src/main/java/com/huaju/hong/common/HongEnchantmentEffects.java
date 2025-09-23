package com.huaju.hong.common;

import com.huaju.hong.Hong;
import com.huaju.hong.enchantment.effect.HongEnhanceEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

/**
 * 虹-魔咒效果注册
 *
 * @author huaju
 */
public class HongEnchantmentEffects {

    // 虹增强效果注册
    public static final MapCodec<HongEnhanceEffect> HONG_ENHANCEMENT = register("hong_enhance_effect", HongEnhanceEffect.CODEC);

    public static final RegistryKey<Enchantment> HONG_ENHANCEMENT_KEY = of("hong_enhance_effect");

    /**
     *
     * @param path
     * @return
     */
    private static RegistryKey<Enchantment> of(String path) {
        Identifier id = Identifier.of(Hong.MOD_ID, path);
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, id);
    }

    /**
     * 注册魔咒到魔咒注册表中
     * @param id    id
     * @param codec
     * @return
     * @param <T>
     */
    private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String id, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Hong.MOD_ID, id), codec);
    }

    public static void initialize() {
        Hong.LOGGER.info("效果注册：" + Hong.MOD_ID);
    }

}
