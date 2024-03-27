package com.example.rm.data.remote.mapper

import com.example.rm.data.local.entities.CharacterEntity
import com.example.rm.data.remote.entities.dto.CharacterDto

fun CharacterDto.toEntity()= CharacterEntity(
    id = this.id ?: 0,
    name= this.name ?: "",
    image= this.image ?:""
)