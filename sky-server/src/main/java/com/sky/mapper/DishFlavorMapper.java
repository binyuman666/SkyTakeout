package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

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
     * 根据菜品ids删除口味
     * @param idList
     * @return
     */
    void deleteBatchByDishId(List<Long> idList);

    /**
     * 根据口味id删除口味
     * @param ids
     * @return
     */
    void deleteBatchByFlavorId(List<Long> ids);

    /**
     * 根据菜品id查询菜品口味
     * @param dishId
     * @return
     */
    @Select("select * from dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> getByDishId(Long dishId);

    /**
     * 根据菜品id删除口味
     * @param dishId
     * @return
     */
    @Delete("delete from dish_flavor where dish_id = #{dishId}")
    void deleteByDishId(Long dishId);

//    /**
//     * 编辑菜品口味信息
//     * @param flavors
//     * @return
//     */
//    void update(List<DishFlavor> flavors);

}
