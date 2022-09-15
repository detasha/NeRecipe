package ru.netology.nerecipe.adapter

import ru.netology.nerecipe.dto.Step

interface StepInteractionListener {

    fun onRemoveStepClicked(step: Step)

    fun onEditStepClicked(step: Step)

}