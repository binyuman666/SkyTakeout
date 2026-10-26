package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    /**
     * 批量新增菜品口味
     * @param flavors
     * @return
     */
    void insert(List<DishFlavor> flavors);
//    void insertDishFlavor(DishFlavor flavor);
}
