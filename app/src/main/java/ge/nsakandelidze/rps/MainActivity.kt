package ge.nsakandelidze.rps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    enum class Choice(var id: Int) {
        ROCK(R.id.rock),
        PAPER(R.id.paper),
        SCISSORS(R.id.scissors)
    }

    val player: Player = Player("Me")

    val computer: Player = Player("Computer")

    val listOfChoices: Array<Choice> =
        arrayOf(Choice.PAPER, Choice.SCISSORS, Choice.ROCK)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpListeners()

    }

    private fun setUpListeners() {
        for (item in listOfChoices) {
            val rollButton: Button = findViewById(item.id);
            rollButton.setOnClickListener { e ->
                val playersChoiceId = e.id
                val computersChoiceId = getComputersChoiceId()
                val playersImageChoice: Int = getImageResourceAccordingToInputId(playersChoiceId)
                val computersImageChoice: Int =
                    getImageResourceAccordingToInputId(computersChoiceId)
                updateScore(playersChoiceId, computersChoiceId)
                findViewById<ImageView>(R.id.playersChoiceImage)
                    .setImageResource(playersImageChoice)
                findViewById<ImageView>(R.id.computersChoiceImage)
                    .setImageResource(computersImageChoice)
            }
        }
    }


    private fun getImageResourceAccordingToInputId(id: Int): Int {
        var imageResource1 = -1
        when (id) {
            R.id.paper -> imageResource1 = R.drawable.paper
            R.id.rock -> imageResource1 = R.drawable.rock
            R.id.scissors -> imageResource1 = R.drawable.scissors
        }
        return imageResource1
    }

    private fun getComputersChoiceId(): Int {
        val nextInt = Random.nextInt(0, 3)
        return listOfChoices[nextInt].id
    }

    private fun updateScore(playersChoice: Int, computersChoice: Int) {
        if (playersChoice == computersChoice) {
            return
        } else if ((playersChoice == R.id.paper && computersChoice == R.id.scissors)
            || (playersChoice == R.id.scissors && computersChoice == R.id.rock)
            || (playersChoice == R.id.rock && computersChoice == R.id.paper)
        ) {
            incrementComputersScore()
        } else if ((computersChoice == R.id.paper && playersChoice == R.id.scissors)
            || (computersChoice == R.id.scissors && playersChoice == R.id.rock)
            || (computersChoice == R.id.rock && playersChoice == R.id.paper)
        ) {
            incrementPlayersScore()
        }
    }

    private fun incrementPlayersScore() {
        player.incrementScoreByOne()
        val findViewById = findViewById<TextView>(R.id.players_score)
        findViewById.setText(player.score.toString())
    }

    private fun incrementComputersScore() {
        computer.incrementScoreByOne()
        val findViewById = findViewById<TextView>(R.id.computers_score)
        findViewById.setText(computer.score.toString())
    }
}


