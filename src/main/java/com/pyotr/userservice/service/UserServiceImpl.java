package com.pyotr.userservice.service;

import com.pyotr.userservice.domain.Role;
import com.pyotr.userservice.domain.User;
import com.pyotr.userservice.repo.RoleRepo;
import com.pyotr.userservice.repo.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
/*
ESTA ES LA CLASE DONDE SE VAN A DESARROLLAR LOS MÉTODOS QUE DARAN EL SERVICIO
PARA ELLO TIENE QUE TENER COMO ATRIBUTOS LOS REPOSITORIOS QUE VA A UTILIZAR
 */
@Service
@RequiredArgsConstructor //Con esto inyectamos las instancias de UserRepo y RoleRepo para usarlas como atributos
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    private  final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public User saveUser(User user) {
        log.info("Guardando nuevo usuario {} en la base de datos", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Guardando nuevo rol {} en la base de datos" , role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        log.info("Añadiendo rol {} a usuario {}" , rolename, username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(rolename);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Obteniendo usuario {}" , username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Obteniendo todos los usuarios");
        return userRepo.findAll();
    }
}
