package cl.nooc.elixirgames.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Games_Detail")
data class GameDetail(
    @ColumnInfo(name = "bc_img")
    val background_image: String,
    @ColumnInfo(name = "delivery")
    val delivery: Boolean,
    @ColumnInfo(name = "format")
    val format: String,
    @ColumnInfo(name = "genres")
    val genres: String,
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "last_price")
    val lastPrice: Int,
    @ColumnInfo(name = "metacritic")
    val metacritic: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "platforms")
    val platforms: String,
    @ColumnInfo(name = "playtime")
    val playtime: Int,
    @ColumnInfo(name = "price")
    val price: Int,
    @ColumnInfo(name = "rating")
    val rating: Double,
    @ColumnInfo(name = "released")
    val released: String
)