package ru.netology.nerecipe.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.enableSavedStateHandles
import androidx.navigation.fragment.findNavController
import ru.netology.nerecipe.R
import ru.netology.nerecipe.R.id.*
import ru.netology.nerecipe.adapter.FiltersAdapter
import ru.netology.nerecipe.databinding.FilterFragmentBinding
import ru.netology.nerecipe.viewModel.RecipeViewModel

class FilterFragment : Fragment() {

    private val viewModel: RecipeViewModel by activityViewModels()

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FilterFragmentBinding.inflate(
        layoutInflater, container, false
    ).also { binding ->

        val categoriesList = resources.getStringArray(R.array.category_list).toMutableList()
        val adapterFilter = FiltersAdapter(viewModel)
        binding.filterRecycleView.adapter = adapterFilter

        adapterFilter.submitList(categoriesList)


        binding.selectFilter.setOnClickListener {
            if(viewModel.filters.value.isNullOrEmpty()){
                binding.attentionText.visibility = View.VISIBLE
                binding.selectFilter.isEnabled
            } else {
            findNavController().popBackStack()}
        }

    }.root
}