package com.indipage.presentation.model

import com.indipage.domain.entity.Card
data class CardModel (
    val cardId :Long,
    val imageUrl:String,
    val visitedAt:String,
    val spaceId:String,
)
fun Card.toCardModelEntity()= CardModel(
    cardId, imageUrl, visitedAt, spaceId
)