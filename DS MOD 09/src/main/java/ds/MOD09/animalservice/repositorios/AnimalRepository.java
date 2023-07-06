package ds.MOD09.animalservice.repositorios;

import ds.MOD09.animalservice.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    @Query("SELECT a from Animal a WHERE a.dataSaida IS NULL ORDER BY a.dataEntrada")
    List<Animal> FindNotAdoptedAnimals();

    @Query("SELECT a from Animal a WHERE a.dataSaida IS NOT NULL")
    List<Animal> FindAdoptedAnimals();

    @Query("SELECT a FROM Animal a WHERE a.dataSaida IS NULL AND a.especie = 'cachorro'")
    List<Animal> FindNotAdoptedDog();

    @Query("SELECT a FROM Animal a WHERE a.dataSaida IS NOT NULL AND a.especie = 'cachorro'")
    List<Animal> FindAdoptedDog();

    @Query("SELECT a FROM Animal a WHERE a.dataSaida IS NULL AND a.especie = 'gato'")
    List<Animal> FindNotAdoptedCat();


    @Query("SELECT a FROM Animal a WHERE a.dataSaida IS NOT NULL AND a.especie = 'gato'")
    List<Animal> FindAdoptedCat();

    @Query("SELECT a.nomeRecebedor, COUNT(*) as quantidadeAnimais FROM Animal a GROUP BY a.nomeRecebedor")
    List<String> FindEmployees();
}
