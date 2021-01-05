package com.rohitthebest.paging_30.di

import android.content.Context
import androidx.room.Room
import com.rohitthebest.paging_30.roomDB.db.EmployeeDatabase
import com.rohitthebest.paging_30.util.Constants.EMPLOYEE_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object Module {


    @Provides
    @Singleton
    fun provideEmployeeDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        EmployeeDatabase::class.java,
        EMPLOYEE_DATABASE
    ).build()

    @Provides
    @Singleton
    fun providesEmployeeDao(
        db: EmployeeDatabase
    ) = db.getEmployeeDao()
}