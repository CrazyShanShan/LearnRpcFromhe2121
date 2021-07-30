package org.crazys.server;

import org.crazys.common.User;
import org.crazys.service.UserService;

import java.util.Random;

/***
 * @Description: "
 * @Author: ZBZ
 * @Date: 2021/5/28
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getUserByUserId(Integer id) {
        System.out.println("客户端查询了"+id+"的用户");

        // 模拟从数据库中取数据的行为
        User user = new User();
        user.setId(id);
        user.setUserName("crazys");
        boolean sex = new Random().nextBoolean();
        user.setSex(sex);

        return user;
    }
}
