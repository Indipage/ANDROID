package com.indipage.ui.model

import com.indipage.domain.model.Card


data class CardModel (
    val cardId :Long,
    val imageUrl:String,
    val visitedAt:String,
    val spaceId:Int,
)
fun Card.toCardModelEntity()= CardModel(
    cardId, imageUrl, visitedAt, spaceId
)