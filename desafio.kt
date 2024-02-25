enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario (val cpf: String, val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    var inscritos = mutableListOf<Usuario>()
    var inscritosLeitura: List<Usuario> = inscritos
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    
}


fun main() {
       val aulasKotlin = listOf(
        ConteudoEducacional("Olá Mundo", 10, Nivel.BASICO),
        ConteudoEducacional("Laços repetição", 15, Nivel.INTERMEDIARIO),
        ConteudoEducacional("H2", 90, Nivel.AVANCADO)

    )

    val aulasCobol = listOf(
        ConteudoEducacional("Declaração variáveis", 15, Nivel.BASICO),
        ConteudoEducacional("Laços repetição", 15, Nivel.INTERMEDIARIO),
        ConteudoEducacional("DB2", 2500, Nivel.AVANCADO)
    )
    
    val formacaoKotlin = Formacao("Kotlin", aulasKotlin)
    val formacaoCobol = Formacao("Cobol", aulasCobol)
    
    println(formacaoKotlin)
    println(formacaoCobol)
    
    
    val aluno1 = Usuario("1", "Nome", "Nome@email.com")
    val aluno2 = Usuario("2", "Teste", "teste@miarroba.com")
    
    formacaoCobol.matricular(aluno1)
    formacaoKotlin.matricular(aluno2)
    
     
}
