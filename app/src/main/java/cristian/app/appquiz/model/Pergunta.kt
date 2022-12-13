package cristian.app.appquiz.model

data class Pergunta(
    var titulo: String,
    var resposta01: String,
    var resposta02: String,
    var resposta03: String,
    var respostaCerta: Int
)