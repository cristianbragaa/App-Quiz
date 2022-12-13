package cristian.app.appquiz.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import cristian.app.appquiz.R
import cristian.app.appquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enviarDadosProximaTela()
    }

    private fun enviarDadosProximaTela() {
        binding.btnIniciar.setOnClickListener {
            if (binding.editNome.text.isNotEmpty()) {
                val intent = Intent(this, PerguntasActivity::class.java)
                intent.putExtra("nome", binding.editNome.text.toString())
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this,
                    "Preencha o campo nome",
                    Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}
