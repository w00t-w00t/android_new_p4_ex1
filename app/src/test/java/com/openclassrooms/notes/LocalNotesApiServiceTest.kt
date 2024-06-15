package com.openclassrooms.notes

import com.openclassrooms.notes.data.Note
import com.openclassrooms.notes.service.LocalNotesApiService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LocalNotesApiServiceTest {

    private lateinit var localNotesApiService: LocalNotesApiService

    @Before
    fun setUp() {
        localNotesApiService = LocalNotesApiService()
    }

    @Test
    fun testGetAllNotes() {
        val notes = localNotesApiService.getAllNotes()
        assertEquals(10, notes.size)
    }

    @Test
    fun testAddNote() {
        val newNote = Note("New Note", "This is a new note.")
        localNotesApiService.addNote(newNote)
        val notes = localNotesApiService.getAllNotes()
        assertEquals(11, notes.size)
        assertEquals(newNote, notes.last())
    }

    @Test
    fun testGetAllNotesAfterAddNote() {
        val newNote = Note("New Note", "This is a new note.")
        localNotesApiService.addNote(newNote)
        val notes = localNotesApiService.getAllNotes()
        assertEquals(11, notes.size)
        assertEquals(newNote, notes.last())
        assertEquals("La vie est belle", notes[0].title)
        assertEquals("Le monde est un meilleur endroit lorsque nous travaillons ensemble. Aidez les autres, même si c'est juste un petit geste. Chaque geste compte.", notes[4].body)
    }
}