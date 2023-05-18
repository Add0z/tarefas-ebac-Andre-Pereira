import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> lista = List.of("Carol -f", "Bernardo -m", "Andre -m", "David -m", "Elena -f");
        Map<String, String> mapNome = new HashMap<>();

        for (String item : lista) {
            String[] partes = item.split("\\s-");
            mapNome.put(partes[0], partes[1]);
        }

//LAMBDA
        List<String> chavesComValorF = mapNome.entrySet().stream()
                .filter(entry -> entry.getValue().equals("f"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
//MODO DE GENTE NORMAL
        List Mnome = new ArrayList<>();
        for (int x = 0; x < lista.size(); x++){
            String[] partes2 = lista.get(x).split("\\s-");
            if (partes2[1].equals("m")){
                Mnome.add(partes2[0]);

            }
        }

        System.out.println("Lista Mulheres "+ chavesComValorF);
        System.out.println("Lista Homens "+ Mnome);

    }
}

/*.ENTRYSET()
*       entry set é um metodo que cria um seleção dentro do map
*
*
*   .map()
*       */
