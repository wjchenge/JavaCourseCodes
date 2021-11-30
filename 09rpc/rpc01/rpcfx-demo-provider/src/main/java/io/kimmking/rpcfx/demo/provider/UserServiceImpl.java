package io.kimmking.rpcfx.demo.provider;

import io.kimmking.rpcfx.annotation.WjchengeService;
import io.kimmking.rpcfx.demo.api.User;
import io.kimmking.rpcfx.demo.api.UserService;

@WjchengeService
public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }
}
