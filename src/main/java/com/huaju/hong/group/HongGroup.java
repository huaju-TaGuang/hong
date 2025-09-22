package com.huaju.hong.group;


import com.huaju.hong.Hong;
import com.huaju.hong.item.HongIngot;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * 虹 - 物品组
 * mod新增的道具存在此分组中
 *
 * @author huaju
 */
public class HongGroup  {

    /**
     * 物品组Key
     */
    public static final RegistryKey<ItemGroup> HONG_GROUP_ITEM_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Hong.MOD_ID, "hong_group_item"));

    /**
     * 物品组
     */
    public static final ItemGroup HONG_GROUP_ITEM = FabricItemGroup.builder()
            .icon(()->new ItemStack(HongIngot.HONG_INGOT))
            .displayName(Text.translatable("itemGroup.hong_group_item"))
            .build();

    /**
     * 初始化物品组
     */
    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP, HONG_GROUP_ITEM_KEY, HONG_GROUP_ITEM);
    }

    /**
     * 将物品注册进分组-虹
     */
    public static void registerAdd(Item item){
        ItemGroupEvents.modifyEntriesEvent(HONG_GROUP_ITEM_KEY).register(itemGroup->{
            itemGroup.add(item);
        });
    }

    /**
     * 将物品注册进分组
     */
    public static void registerAdd(RegistryKey<ItemGroup> group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(itemGroup->{
            itemGroup.add(item);
        });
    }

}
