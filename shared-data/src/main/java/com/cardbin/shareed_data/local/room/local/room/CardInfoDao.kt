package com.cardbin.shareed_data.local.room.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CardInfoDao {

    @Query("SELECT * FROM cards")
    fun getCardInfoList(): Flow<List<CardInfoEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: CardInfoEntity)

}