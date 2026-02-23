package estudos.playground;

import estudos.model.ContaBancaria;
import com.google.gson.Gson;

public class TesteJson {
    public static void main(String[] args) {
        // 1. Criamos o objeto normal
        ContaBancaria conta = new ContaBancaria("Gabriel", 5000);

        // 2. Criamos o Mágico do Gson
        Gson gson = new Gson();

        // 3. Transformamos Objeto -> JSON (Serialização)
        String json = gson.toJson(conta);

        System.out.println("Formato Java: " + conta);
        // Saída esperada: estudos.model.ContaBancaria@5a07e868 (ou seu toString)

        System.out.println("Formato JSON: " + json);
        // Saída esperada: {"titular":"Gabriel","saldo":5000.0}
    }
}
