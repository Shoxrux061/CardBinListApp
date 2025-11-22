package com.cardbin.shareed_data.di

import android.content.Context
import androidx.room.Room
import com.cardbin.shareed_data.local.room.local.room.AppDatabase
import com.cardbin.shareed_data.local.room.local.room.CardInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            "card_info_history"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCardInfoDao(db: AppDatabase): CardInfoDao {
        return db.cardInfoDao()
    }

}