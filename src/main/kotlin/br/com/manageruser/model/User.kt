package br.com.manageruser.model

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_seq")
    var id: Long? = null,
    @NotEmpty
    val firstName: String,
    @NotEmpty
    val lastName: String,
    @NotEmpty
    val username: String,
    @NotEmpty
    val email: String,
    @NotEmpty
    val phone: String)