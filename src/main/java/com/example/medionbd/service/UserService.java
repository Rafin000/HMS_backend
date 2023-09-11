package com.example.medionbd.service;

import com.example.medionbd.model.Doctor;
import com.example.medionbd.model.User;
import com.example.medionbd.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.print.Doc;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void createUser(User user){
        Optional<User> userOptional = userRepository.findUsersByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw  new IllegalStateException("Email Already Occupied");
        }
        userRepository.save(user);
    }

    public  void deleteUser(UUID userId){
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw  new IllegalStateException("User doesn't exists");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(UUID userId, User updatedUser){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalStateException("User Id with "+ userId +" doesn't exists!"));
        String updatedFirstName = updatedUser.getFirstName();
        String updatedLastName = updatedUser.getLastName();
        String updatedPassword= updatedUser.getPassword();
        String updatedPhoneNumber= updatedUser.getPhoneNumber();

        if(updatedFirstName !=null && updatedFirstName.length()>0 && !Objects.equals(user.getFirstName(),updatedFirstName)){
            user.setFirstName(updatedFirstName);
        }
        if(updatedLastName !=null && updatedLastName.length()>0 && !Objects.equals(user.getLastName(),updatedLastName)){
            user.setLastName(updatedLastName);
        }
        if(updatedPassword !=null && updatedPassword.length()>0 && !Objects.equals(user.getPassword(),updatedPassword)){
            user.setPassword(updatedPassword);
        }
        if(updatedPhoneNumber !=null && updatedPhoneNumber.length()>0 && !Objects.equals(user.getPhoneNumber(),updatedPhoneNumber)){
            user.setPhoneNumber(updatedPhoneNumber);
        }
    }
}
