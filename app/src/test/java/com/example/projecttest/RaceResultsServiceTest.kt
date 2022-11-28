package com.example.projecttest

import org.junit.Test
import org.mockito.Mockito.*

class RaceResultsServiceTest {

    private val raceResults = RaceResultsService()
    private val clientA = mock(Client::class.java, "clientA")
    private val clientB = mock(Client::class.java, "clientB")
    private val message = mock(Message::class.java)

    @Test
    fun notSubscribedClientShouldNotReceiveMessage() {
        verify(clientA, never()).receive(message)
        verify(clientB, never()).receive(message)
    }

    @Test
    fun subscribedShouldReceiveMessage() {
        raceResults.addSubscriber(clientA)
        raceResults.send(message)

        verify(clientA).receive(message)
    }

    @Test
    fun messageShouldBeSentToAllSubscribedClients() {
        raceResults.addSubscriber(clientA)
        raceResults.addSubscriber(clientB)
        raceResults.send(message)

        verify(clientA).receive(message)
        verify(clientB).receive(message)
    }

    @Test
    fun shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResults.addSubscriber(clientA)
        raceResults.addSubscriber(clientA)
        raceResults.send(message)
        verify(clientA).receive(message)
    }

    @Test
    fun unsubscribedClientShouldNotReceiveMessages() {
        raceResults.addSubscriber(clientA)
        raceResults.removeSubscriber(clientA)

        raceResults.send(message)

        verify(clientA, never()).receive(message)
    }

}