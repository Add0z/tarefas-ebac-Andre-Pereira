import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {

    public static List<String> chavesComValorF;
    public static List<String> chavesComValorM;

    
    public Streams(){
        List<String> lista = List.of("Carol -f", "Bernardo -m", "Andre -m", "David -m", "Elena -f");
        Map<String, String> mapNome = new HashMap<>();

        for (String item : lista) {
            String[] partes = item.split("\\s-");
            mapNome.put(partes[0], partes[1]);
        }
        chavesComValorF(mapNome);
        chavesComValorM(lista);
    }

    private void chavesComValorM(List<String> lista) {
        chavesComValorM = new ArrayList<>();
        for (int x = 0; x < lista.size(); x++) {
            String[] partes2 = lista.get(x).split("\\s-");
            if (partes2[1].equals("m")) {
                chavesComValorM.add(partes2[0]);
            }
        }
    }

    private void chavesComValorF(Map<String, String> mapNome) {
        chavesComValorF = mapNome.entrySet().stream()
                .filter(entry -> entry.getValue().equals("f"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> getChavesComValorF() {
        return chavesComValorF;
    }

    public static List<String> getChavesComValorM(){

        return chavesComValorM;
    }

    public static void main(String[] args) {


        var teste = new Streams();
        System.out.println("Lista Mulheres "+ teste.chavesComValorF);
        System.out.println(teste.chavesComValorF.getClass());
        System.out.println("Lista Homens "+ teste.chavesComValorM);
//        getChavesComValorF();
    }
}

/*.ENTRYSET()
*       entry set é um metodo que cria um seleção dentro do map
*
*
*   .map()
*       */
