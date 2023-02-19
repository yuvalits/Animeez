package com.animeez.models.magazines

data class MagazinesResponse(
    val magazines: List<Magazine>,
    val links: Links,
    val meta: Meta,
    val pagination: Pagination
)