package com.indipage.mapper

import com.indipage.domain.model.Card
import com.indipage.model.CardModel

fun List<Card>.toCardModelEntity(): List<CardModel> = map {
    CardModel(
        cardId = it.cardId,
        imageUrl = it.imageUrl,
        visitedAt = it.visitedAt,
        spaceId = it.spaceId
    )
}
