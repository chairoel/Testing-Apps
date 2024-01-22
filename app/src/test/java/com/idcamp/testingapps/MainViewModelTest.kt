package com.idcamp.testingapps

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    private lateinit var cuboidModel: CuboidModel

    private val dummyLength = 12.0
    private val dummyWidth = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    @Before
    fun before() {
        cuboidModel = Mockito.mock(CuboidModel::class.java)
        viewModel = MainViewModel(cuboidModel)
    }

    /**
     * JUnit
     */
    @Test
    fun testVolume() {
        cuboidModel = CuboidModel()
        viewModel = MainViewModel(cuboidModel)
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
        viewModel = MainViewModel(cuboidModel)
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
        viewModel = MainViewModel(cuboidModel)
        viewModel.save(dummyWidth, dummyLength, dummyHeight)
        val surfaceArea = viewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    /**
     * Mock
     */
    @Test
    fun testMockVolume() {
        Mockito.`when`(viewModel.getVolume()).thenReturn(dummyVolume)
        val volume = viewModel.getVolume()
        Mockito.verify(cuboidModel).getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    /**
     * Mock
     */
    @Test
    fun testMockCircumference() {
        Mockito.`when`(viewModel.getCircumference()).thenReturn(dummyCircumference)
        val circumference = viewModel.getCircumference()
        Mockito.verify(cuboidModel).getCircumference()
        assertEquals(dummyCircumference, circumference, 0.0001)
    }

    /**
     * Mock
     */
    @Test
    fun testMockSurfaceArea() {
        Mockito.`when`(viewModel.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val surfaceArea = viewModel.getSurfaceArea()
        Mockito.verify(cuboidModel).getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }
}