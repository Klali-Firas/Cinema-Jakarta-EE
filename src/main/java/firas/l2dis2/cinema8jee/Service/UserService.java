package firas.l2dis2.cinema8jee.Service;

import firas.l2dis2.cinema8jee.Entity.User;
import firas.l2dis2.cinema8jee.dao.DaoUser;

public class UserService {
    DaoUser daoUser = new DaoUser();

    public void createUser(User user) {
        daoUser.addUser(user);
    }

    public User login(String email, String password) {
        return daoUser.login(email, password);
    }
}
