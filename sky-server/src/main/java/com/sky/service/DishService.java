package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

public interface DishService {

    /**
     * 新增菜品
     * @param dishDTO
     */
    void save(DishDTO dishDTO);

    /**
     * 分页查询
     * @param dishPageQueryDTO
     * @return
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 根据id删除菜品
     * @param ids
     */
    void delete(String ids);

    /**
     * 根据id查询菜品
     * @param id
     */
    DishVO getByIdWithFlavors(Long id);

    /**
     * 编辑菜品信息
     * @param dishDTO
     */
    void updateDish(DishDTO dishDTO);
//
//    /**
//     * 修改分类
//     * @param categoryDTO
//     */
//    void update(CategoryDTO categoryDTO);
//
//    /**
//     * 启用、禁用分类
//     * @param status
//     * @param id
//     */
//    void startOrStop(Integer status, Long id);
//
//    /**
//     * 根据类型查询分类
//     * @param type
//     * @return
//     */
//    List<Category> list(Integer type);
}
