package com.huaju.hong.service.impl;

import com.huaju.hong.group.HongGroup;
import com.huaju.hong.item.HongArmor;
import com.huaju.hong.item.HongIngot;
import com.huaju.hong.item.Test;
import com.huaju.hong.service.InitService;
import net.minecraft.item.ItemGroups;

public class InitServiceImpl implements InitService {

    @Override
    public void initHong() {
        // 初始化物品
        HongIngot.initialize();
        HongArmor.initialize();
        HongGroup.initialize();
        Test.initialize();

        // 注册进装备组
        HongIngot.RegisterToGroup(ItemGroups.INGREDIENTS, HongIngot.HONG_INGOT);
        HongArmor.RegisterToGroup(ItemGroups.INGREDIENTS, HongArmor.HONG_HELMET);
        HongArmor.RegisterToGroup(ItemGroups.INGREDIENTS, HongArmor.HONG_CHESTPLATE);
        HongArmor.RegisterToGroup(ItemGroups.INGREDIENTS, HongArmor.HONG_LEGGINGS);
        HongArmor.RegisterToGroup(ItemGroups.INGREDIENTS, HongArmor.HONG_BOOTS);
    }

    @Override
    public void initHongGroup() {
        HongGroup.registerAdd(HongIngot.HONG_INGOT);
        HongGroup.registerAdd(HongArmor.HONG_HELMET);
        HongGroup.registerAdd(HongArmor.HONG_CHESTPLATE);
        HongGroup.registerAdd(HongArmor.HONG_LEGGINGS);
        HongGroup.registerAdd(HongArmor.HONG_BOOTS);
    }

}
