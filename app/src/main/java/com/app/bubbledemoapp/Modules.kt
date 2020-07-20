package com.app.bubbledemoapp

import com.app.bubbledemoapp.ui.mainmodule.MainViewModel
import com.app.bubbledemoapp.ShiftApplication.Companion.applicationContext
import com.app.bubbledemoapp.ui.mainmodule.bottomsheetmodule.BottomSheetViewModel
import com.app.bubbledemoapp.data.room.DatabaseHelper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module


fun injectFeature() = loadFeature

/**
 * Top-level lazy property used to load koin modules.
 * Code inside the lazy block is executed only once, no matter how many times the property is accessed.
 * Can be used later through activity & fragment in dynamic feature approach for the feature & its respective modules.
 * */
private val loadFeature by lazy {

    loadKoinModules(
        listOf(
            viewModelModule

        )
    )
}

private val viewModelModule: Module = module {
    viewModel {
        MainViewModel(application = get())
        BottomSheetViewModel(application = get())

    }



    factory { DatabaseHelper.getDatabase(applicationContext).interfaceDao() }

    single {

    }
}





