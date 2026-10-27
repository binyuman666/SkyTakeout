package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.result.PageResult;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 分类业务层
 */
@Service
@Slf4j
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    /**
     * 新增菜品
     * @param dishDTO
     */
    @Transactional
    public void save(DishDTO dishDTO) {
        Dish dish = new Dish();
        //属性拷贝
        BeanUtils.copyProperties(dishDTO, dish);
        dishMapper.insertDish(dish);

        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (flavors != null && flavors.size() > 0){
            flavors.forEach(flavor ->
                    flavor.setDishId(dish.getId()));
            dishFlavorMapper.insert(flavors);
        }
    }

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    public PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO) {
        PageHelper.startPage(dishPageQueryDTO.getPage(),dishPageQueryDTO.getPageSize());
        //下一条sql进行分页，自动加入limit关键字分页
        Page<DishVO> page = dishMapper.pageQuery(dishPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }
    //1111111111
    //
//
//    /**
//     * 根据id删除分类
//     * @param id
//     */
//    public void deleteById(Long id) {
//        //查询当前分类是否关联了菜品，如果关联了就抛出业务异常
//        Integer count = dishMapper.countByCategoryId(id);
//        if(count > 0){
//            //当前分类下有菜品，不能删除
//            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_DISH);
//        }
//
//        //查询当前分类是否关联了套餐，如果关联了就抛出业务异常
//        count = setmealMapper.countByCategoryId(id);
//        if(count > 0){
//            //当前分类下有菜品，不能删除
//            throw new DeletionNotAllowedException(MessageConstant.CATEGORY_BE_RELATED_BY_SETMEAL);
//        }
//
//        //删除分类数据
//        categoryMapper.deleteById(id);
//    }
//
//    /**
//     * 修改分类
//     * @param categoryDTO
//     */
//    public void update(CategoryDTO categoryDTO) {
//        Category category = new Category();
//        BeanUtils.copyProperties(categoryDTO,category);
//
//        categoryMapper.update(category);
//    }
//
//    /**
//     * 启用、禁用分类
//     * @param status
//     * @param id
//     */
//    public void startOrStop(Integer status, Long id) {
//        Category category = Category.builder()
//                .id(id)
//                .status(status)
//                .build();
//        categoryMapper.update(category);
//    }
//
//    /**
//     * 根据类型查询分类
//     * @param type
//     * @return
//     */
//    public List<Category> list(Integer type) {
//        return categoryMapper.list(type);
//    }
}
