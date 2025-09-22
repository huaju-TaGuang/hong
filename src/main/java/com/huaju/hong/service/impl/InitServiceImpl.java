package com.huaju.hong.service.impl;

import com.huaju.hong.group.HongGroup;
import com.huaju.hong.item.HongArmor;
import com.huaju.hong.item.HongIngot;
import com.huaju.hong.service.InitService;

public class InitServiceImpl implements InitService {

    @Override
    public void initHong() {
        HongIngot.initialize(); // 虹锭
        HongArmor.initialize(); // 虹-基础盔甲
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
