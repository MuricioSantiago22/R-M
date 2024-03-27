package com.example.rm.data.local.mapper

import com.example.rm.data.local.entities.CharacterEntity
import com.example.rm.domain.entities.Character

fun CharacterEntity.toDomain()= Character(
    id= this.id,
    name = this.name ,
    image = this.image
)