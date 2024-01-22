package com.edwardcheng.littlelemon.presentation.viewmodel

import com.edwardcheng.littlelemon.domain.usecase.GetUserDataUseCase
import com.edwardcheng.littlelemon.domain.usecase.SetIsLoggedUseCase
import com.edwardcheng.littlelemon.presentation.mapper.toPresentation
import com.edwardcheng.littlelemon.presentation.screens.profile.ProfileUiAction
import com.edwardcheng.littlelemon.presentation.screens.profile.ProfileUiState
import com.edwardcheng.littlelemon.presentation.screens.profile.ProfileVMEvent
import com.edwardcheng.littlelemon.presentation.screens.profile.ProfileViewModel
import com.edwardcheng.littlelemon.testhelpers.stubs.getUserEntity
import com.edwardcheng.littlelemon.testhelpers.testrule.MainDispatcherRule
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProfileViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: ProfileViewModel
    private val setIsLoggedUseCase = mockk<SetIsLoggedUseCase>(relaxed = true)
    private val getUserDataUseCase = mockk<GetUserDataUseCase>()

    @Before
    fun setupViewModel() {
        every { getUserDataUseCase() } returns getUserEntity()
        viewModel = ProfileViewModel(
            setIsLoggedUseCase = setIsLoggedUseCase,
            getUserDataUseCase = getUserDataUseCase,
        )
    }

    @Test
    fun `WHEN init THEN assert uiState updates with userInfo`() {
        // GIVEN
        val expectedState = ProfileUiState(
            userInfoList = getUserEntity().toPresentation()
        )

        // THEN
        verify { getUserDataUseCase.invoke() }
        assertEquals(expectedState, viewModel.uiState.value)
    }

    @Test
    fun `WHEN handle ClickLogoutButton uiAction THEN assert uiState updates with NavigateBack event`() {
        // GIVEN
        val expectedState = ProfileUiState(
            userInfoList = getUserEntity().toPresentation(),
            profileEvent = ProfileVMEvent.NavigateBack
        )

        // WHEN
        viewModel.handleViewAction(ProfileUiAction.ClickBackButton)

        // THEN
        assertEquals(expectedState, viewModel.uiState.value)
    }

    @Test
    fun `WHEN handle ClickLogoutButton uiAction THEN assert uiState updates with NavigateToLogin event`() {
        // GIVEN
        val expectedState = ProfileUiState(
            userInfoList = getUserEntity().toPresentation(),
            profileEvent = ProfileVMEvent.NavigateToLogin
        )

        // WHEN
        viewModel.handleViewAction(ProfileUiAction.ClickLogoutButton)

        // THEN
        assertEquals(expectedState, viewModel.uiState.value)
    }

    @Test
    fun `WHEN handle ClickLogoutButton uiAction THEN assert setIsLoggedUseCase is invoked`() {
        // WHEN
        viewModel.handleViewAction(ProfileUiAction.ClickLogoutButton)

        // THEN
        verify { setIsLoggedUseCase.invoke(isLogged = false) }
    }
}