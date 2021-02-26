import kotlin.random.Random

data class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        fun create(name: String) = Player(id = Random.nextInt(), name = name, hp = 100)
    }
}