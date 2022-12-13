package cristian.app.appquiz.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import cristian.app.appquiz.model.DadosPerguntas
import cristian.app.appquiz.model.Pergunta
import cristian.app.appquiz.databinding.ActivityPerguntasBinding

class PerguntasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPerguntasBinding
    private lateinit var listaPerguntas: List<Pergunta>

    private var indicePerguntaAtual = 0
    private var totalAcertos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerguntasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recuperarNomeUsuario()
        listaPerguntas = DadosPerguntas.recuperarListaPerguntas()
        mostrarPergunta()

        binding.btnConfirmar.setOnClickListener {

            if (validarResposta()) {
                val tamanhoListaPerguntas = listaPerguntas.size

                exibirRespostaSelecionada()

                indicePerguntaAtual++
                if (indicePerguntaAtual < tamanhoListaPerguntas) {
                    mostrarPergunta()
                } else {
                    val intent = Intent(this, ResultadoActivity::class.java)
                    intent.putExtra("totalAcertos", totalAcertos)
                    intent.putExtra("totalPerguntas", listaPerguntas.size)
                    startActivity(intent)
                    finish()
                }
            } else {
                Toast.makeText(this,
                    "Preecha uma opção",
                    Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun exibirRespostaSelecionada() {
        val indiceResposta = when {
            binding.radioResposta1.isChecked -> 1
            binding.radioResposta2.isChecked -> 2
            binding.radioResposta3.isChecked -> 3
            else -> -1
        }

        val pergunta = listaPerguntas[indicePerguntaAtual]

        if (indiceResposta == pergunta.respostaCerta) {
            totalAcertos++
            Toast.makeText(this,
                "Você acertou a pergunta: ${pergunta.titulo}",
                Toast.LENGTH_LONG)
                .show()
        } else {
            Toast.makeText(this,
                "Você errou a pergunta",
                Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun validarResposta(): Boolean {
        return (binding.radioResposta1.isChecked ||
                binding.radioResposta2.isChecked ||
                binding.radioResposta3.isChecked)
    }

    private fun mostrarPergunta() {
        val pergunta = listaPerguntas[indicePerguntaAtual]
        binding.textTituloPergunta.text = pergunta.titulo
        binding.radioResposta1.text = pergunta.resposta01
        binding.radioResposta2.text = pergunta.resposta02
        binding.radioResposta3.text = pergunta.resposta03

        binding.textNumeroPergunta.text = "${indicePerguntaAtual + 1} pergunta de ${listaPerguntas.size}"

        binding.radioGroupRespostas.clearCheck()
    }

    private fun recuperarNomeUsuario() {
        val bundle = intent.extras
        val nome = bundle?.getString("nome") ?: ""
        binding.textNome.text = "Olá $nome"
    }

}