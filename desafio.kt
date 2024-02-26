enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario (val cpf: String, val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    var inscritos = mutableListOf<Usuario>()
    var inscritosLeitura: List<Usuario> = inscritos
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun imprimir(){
            println("Usuários matriculados no curso de $nome: \n" + 
                    inscritosLeitura.joinToString(separator = "\n") { usuario -> usuario.nome }                           )
        
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
    
    
    val aluno1 = Usuario("1", "Nome do aluno", "Nome@email.com")
    val aluno2 = Usuario("2", "Teste", "teste@testmail.com.br")
    val aluno3 = Usuario("3", "Teste três", "testetrs@tresmails.com")
    
    formacaoCobol.matricular(aluno1)
    formacaoCobol.matricular(aluno2)
    formacaoCobol.matricular(aluno3)
    formacaoKotlin.matricular(aluno1)
    formacaoKotlin.matricular(aluno3)

    formacaoCobol.imprimir()
    formacaoKotlin.imprimir()
      
}


