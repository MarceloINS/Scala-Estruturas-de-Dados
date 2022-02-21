import scala.annotation.tailrec

class ListaDinamica:
  var _primeiro: Option[No] = None
  var _ultimo: Option[No] = None

  def primeiro_= (newPrimeiro: Option[No]) = _primeiro = newPrimeiro
  def primeiro = _primeiro

  def ultimo_= (newUltimo: Option[No]) = _ultimo = newUltimo
  def ultimo = _ultimo

  def adicionarFinal(newValor: Int) =
    var novo = new No
    novo.valor = newValor

    primeiro match
      case Some(noPrime) =>
        ultimo.get.proximo = Some(novo)
        ultimo = Some(novo)
      case None =>
        primeiro = Some(novo)
        ultimo = Some(novo)

  def adicionarInicio(newValor: Int) =
    var novo = new No
    novo.valor_=(newValor)

    primeiro match
      case Some(noPrime) =>
        novo.proximo = primeiro
        primeiro = Some(novo)
      case None =>
        primeiro = Some(novo)
        ultimo = Some(novo)

  def removerFinal =
    ultimo foreach { no =>
      if primeiro == ultimo then
        primeiro = None
        ultimo = None
      else
        //TODO Eliminar uso de variável!
        var atual = primeiro
        while atual.isDefined && atual.get.proximo != ultimo do atual = (atual.get.proximo)
          ultimo_=(atual)
          ultimo.get.proximo = None
    }

  def removerInicio =
    primeiro foreach { prime =>
      if (primeiro == ultimo) then
        primeiro = None
        ultimo = None
      else
        primeiro = primeiro.get.proximo
    }

  def exibir =
    @tailrec
    def loop(noOpt: Option[No]): Unit =
      noOpt match
        case Some(no) =>
          print(s"${no.valor} ")
          loop(no.proximo)
        case None =>

    loop(primeiro)