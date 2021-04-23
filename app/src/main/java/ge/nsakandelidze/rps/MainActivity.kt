package ge.nsakandelidze.rps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import java.util.*
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    val player: Player = Player("Me")

    val computer: Player = Player("Computer")

    var humanPlayersChoiceId = -1

    var listOfButtonVariants: Array<Int> =
        arrayOf(R.id.paper, R.id.scissors, R.id.rock)

    override fun onCreate(savedInstanceState: Bundle?) {
        listOfButtonVariants.forEach { buttonId ->
            val rollButton: Button = findViewById(buttonId);
            rollButton.setOnClickListener { e ->
                val id = e.id
                humanPlayersChoiceId = id
                var imageResource: Int = -1
                when (humanPlayersChoiceId) {
                    R.id.paper -> imageResource = R.drawable.paper
                    R.id.rock -> imageResource = R.drawable.rock
                    R.id.scissors -> imageResource = R.drawable.scissors
                }
                findViewById<ImageView>(R.id.human_choice_image)
                    .setImageResource(imageResource)
            }

        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun chooseComputerAnswer(): Int {
        return listOfButtonVariants[0]
    }
}
