package com.huaju.hong.common;

import com.huaju.hong.Hong;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class HongItems {

    /**
     * 注册物品
     * @param id
     * @param settings
     * @return
     */
    public static Item register(String id) {
        return register(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Hong.MOD_ID, id)), Item::new, new Item.Settings());
    }

    /**
     * 注册物品
     * @param id
     * @param settings
     * @return
     */
    public static Item register(String id, Item.Settings settings) {
        return register(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Hong.MOD_ID, id)), Item::new, settings);
    }

    /**
     * 注册工厂函数
     * @param key
     * @param factory
     * @param settings
     * @return
     */
    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = (Item)factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }
        return Registry.register(Registries.ITEM, key, item);
    }

}
