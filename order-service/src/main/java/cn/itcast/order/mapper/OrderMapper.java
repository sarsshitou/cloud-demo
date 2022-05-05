package cn.itcast.order.mapper;

import cn.itcast.order.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author lmy
 */
@Mapper
public interface OrderMapper {

    /**
     * 查询订单信息
     *
     * @param id
     * @return
     */
    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);
}
