package com.kingsler.riseofj2r.di

import Dao1
import com.kingsler.riseofj2r.data.local.AppDatabase
import com.kingsler.riseofj2r.repository.InstructionRepository2
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
    fun provideDao1(database: AppDatabase): Dao1 = database.dao1()

    @Provides
    @Singleton
    fun provideRepository(dao: Dao1): InstructionRepository2 = InstructionRepository2(dao)
}
