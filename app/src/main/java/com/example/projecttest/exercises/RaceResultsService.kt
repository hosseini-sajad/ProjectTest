package com.example.projecttest.exercises

import com.example.projecttest.Client
import com.example.projecttest.Message

class RaceResultsService {
    private var clients = HashSet<Client?>()
    fun addSubscriber(client: Client?) {
        clients.add(client)
    }

    fun send(message: Message?) {
        for (client in clients) {
            client?.receive(message)
        }
    }

    fun removeSubscriber(client: Client?) {
        clients.remove(client)
    }

}
