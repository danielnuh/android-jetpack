package com.e.session9mynoteapps.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.e.session9mynoteapps.database.Note
import com.e.session9mynoteapps.database.NoteRepository

class MainViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(sort: String): LiveData<PagedList<Note>> {
        return LivePagedListBuilder(mNoteRepository.getAllNotes(sort), 20).build()
    }
}