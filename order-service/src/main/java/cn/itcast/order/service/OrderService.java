package cn.itcast.order.service;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author pxs
 */
@Slf4j
@Service
public class OrderService {

    private final OrderMapper orderMapper;

    private final RestTemplate restTemplate;
    private final UserClient userClient;

    public OrderService(OrderMapper orderMapper, RestTemplate restTemplate, UserClient userClient) {
        this.orderMapper = orderMapper;
        this.restTemplate = restTemplate;
        this.userClient = userClient;
    }

    public Order queryOrderById(Long id) {
        // 1.查询订单
        Order order = orderMapper.findById(id);
        // 2.用户Feign远程调用
        User user = userClient.findById(order.getUserId());
        // 3.封装User
        order.setUser(user);
        // 4.返回
        return order;
    }
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        // 2.利用RestTemplate发起http请求，查询用户
//        // 2.1.url路径
//        String url = "http://userservice/user/"+order.getUserId();
//        // 2.2.发送http请求，实现远程调用
//        User user = restTemplate.getForObject(url, User.class);
//        // 3.封装User
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }
}
