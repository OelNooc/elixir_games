package cl.nooc.elixirgames.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Games")
data class GamesItem(
    @ColumnInfo(name = "bc_image")
    val background_image: String,
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "metacritic")
    val metacritic: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "rating")
    val rating: Double,
    @ColumnInfo(name = "released")
    val released: String
)