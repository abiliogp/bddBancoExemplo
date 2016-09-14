package BDDBanco;

import java.util.HashMap;
import java.util.Map;

public class FabricaDeCliente {

  public Map<String, String> criarCliente(String nomeDoCliente) {
    Map<String, String> dadosDoCliente = new HashMap<String, String>();
    dadosDoCliente.put("nome", nomeDoCliente);
    dadosDoCliente.put("rg", "1111111111");
    dadosDoCliente.put("cpf", "000.000.000-00");
    dadosDoCliente.put("endereco", "Kingsland");
    dadosDoCliente.put("profissao", "Compositor");

    return dadosDoCliente;
  }

}
