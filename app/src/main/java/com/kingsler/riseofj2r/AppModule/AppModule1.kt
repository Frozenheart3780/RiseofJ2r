package com.kingsler.riseofj2r.di

import Dao1
import android.content.Context
import androidx.room.Room
import com.kingsler.riseofj2r.data.local.Database1
import com.kingsler.riseofj2r.repository.InstructionRepository2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule1 {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): Database1 {
        return Room.databaseBuilder(
            context.applicationContext,
            Database1::class.java,
            "racing_game_db"
        ).build()
    }

    @Provides
    fun provideInstructionDao(db: Database1): Dao1 = db.instructionDao()

    @Provides
    fun provideInstructionRepository(dao: Dao1): InstructionRepository2 =
        InstructionRepository2(dao)
}
