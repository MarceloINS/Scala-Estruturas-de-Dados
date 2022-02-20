class No:

  var _proximo: No = null
  var _valor = 0

  def valor_= (newValor: Int) = _valor = newValor
  def valor = _valor

  def proximo_= (newProximo: No) = _proximo = newProximo
  def proximo = _proximo