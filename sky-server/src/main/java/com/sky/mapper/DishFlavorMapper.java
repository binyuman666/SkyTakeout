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

    /**
     * 根据id删除口味
     * @param idList
     * @return
     */
    void deleteBatch(List<Long> idList);
}
