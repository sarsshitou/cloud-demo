package cn.itcast.feign.clients;

import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lmy
 */
@FeignClient(value = "userservice")
public interface UserClient {
    /**
     * 根据id查询用户对象
     *
     * @param id 用户编号
     * @return 用户对象
     */
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
