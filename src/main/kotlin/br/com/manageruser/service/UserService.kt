package br.com.manageruser.service

import br.com.manageruser.model.User
import br.com.manageruser.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(val userRepository: UserRepository) {

    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    fun getUser(id: Long): User {
        return userRepository.getById(id)
    }

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun updateUser() {

    }

    fun deleteUser(id: Long) {
        val userId = userRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
        userId.id?.let { userRepository.deleteById(it) }
    }

}