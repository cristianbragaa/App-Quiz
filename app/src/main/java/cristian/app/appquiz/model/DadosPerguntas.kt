package cristian.app.appquiz.model

class DadosPerguntas {

    companion object {
        fun recuperarListaPerguntas(): List<Pergunta> {
            val pergunta01 = Pergunta(
                "Qual foi a duração do primeiro video do youtube",
                "3 minutos", "1 minuto", "18 segundos",
                3
            )

            val pergunta02 = Pergunta(
                "Em média, quantas pesquisas totalmente novas são feitas no Google todo dia?",
                "450 milhões", "1 Bilhão", "280 milhões",
                1
            )

            val pergunta03 = Pergunta(
                "Qual foi a primeira rede social da história da internet?",
                "MySpace", "ClassMate", "Orkut",
                2
            )

            val pergunta04 = Pergunta(
                "Quantos Bits cabem em um Byte",
                "1 bit", "4 bits", "8 bits",
                3
            )

            return listOf(
                pergunta01,
                pergunta02,
                pergunta03,
                pergunta04
            )
        }
    }

}