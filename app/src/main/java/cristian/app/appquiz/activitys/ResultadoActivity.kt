package cristian.app.appquiz.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import cristian.app.appquiz.R
import cristian.app.appquiz.databinding.ActivityPerguntasBinding
import cristian.app.appquiz.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val totalAcertos = bundle?.getInt("totalAcertos") ?: 0
        val totalPerguntas = bundle?.getInt("totalPerguntas") ?: 0

        binding.textResultado.text = "Você acertou $totalAcertos de $totalPerguntas"
        reiniciarQuiz()
    }

    private fun reiniciarQuiz() {
        binding.btnReiniciar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}