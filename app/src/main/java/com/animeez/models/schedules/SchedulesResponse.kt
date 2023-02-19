package com.animeez.models.schedules

data class SchedulesResponse(
    val schedules: List<Schedule>,
    val pagination: Pagination
)