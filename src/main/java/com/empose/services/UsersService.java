package com.empose.services;

import com.empose.models.Sku;
import com.empose.models.Users;
import com.empose.repositories.SkuRepository;
import com.empose.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Optional<Users> findById(Integer id) {
        return usersRepository.findById(id);
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Users save(Users users) {
        Optional<Users> optClient = usersRepository.findByName(users.getName());

        if (!optClient.isPresent()) {
            return usersRepository.save(users);
        }
        return new Users();
    }

    public Users update(Users sku) {
        Optional<Users> optPayment = usersRepository.findById(sku.getId());
        Users skuUpdated = new Users();

        if (optPayment.isPresent()) {
            skuUpdated = usersRepository.save(sku);
        }
        return skuUpdated;
    }

    public String remove(Users sku) {
        Optional<Users> optPayment = usersRepository.findById(sku.getId());

        if (optPayment.isPresent()) {
            usersRepository.delete(sku);
                return "";
            } else {
                return "Sku não pode ser removido.";
            }
    }
}
