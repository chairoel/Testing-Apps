package com.idcamp.testingapps.unittest.junit

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito.mock

class MyUnitTestViewModelTest {

    private lateinit var viewModel: MyUnitTestViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    @Before
    fun before() {
        cuboidModel = mock(CuboidModel::class.java)
        viewModel = MyUnitTestViewModel(cuboidModel)
    }

    /**
     * JUnit
     */
    @Test
    fun testVolume() {
        cuboidModel = CuboidModel()
        viewModel = MyUnitTestViewModel(cuboidModel)
        viewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = viewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    /**
     * JUnit
     */
    @Test
    fun testCircumference() {
        cuboidModel = CuboidModel()
        viewModel = MyUnitTestViewModel(cuboidModel)
        viewModel.save(dummyWidth, dummyLength, dummyHeight)
        val circumference = viewModel.getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    /**
     * JUnit
     */
    @Test
    fun testSurfaceArea() {
        cuboidModel = CuboidModel()
        viewModel = MyUnitTestViewModel(cuboidModel)
        viewModel.save(dummyWidth, dummyLength, dummyHeight)
        val surfaceArea = viewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

}