package kz.kd.recipeapp.data.models

data class SearchResponse(
    val text: String,
    val parsed: List<Parsed>,
    val hints: List<Hint>,
    val _links: Link,
)