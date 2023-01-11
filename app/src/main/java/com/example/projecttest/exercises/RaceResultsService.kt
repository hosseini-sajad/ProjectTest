package com.example.projecttest

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
