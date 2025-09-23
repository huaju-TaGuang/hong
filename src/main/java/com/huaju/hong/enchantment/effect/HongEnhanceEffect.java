package com.huaju.hong.enchantment.effect;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/**
 * 虹增强魔咒
 * 玩家使用带有此附魔的武器攻击时，生成闪电
 *
 * @author huaju
 */
public record HongEnhanceEffect (EnchantmentLevelBasedValue amount) implements EnchantmentEntityEffect {

    /**
     * 定义编码器，JSON 数据文件中的配置转换为 Java 代码中的 HongEnhanceEffect对象
     */
    public static final MapCodec<HongEnhanceEffect> CODEC = RecordCodecBuilder.mapCodec(instance->
            instance.group(
                    EnchantmentLevelBasedValue.CODEC.fieldOf("amount").forGetter(HongEnhanceEffect::amount)
            ).apply(instance, HongEnhanceEffect::new)
    );

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        if(target instanceof LivingEntity victim){
            if(context.owner() != null && context.owner() instanceof PlayerEntity player){
                float numStrikes = this.amount.getValue(level);

                for(float i = 0; i < numStrikes; i++){
                    BlockPos position = victim.getBlockPos();
                    EntityType.LIGHTNING_BOLT.spawn(world, position, SpawnReason.TRIGGERED);
                }
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
