package com.edwardcheng.littlelemon.data.mapper

import com.edwardcheng.littlelemon.testhelpers.stubs.getLocalDataMenuList
import com.edwardcheng.littlelemon.testhelpers.stubs.getRemoteDataMenuList
import org.junit.Assert.assertEquals
import org.junit.Test

class RemoteToLocalDataMapperTest {

    @Test
    fun `GIVEN remote data model WHEN toLocalDataModel is called THEN should return expected local data model`() {
        // Given
        val remoteDataModel = getRemoteDataMenuList()
        val expectedLocalDataModel = getLocalDataMenuList()

        // When
        val actualModel = remoteDataModel.toLocalDataModel()

        // Then
        assertEquals(expectedLocalDataModel, actualModel)
    }
}