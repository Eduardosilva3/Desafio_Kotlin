enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(var nome: String, var email: String, var idade:Long)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun imprimirConteudo(){
        conteudos.stream().forEach { u -> println("Curso: ${u.nome} \nDuração: ${u.duracao}\nNivel: ${u.nivel}\n") }
    }

    fun imprimir(){
        inscritos.stream().forEach { u -> println("Aluno: "+ u.nome) }
    }
}

fun main() {
    val conteudoJava = ConteudoEducacional("Java",80, Nivel.BASICO)
    val conteudoAngular = ConteudoEducacional("ANGULAR",70, Nivel.BASICO)
    val conteudoKotlin = ConteudoEducacional("Java",40, Nivel.BASICO)

    val conteudos = mutableListOf<ConteudoEducacional>()
    conteudos.add(conteudoJava)
    conteudos.add(conteudoAngular)
    conteudos.add(conteudoKotlin)

    val formacaoFull = Formacao("FullStack", conteudos, Nivel.INTERMEDIARIO)

    val eduardo = Usuario("Eduardo", "eduardo@Dio.com", 25)
    val renato = Usuario("Renato", "Renato@Dio.com", 28)

    formacaoFull.matricular(eduardo)
    formacaoFull.matricular(renato)

    println("Formacao: ${formacaoFull.nome}")
    formacaoFull.imprimirConteudo()
    formacaoFull.imprimir()

}