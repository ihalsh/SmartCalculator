import kotlin.math.max

object PlayingField {
    object Size {
        var width = 0
            private set
        var height = 0
            private set

        fun changeSize(width: Int, height: Int) {
            this.width = max(0, width)
            this.height = max(0, height)
        }
    }
}