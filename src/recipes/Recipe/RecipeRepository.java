package recipes.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {


      void deleteById(Long id);

      List<Recipe> findAllByCategoryIgnoreCaseOrderByDateDesc(String category);

      List<Recipe> findAllByNameContainingIgnoreCaseOrderByDateDesc(String name);
}
