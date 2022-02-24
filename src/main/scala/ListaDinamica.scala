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

  def adicionarFinal2(newValor: Int) =
    ultimo match
      case Some(no) =>
        no.proximo = Some(new No)
        ultimo = no.proximo
        no.valor = newValor
      case None =>
        primeiro = Some(new No)
        primeiro.get.valor = newValor
        ultimo = primeiro


  def adicionarInicio(newValor: Int) =
    var novo = new No
    novo.valor = newValor

    primeiro match
      case Some(noPrime) =>
        novo.proximo = primeiro
        primeiro = Some(novo)
      case None =>
        primeiro = Some(novo)
        ultimo = Some(novo)

  def removerFinal =
    if primeiro == ultimo then
      primeiro = None
      ultimo = None
    else
      @tailrec
      def loop(noOpt: Option[No]): Unit =
        noOpt.get.proximo.get.proximo match
          case Some(no) =>
            loop(noOpt.get.proximo)
          case None =>
            ultimo = noOpt
            ultimo.get.proximo = None
      loop(primeiro)

  def removerInicio =
      if (primeiro == ultimo) then
        primeiro = None
        ultimo = None
      else
        primeiro = primeiro.get.proximo

  def exibir =
    @tailrec
    def loop(noOpt: Option[No]): Unit =
      noOpt match
        case Some(no) =>
          print(s"${no.valor} ")
          loop(no.proximo)
        case None =>
          println("")

    loop(primeiro)

  def size =
    @tailrec
    def cont(noOpt: Option[No], x: Int = 0): Int =
      noOpt match
        case Some(no) =>
          cont(noOpt.get.proximo, x+1)
        case None =>
          x
    cont(primeiro)

  def removerPosicao(posicao: Int) =
    if posicao == 1 then primeiro = primeiro.get.proximo

    def loop(noOpt: Option[No], posicao: Int): Unit =
      noOpt match
        case Some(no) =>
          if posicao == 1 then
            no.proximo = noOpt.get.proximo.get.proximo
          else loop(no.proximo, posicao-1)
        case None =>
          println(s"Posição inválida")
    loop(primeiro, posicao-1)