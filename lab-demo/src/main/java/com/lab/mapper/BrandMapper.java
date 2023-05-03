package com.lab.mapper;

import com.lab.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有
     * @return
     */
    //sql语句
    @Select("select * from tb_brand")
    //数据表中的属性名称和在brand类里面定义的不同，需要导入
    @ResultMap("brandResultMap")
    List<Brand> selectBrandAll();

    /**
     * 添加数据
     *
     */
    //sql语句里面的空格不能打多了，不然会出现错误
    //@Insert("insert into tb_brand values(null, #{brand_name},#{company_name},#{ordered},#{description},#{status}")
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void addBrand(Brand brand);

    /**
     * 根据Id查询品牌，便于后续更新数据和删除数据，以及条件项查询
     * @param id
     * @return
     */
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectBrandById(int id);

    /**
     * 更新数据
     * @param brand
     */
    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    void update(Brand brand);
    /**
     * 删除数据
     * @param  id
     */
    @Delete("delete from tb_brand where id =#{id}")
    void deleteBrandById(int id);

    /**
     * 根据Id查询品牌，便于后续更新数据和删除数据，以及条件项查询
     * @param brandName
     * @return
     */
    @Select("select * from tb_brand where brand_name = #{brandName}")
    @ResultMap("brandResultMap")
    Brand selectBrandByName(String brandName);



}
