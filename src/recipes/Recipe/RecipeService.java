package recipes.Recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Optional<Recipe> findRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public List<Recipe> findByCategory(String category) {
        return recipeRepository.findAllByCategoryIgnoreCaseOrderByDateDesc(category);
    }

    public List<Recipe> findByName(String name) {
        return recipeRepository.findAllByNameContainingIgnoreCaseOrderByDateDesc(name);
    }

    public void updateRecipe(long id, Recipe newRecipe) {
        Optional<Recipe> recipe = findRecipeById(id);

        recipe.get().setName(newRecipe.getName());
        recipe.get().setCategory(newRecipe.getCategory());
        recipe.get().setDate(LocalDateTime.now());
        recipe.get().setDescription(newRecipe.getDescription());
        recipe.get().setIngredients(newRecipe.getIngredients());
        recipe.get().setDirections(newRecipe.getDirections());

        saveRecipe(recipe.get());
    }




}
