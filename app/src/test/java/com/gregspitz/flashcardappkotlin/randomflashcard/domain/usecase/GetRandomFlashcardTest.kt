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

package com.gregspitz.flashcardappkotlin.randomflashcard.domain.usecase

import com.gregspitz.flashcardappkotlin.TestData.FLASHCARD_1
import com.gregspitz.flashcardappkotlin.TestData.FLASHCARD_2
import com.gregspitz.flashcardappkotlin.TestData.FLASHCARD_LIST
import com.gregspitz.flashcardappkotlin.TestData.FLASHCARD_LIST_SAME_IDS
import com.gregspitz.flashcardappkotlin.TestData.SINGLE_FLASHCARD_LIST
import com.gregspitz.flashcardappkotlin.TestUseCaseScheduler
import com.gregspitz.flashcardappkotlin.UseCase
import com.gregspitz.flashcardappkotlin.UseCaseHandler
import com.gregspitz.flashcardappkotlin.data.source.FlashcardDataSource
import com.gregspitz.flashcardappkotlin.data.source.FlashcardRepository
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Tests for {@link GetRandomFlashcard}
 */
class GetRandomFlashcardTest {

    private val flashcardRepository: FlashcardRepository = mock()

    private val useCaseHandler = UseCaseHandler(TestUseCaseScheduler())

    private val repositoryCallbackCaptor =
            argumentCaptor<FlashcardDataSource.GetFlashcardsCallback>()

    private val callback: UseCase.UseCaseCallback<GetRandomFlashcard.ResponseValue> = mock()

    private val responseCaptor = argumentCaptor<GetRandomFlashcard.ResponseValue>()

    private lateinit var getRandomFlashcards: GetRandomFlashcard

    @Before
    fun setup() {
        getRandomFlashcards = GetRandomFlashcard(flashcardRepository)
    }

    @Test
    fun `when only one flashcard and null previous flashcard, gets flashcard and calls success on callback`() {
        // Request value represents the previous Flashcard
        // In this null case, there was no previous Flashcard
        val values = GetRandomFlashcard.RequestValues(null)
        useCaseHandler.execute(getRandomFlashcards, values, callback)
        verify(flashcardRepository).getFlashcards(repositoryCallbackCaptor.capture())
        repositoryCallbackCaptor.firstValue.onFlashcardsLoaded(SINGLE_FLASHCARD_LIST)
        verify(callback).onSuccess(responseCaptor.capture())
        assertEquals(FLASHCARD_1, responseCaptor.firstValue.flashcard)
    }

    @Test
    fun `when only one flashcard and same previous flashcard, gets flashcard and calls success on callback`() {
        // This test is to make sure it doesn't run into an infinite loop of trying to find
        // a different Flashcard from the previous one when there is only one to be had.
        val values = GetRandomFlashcard.RequestValues(FLASHCARD_1.id)
        useCaseHandler.execute(getRandomFlashcards, values, callback)
        verify(flashcardRepository).getFlashcards(repositoryCallbackCaptor.capture())
        repositoryCallbackCaptor.firstValue.onFlashcardsLoaded(SINGLE_FLASHCARD_LIST)
        verify(callback).onSuccess(responseCaptor.capture())
        assertEquals(FLASHCARD_1, responseCaptor.firstValue.flashcard)
    }

    @Test
    fun `when all flashcards have same id, gets first flashcard in list and calls success on callback`() {
        val values = GetRandomFlashcard.RequestValues(FLASHCARD_1.id)
        useCaseHandler.execute(getRandomFlashcards, values, callback)
        verify(flashcardRepository).getFlashcards(repositoryCallbackCaptor.capture())
        repositoryCallbackCaptor.firstValue.onFlashcardsLoaded(FLASHCARD_LIST_SAME_IDS)
        verify(callback).onSuccess(responseCaptor.capture())
        assertEquals(FLASHCARD_1, responseCaptor.firstValue.flashcard)
    }

    @Test
    fun `gets flashcard different from previous and calls success on callback`() {
        // The id of the previous Flashcard
        val values = GetRandomFlashcard.RequestValues(FLASHCARD_1.id)
        useCaseHandler.execute(getRandomFlashcards, values, callback)
        verify(flashcardRepository).getFlashcards(repositoryCallbackCaptor.capture())
        repositoryCallbackCaptor.firstValue.onFlashcardsLoaded(FLASHCARD_LIST)
        verify(callback).onSuccess(responseCaptor.capture())
        assertEquals(FLASHCARD_2, responseCaptor.firstValue.flashcard)
    }

    @Test
    fun `when data not available, calls failure on callback`() {
        val values = GetRandomFlashcard.RequestValues(null)
        useCaseHandler.execute(getRandomFlashcards, values, callback)
        verify(flashcardRepository).getFlashcards(repositoryCallbackCaptor.capture())
        repositoryCallbackCaptor.firstValue.onDataNotAvailable()
        verify(callback).onError()
    }

    @Test
    fun `when no flashcards from repository, calls failure on callback`() {
        val values = GetRandomFlashcard.RequestValues(null)
        useCaseHandler.execute(getRandomFlashcards, values, callback)
        verify(flashcardRepository).getFlashcards(repositoryCallbackCaptor.capture())
        // Repository replies with empty list
        repositoryCallbackCaptor.firstValue.onFlashcardsLoaded(listOf())
        verify(callback).onError()
    }
}
