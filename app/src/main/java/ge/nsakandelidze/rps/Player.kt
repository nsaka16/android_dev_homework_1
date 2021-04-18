package ge.nsakandelidze.rps

class Player(var name: String) {
    var score: Long = 0

    fun increaseScoreBy(increment: Long) {
        this.score += increment
    }

    fun incrementScoreByOne() {
        increaseScoreBy(1)
    }
}