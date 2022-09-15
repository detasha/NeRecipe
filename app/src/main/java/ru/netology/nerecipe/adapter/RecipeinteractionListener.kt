package ru.netology.nerecipe.adapter

import ru.netology.nerecipe.dto.Recipe

interface RecipeInteractionListener {

    fun onAddFavoriteClicked(recipe: Recipe)
    fun onRemoveClicked(recipe: Recipe)
    fun onEditClicked(recipe: Recipe)
    fun onRecipeClicked(recipe: Recipe)

}