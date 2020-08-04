package com.softserve.edu.service.impl;

import com.softserve.edu.entity.Marathon;
import com.softserve.edu.entity.Role;
import com.softserve.edu.entity.User;
import com.softserve.edu.exception.InternalServerException;
import com.softserve.edu.repository.MarathonRepository;
import com.softserve.edu.repository.UserRepository;
import com.softserve.edu.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MarathonRepository marathonRepository;

    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }

    @Override
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeStudent(User byId) {
        userRepository.delete(byId);
    }

    @Override
    public void addToMarathon(Integer studentId, Integer marathonId) {
        User user = userRepository.findById(studentId).get();
        Marathon marathon = marathonRepository.findById(marathonId).get();
        if (marathon.getUsers().contains(user)) {
            throw new InternalServerException("User with id = " + user.getId() +
                    " already added to " + marathon.getName());
        }
        marathon.getUsers().add(user);
        marathonRepository.save(marathon);
    }
}
