package org.multimodule.bank.event.publisher

import org.multimodule.bank.domain.event.DomainEvent
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

interface EventPublisher {
    fun publish(event: DomainEvent)
    fun publishAsync(event: DomainEvent)
    fun publishAll(events: List<DomainEvent>)
    fun publishAllAsync(events: List<DomainEvent>)
}

@Component
class EventPublisherImpl(
    private val eventPublisher: ApplicationEventPublisher
) : EventPublisher {

    private val log = LoggerFactory.getLogger(EventPublisherImpl::class.java)

    override fun publish(event: DomainEvent) {
        log.info("publishing event: ${event}")
        eventPublisher.publishEvent(event)
    }

    @Async("taskExecutor")
    override fun publishAsync(event: DomainEvent) {
        log.info("publishing event: ${event}")
        eventPublisher.publishEvent(event)
    }

    override fun publishAll(events: List<DomainEvent>) {
        events.forEach{event ->
            eventPublisher.publishEvent(event)
        }

    }

    @Async("taskExecutor")
    override fun publishAllAsync(events: List<DomainEvent>) {
        events.forEach{event ->
            eventPublisher.publishEvent(event)
        }
    }
}