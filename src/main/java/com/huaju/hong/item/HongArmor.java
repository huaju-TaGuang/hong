package com.huaju.hong.item;

import com.huaju.hong.common.HongItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;

/**
 * 虹-盔甲
 * 由虹锭制作的基本护甲
 *
 * @author huaju
 */
public class HongArmor {

    // 注册盔甲
    public static final Item HONG_HELMET = HongItems.register(
            "hong_helmet",
            new Settings()
                    .armor(HongIngot.INSTANCE, EquipmentType.HELMET)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(HongIngot.BASE_DURABILITY))
    );   // 虹-头盔
    public static final Item HONG_CHESTPLATE = HongItems.register(
            "hong_chestplate",
            new Settings()
                    .armor(HongIngot.INSTANCE, EquipmentType.CHESTPLATE)
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(HongIngot.BASE_DURABILITY))
    );   // 虹-护甲
    public static final Item HONG_LEGGINGS = HongItems.register(
            "hong_leggings",
            new Settings()
                    .armor(HongIngot.INSTANCE, EquipmentType.LEGGINGS)
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(HongIngot.BASE_DURABILITY))
    );   // 虹-护腿
    public static final Item HONG_BOOTS = HongItems.register(
            "hong_boots",
            new Settings()
                    .armor(HongIngot.INSTANCE, EquipmentType.BOOTS)
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(HongIngot.BASE_DURABILITY))
    );   // 虹-鞋子

    /**
     * 初始化虹基础盔甲
     */
    public static void initialize(){
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
