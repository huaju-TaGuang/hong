package com.huaju.hong.item;

import com.huaju.hong.Hong;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

/**
 * 虹-锭
 * 合成材料，用于mod合成护甲和武器的基础
 * 高效燃料，用作燃料，燃烧时长为 1 hour
 *
 * @author huaju
 */
public class HongIngot extends Item {

    public HongIngot(Settings settings) { super(settings); }

    /**
     * 注册该物品
     */
    public static final Item HONG_INGOT = Items.register("hong_ingot");

    /**
     * 基础耐久度
     */
    public static final int BASE_DURABILITY = 15;

    /**
     * 注册资产
     */
    public static final RegistryKey<EquipmentAsset> HONG_INGOT_MATERIAL_KEY = RegistryKey.of(
            EquipmentAssetKeys.REGISTRY_KEY,
            Identifier.of(Hong.MOD_ID, "hong_ingot")
    );

    /**
     * 创建修复材料 虹锭
     * 注册TagKey 可以进行合成
     */
    public static final TagKey<Item> REPAIRS_HONG_ARMOR = TagKey.of(RegistryKeys.ITEM, Identifier.of(Hong.MOD_ID, "repairs_hong_armor"));

    /**
     * 创建装备资产
     */
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            80,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            50.0f,
            10.0f,
            REPAIRS_HONG_ARMOR,
            HONG_INGOT_MATERIAL_KEY
    );

    /**
     * 初始化函数
     */
    public static void initialize(){
        FuelRegistryEvents.BUILD.register((builder, context) -> { builder.add(HongIngot.HONG_INGOT, 60 * 60 * 20); });  // 作为燃料可燃烧一小时
        RegisterToGroup(ItemGroups.INGREDIENTS, HongIngot.HONG_INGOT);
    }

    /**
     * 注册物品进物品组
     * @param group 物品组
     * @param item 需要注册的物品
     */
    public static void RegisterToGroup(RegistryKey<ItemGroup> group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register((itemGroup) -> itemGroup.add(item));
    }

}
