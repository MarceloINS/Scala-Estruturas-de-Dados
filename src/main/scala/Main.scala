@main def main =
  var lista = new ListaDinamica


  lista adicionarInicio(5)
  lista adicionarInicio(10)
  lista adicionarInicio(15)
  lista adicionarInicio(20)
  lista.adicionarInicio(25)
  lista.adicionarInicio(30)

  lista adicionarFinal(30)
  lista adicionarFinal(25)
  lista adicionarFinal(20)
  lista adicionarFinal(15)
  lista adicionarFinal(10)
  lista adicionarFinal(5)

  lista.removerFinal
  lista.removerInicio

  lista.exibir