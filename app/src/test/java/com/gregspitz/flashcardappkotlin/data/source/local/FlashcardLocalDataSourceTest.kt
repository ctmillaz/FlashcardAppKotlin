/*
 * Copyright (C) 2018 Greg Spitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gregspitz.flashcardappkotlin.data.source.local

import com.gregspitz.flashcardappkotlin.TestData.FLASHCARD_1
import com.gregspitz.flashcardappkotlin.TestData.FLASHCARD_LIST
import com.gregspitz.flashcardappkotlin.data.source.FlashcardDataSource
import com.nhaarman.mockito_kotlin.*
import org.junit.Test

/**
 * Tests for {@link FlashcardLocalDataSource}
 */
class FlashcardLocalDataSourceTest {

    private val mockFlashcardDao: FlashcardDao = mock()

    private val flashcardLocalDataSource = FlashcardLocalDataSource(mockFlashcardDao)

    @Test
    fun `on get flashcards, gets flashcards from flashcard dao and passes them to callback`() {
        whenever(mockFlashcardDao.getFlashcards()).thenReturn(FLASHCARD_LIST)
        val getFlashcardsCallback: FlashcardDataSource.GetFlashcardsCallback = mock()
        flashcardLocalDataSource.getFlashcards(getFlashcardsCallback)
        verify(getFlashcardsCallback).onFlashcardsLoaded(eq(FLASHCARD_LIST))
    }

    @Test
    fun `on get flashcard with available flashcard, gets from dao and passes to callback`() {
        whenever(mockFlashcardDao.getFlashcard(eq(FLASHCARD_1.id))).thenReturn(FLASHCARD_1)
        val getFlashcardCallback: FlashcardDataSource.GetFlashcardCallback = mock()
        flashcardLocalDataSource.getFlashcard(FLASHCARD_1.id, getFlashcardCallback)
        verify(getFlashcardCallback).onFlashcardLoaded(eq(FLASHCARD_1))
    }

    @Test
    fun `on get flashcard with unavailable flashcard, calls data not available on callback`() {
        whenever(mockFlashcardDao.getFlashcard(FLASHCARD_1.id)).thenReturn(null)
        val getFlashcardCallback: FlashcardDataSource.GetFlashcardCallback = mock()
        flashcardLocalDataSource.getFlashcard(FLASHCARD_1.id, getFlashcardCallback)
        verify(getFlashcardCallback).onDataNotAvailable()
    }

    @Test
    fun `on save flashcard, inserts flashcard into dao and calls save successful on callback`() {
        val saveFlashcardCallback: FlashcardDataSource.SaveFlashcardCallback = mock()
        flashcardLocalDataSource.saveFlashcard(FLASHCARD_1, saveFlashcardCallback)
        verify(mockFlashcardDao).insertFlashcard(eq(FLASHCARD_1))
        verify(saveFlashcardCallback).onSaveSuccessful()
    }

    @Test
    fun `on save flashcards, inserts flashcards into dao and calls save successful on callback`() {
        val saveFlaschardsCallback: FlashcardDataSource.SaveFlashcardsCallback = mock()
        val flashcardList = listOf(FLASHCARD_1)
        flashcardLocalDataSource.saveFlashcards(flashcardList, saveFlaschardsCallback)
        verify(mockFlashcardDao).insertFlashcards(eq(flashcardList))
        verify(saveFlaschardsCallback).onSaveSuccessful()
    }

    @Test
    fun `on delete flashcard, deletes single flashcard from dao`() {
        val deleteFlashcardCallback: FlashcardDataSource.DeleteFlashcardCallback = mock()
        flashcardLocalDataSource.deleteFlashcard(FLASHCARD_1.id, deleteFlashcardCallback)
        verify(mockFlashcardDao).deleteFlashcard(eq(FLASHCARD_1.id))
        verify(deleteFlashcardCallback).onDeleteSuccessful()
    }

    @Test
    fun `on delete all flashcards, deletes all flashcards from dao`() {
        flashcardLocalDataSource.deleteAllFlashcards()
        verify(mockFlashcardDao).deleteFlashcards()
    }

    @Test
    fun refreshFlashcards_doesNothing() {
        flashcardLocalDataSource.refreshFlashcards()
        verifyZeroInteractions(mockFlashcardDao)
    }
}
