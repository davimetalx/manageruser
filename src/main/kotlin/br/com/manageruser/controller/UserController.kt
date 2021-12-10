package br.com.manageruser.controller

import br.com.manageruser.model.User
import br.com.manageruser.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.Objects.nonNull
import javax.validation.Valid

@Controller
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/users")
class UserController(val userService: UserService) {

    @GetMapping
    fun getUsers(): ResponseEntity<List<User>> {
        val users = userService.getUsers()
        return if (users.isNotEmpty()) ResponseEntity<List<User>>(users, HttpStatus.OK)
        else ResponseEntity.notFound().build()
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<User> {
        val user = userService.getUser(id)
        return if (nonNull(user)) ResponseEntity(user, HttpStatus.OK)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createUser(@RequestBody @Valid user: User): ResponseEntity<User> {
        val user1 = userService.createUser(user)
        return if (nonNull(user1)) ResponseEntity(user1, HttpStatus.CREATED)
        else ResponseEntity.badRequest().build()
    }

    @PutMapping("/{id}")
    fun updateUser() {

    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        userService.deleteUser(id)
        return ResponseEntity.ok().build()
    }

}