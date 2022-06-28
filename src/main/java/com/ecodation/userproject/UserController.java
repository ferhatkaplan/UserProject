package com.ecodation.userproject;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

//http://localhost:8080/h2-console
@Log4j2
@Controller
public class UserController {

    @Autowired
    IUserRepository repository;

    // http://localhost:8080/user/save/fake
    @GetMapping("user/save/fake")
    @ResponseBody
    public List<UserEntity> fakeImportData() {
        List<UserEntity> entityList = new ArrayList<>();
        UserEntity entity = null;
        for (int i = 1; i < 10; i++) {
            entity = UserEntity.builder()
                    .userName("adi " + i)
                    .userSurname("soyadi " + i)
                    .userEmail("email " + i)
                    .userPassword("password")
                    //  .id("id" + i)
                    .build();
            repository.save(entity);
            entityList.add(entity);
        }
        return entityList;
    }

    //SAVE
    //http://localhost:8080/user/save
    @GetMapping("/user/save")
    public String getUser(Model model) {
        model.addAttribute("validation_user", new UserDto());
        return "user_save";
    }

    //http://localhost:8080/user/save
    @PostMapping("/user/save")
    public String postUser(@Valid @ModelAttribute("validation_user") @RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_save";
        }
        UserEntity entity = new UserEntity();
        entity.setUserEmail(customerDto.getUserEmail());
        entity.setUserName(customerDto.getUserName());
        entity.setUserPassword(customerDto.getUserPassword());
        entity.setUserSurname(customerDto.getUserSurname());
        repository.save(entity);
        return "redirect:/user/list";
    }
}

    //LIST
    // http://localhost:8080/user/list
    @GetMapping("/user/list")
    public String listUser(Model model) {
        List<UserEntity> listem = repository.findAll();
        model.addAttribute("list_user", listem);
        return "user_list";
    }

    //FIND
    //http://localhost:8080/user/find/1
    @GetMapping("/user/find/{id}")
    public String findUser(@PathVariable(name = "id") Long id, Model model) {
        Optional<UserEntity> find = repository.findById(id);
        if (find.isPresent()) {
            //return "Bulundu"+find.get();
            model.addAttribute("find_key", find.get());
            return "user_view";
        } else
            return "redirect:/user/list";
    }

    //UPDATE
    @GetMapping("/user/update/{id}")
    public String updateUser(@PathVariable(name = "id") Long id) {
        return null;
    }

    //DELETE
    //http://localhost:8080/user/delete/4
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id, Model model) {
        Optional<UserEntity> find = repository.findById(id);
        if (find.isPresent()) {
            repository.deleteById(id);
            model.addAttribute("data", "success");
        } else {
            model.addAttribute("data", "failed");
        }
        return "redirect:/user/list";
    }
}
