package com.example.restapi_masterdev.Implement;

import com.example.restapi_masterdev.Exeption.DuplicateRecordException;
import com.example.restapi_masterdev.Exeption.NotFoundException;
import com.example.restapi_masterdev.Model.User;
import com.example.restapi_masterdev.Repository.userRepo;
import com.example.restapi_masterdev.Service.userService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class userImplement implements userService {
    @Autowired
    private userRepo userRepo;

    private final PasswordEncoder passwordEncoder;


    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(int id) throws NotFoundException {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){
            return user.get();
        }
        else {
            throw new NotFoundException("User not found");
        }
    }
    @Override
    public Boolean checkEmail(String email){
        List<User> listUser = this.userRepo.findAll();
        if (listUser.isEmpty()){
            return false;
        }
        for (User u : listUser){
            if (Objects.equals(u.getEmail(), email)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean checkPassword(String password) {

        if(password.length()>=8)
        {
            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            //Pattern eight = Pattern.compile (".{8}");
            Matcher hasLetter = letter.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);

            return hasLetter.find() && hasDigit.find() && hasSpecial.find();

        }
        else
            return false;

    }
    @Override
    public String addUser(User user) throws DuplicateRecordException {
        if (this.checkEmail(user.getEmail())){
            return "Email already exist";
        } else if (this.checkPassword(user.getPassword())) {
            return "Invalid password";
        }
        else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepo.save(user);
            return "done!";
        }
    }
    @Override
    public String deleteUser(int id) {
        Optional<User> u = userRepo.findById(id);
        if (u.isPresent()){
            userRepo.deleteById(id);
            return "success";
        }
        else {
            return "don'n have id = "+id;
        }
    }

    @Override
    public String updateUser(int id, User user) {
        User u = this.findById(id);
        if (u.getEmail()==user.getEmail() && this.checkPassword(user.getPassword())){
            u.setEmail(user.getEmail());
            u.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userRepo.save(u);
            return "update susses";
        }
        return "errol!";
    }
}
