class No:

  var _proximo: Option[No] = None
  var _valor = 0

  def valor_= (newValor: Int) = _valor = newValor
  def valor = _valor

  def proximo_= (newProximo: Option[No]) = _proximo = newProximo
  def proximo = _proximo