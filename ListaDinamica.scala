class ListaDinamica:
  var _primeiro: No = null
  var _ultimo: No = null

  def primeiro_= (newPrimeiro: No) = _primeiro = newPrimeiro
  def primeiro = _primeiro

  def ultimo_= (newUltimo: No) = _ultimo = newUltimo
  def ultimo = _ultimo

  def adicionarFinal(newValor: Int) =
    var novo = new No
    novo.valor_=(newValor)
    if primeiro == null then
      primeiro_=(novo)
      ultimo_=(novo)
    else
      ultimo.proximo_=(novo)
      ultimo_=(novo)

  def adicionarInicio(newValor: Int) =
    var novo = new No
    novo.valor_=(newValor)
    if primeiro == null then
      primeiro_=(novo)
      ultimo_=(novo)
    else
      novo.proximo_=(primeiro)
      primeiro_=(novo)

  def removerFinal =
    if ultimo !=  null then
      if(primeiro == ultimo) then
        primeiro_=(null)
        ultimo_=(null)
      else
        var atual = primeiro
        while atual.proximo != ultimo do atual = (atual.proximo)
        ultimo_=(atual)
        ultimo.proximo_=(null)

  def removerInicio =
    if primeiro !=  null then
      if(primeiro == ultimo) then
        primeiro_=(null)
        ultimo_=(null)
      else
        primeiro_=(primeiro.proximo)

  def exibir =
    var atual = primeiro
    while atual != null do
      print(s"${atual.valor} ")
      atual = atual.proximo