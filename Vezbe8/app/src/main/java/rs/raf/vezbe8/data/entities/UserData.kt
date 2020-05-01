package rs.raf.vezbe8.data.entities

data class UserData(
    val id: Int,
    val name: String,
    val info: String
)

fun UserData.toUser(): User {
    return User(name)
}