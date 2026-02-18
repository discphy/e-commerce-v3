package com.discphy.domain.example

interface ExampleRepository {
    fun find(id: Long): ExampleModel?
}
