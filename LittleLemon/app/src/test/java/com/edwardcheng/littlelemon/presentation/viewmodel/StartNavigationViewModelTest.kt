package com.edwardcheng.littlelemon.presentation.viewmodel

import com.edwardcheng.littlelemon.domain.usecase.GetIsLoggedUseCase
import com.edwardcheng.littlelemon.presentation.navigation.LittleLemonDestination
import com.edwardcheng.littlelemon.presentation.navigation.StartNavigationUiState
import com.edwardcheng.littlelemon.presentation.navigation.StartNavigationViewModel
import com.edwardcheng.littlelemon.testhelpers.testrule.MainDispatcherRule
import io.mockk.every
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class StartNavigationViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: StartNavigationViewModel
    private val getIsLoggedUseCase = mockk<GetIsLoggedUseCase>()

    private fun setupViewModel() {
        viewModel = StartNavigationViewModel(getIsLoggedUseCase = getIsLoggedUseCase)
    }

    @Test
    fun `GIVEN getIsLoggedUseCase returns true WHEN init THEN assert uiState updates with HOME start destination`() {
        // GIVEN
        every { getIsLoggedUseCase() } returns true
        val expectedState = StartNavigationUiState(
            startDestination = LittleLemonDestination.HOME
        )

        // WHEN
        setupViewModel()

        // THEN
        assertEquals(expectedState, viewModel.uiState.value)
    }

    @Test
    fun `GIVEN getIsLoggedUseCase returns false WHEN init THEN assert uiState updates with LOGIN start destination`() {
        // GIVEN
        every { getIsLoggedUseCase() } returns false
        val expectedState = StartNavigationUiState(
            startDestination = LittleLemonDestination.LOGIN
        )

        // WHEN
        setupViewModel()

        // THEN
        assertEquals(expectedState, viewModel.uiState.value)
    }
}