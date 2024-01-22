package com.edwardcheng.littlelemon.presentation.mapper

import com.edwardcheng.littlelemon.testhelpers.stubs.getDomainMenuList
import com.edwardcheng.littlelemon.testhelpers.stubs.getPresentationMenuList
import org.junit.Assert
import org.junit.Test

class DomainToPresentationMapper {

    @Test
    fun `GIVEN domain model WHEN toPresentation is called THEN should return expected presentation model`() {
        // Given
        val menuDomainModel = getDomainMenuList()

        val expectedPresentationModel = getPresentationMenuList()

        // When
        val actualModel = menuDomainModel.toPresentation()

        // Then
        Assert.assertEquals(expectedPresentationModel, actualModel)
    }
}