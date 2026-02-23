package com.discphy.domain

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.time.ZonedDateTime

@MappedSuperclass
abstract class BaseEntity {
    @Column(name = "created_at", nullable = false, updatable = false)
    lateinit var createdAt: ZonedDateTime
        protected set

    @Column(name = "updated_at", nullable = false)
    lateinit var updatedAt: ZonedDateTime
        protected set

    @Column(name = "deleted_at")
    var deletedAt: ZonedDateTime? = null
        protected set

    open fun guard() = Unit

    @PrePersist
    private fun prePersist() {
        guard()
        val now = ZonedDateTime.now()
        createdAt = now
        updatedAt = now
    }

    @PreUpdate
    private fun preUpdate() {
        guard()
        updatedAt = ZonedDateTime.now()
    }

    fun delete() {
        deletedAt ?: run { deletedAt = ZonedDateTime.now() }
    }

    fun restore() {
        deletedAt?.let { deletedAt = null }
    }
}
