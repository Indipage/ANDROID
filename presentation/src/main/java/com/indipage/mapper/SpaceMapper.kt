package com.indipage.mapper

import com.indipage.domain.model.Space
import com.indipage.model.SpaceModel

fun List<Space>.toSpaceModelEntity(): List<SpaceModel> = map {
    SpaceModel(
        id = it.id,
        name = it.name,
        imageUrl = it.imageUrl,
        roadAddress = it.roadAddress
    )
}
