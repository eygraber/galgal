package com.eygraber.galgal.app.di.android

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.eygraber.galgal.di.qualifiers.ActivityContext
import me.tatarka.inject.annotations.Provides

interface AndroidActivityModule {
  @Provides @ActivityContext fun provideContext(activity: Activity): Context = activity
  @Provides fun provideAppCompatActivity(activity: Activity): AppCompatActivity = activity as AppCompatActivity
}
