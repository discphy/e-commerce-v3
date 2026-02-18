package com.discphy.infrastructure.example

import com.discphy.domain.example.ExampleModel
import org.springframework.data.jpa.repository.JpaRepository

interface ExampleJpaRepository : JpaRepository<ExampleModel, Long>
