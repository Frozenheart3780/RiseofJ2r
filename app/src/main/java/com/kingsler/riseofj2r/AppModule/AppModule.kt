package com.kingsler.riseofj2r.di

import android.content.Context
import androidx.room.Room
import com.kingsler.riseofj2r.data.local.Dao1
import com.kingsler.riseofj2r.data.local.Database1
import com.kingsler.riseofj2r.repository.InstructionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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
    fun provideInstructionRepository(dao: Dao1): InstructionRepository =
        InstructionRepository(dao)
}
