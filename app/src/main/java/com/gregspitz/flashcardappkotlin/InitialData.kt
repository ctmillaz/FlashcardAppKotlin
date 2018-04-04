package com.gregspitz.flashcardappkotlin

import com.gregspitz.flashcardappkotlin.data.model.Flashcard

/**
 * Initial data for the database
 */
object InitialData {
    val flashcards = listOf(Flashcard(front = "Abstract Factory", back = "Creational\nProvide an interface for creating families of related or dependent objects without specifying their concrete classes."),
            Flashcard(front = "Builder", back = "Creational\nSeparate the construction of a complex object from its representation, allowing the same construction process to create various representations."),
            Flashcard(front = "Dependency injection", back = "Creational\nA class accepts the objects it requires from an injector instead of creating the objects directly."),
            Flashcard(front = "Factory method", back = "Creational\nDefine an interface for creating a single object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses."),
            Flashcard(front = "Lazy initialization", back = "Creational\nTactic of delaying the creation of an object, the calculation of a value, or some other expensive process until the first time it is needed. This pattern appears in the GoF catalog as \"virtual proxy\", an implementation strategy for the Proxy pattern."),
            Flashcard(front = "Multiton", back = "Creational\nEnsure a class has only named instances, and provide a global point of access to them."),
            Flashcard(front = "Object pool", back = "Creational\nAvoid expensive acquisition and release of resources by recycling objects that are no longer in use. Can be considered a generalisation of connection pool and thread pool patterns."),
            Flashcard(front = "Prototype", back = "Creational\nSpecify the kinds of objects to create using a prototypical instance, and create new objects from the 'skeleton' of an existing object, thus boosting performance and keeping memory footprints to a minimum."),
            Flashcard(front = "Resource acquisition is initialization (RAII)", back = "Creational\nEnsure that resources are properly released by tying them to the lifespan of suitable objects."),
            Flashcard(front = "Singleton", back = "Creational\nEnsure a class has only one instance, and provide a global point of access to it."),
            Flashcard(front = "Adapter, Wrapper, or Translator", back = "Structural\nConvert the interface of a class into another interface clients expect. An adapter lets classes work together that could not otherwise because of incompatible interfaces. The enterprise integration pattern equivalent is the translator."),
            Flashcard(front = "Bridge", back = "Structural\nDecouple an abstraction from its implementation allowing the two to vary independently."),
            Flashcard(front = "Composite", back = "Structural\nCompose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly."),
            Flashcard(front = "Decorator", back = "Structural\nAttach additional responsibilities to an object dynamically keeping the same interface. Decorators provide a flexible alternative to subclassing for extending functionality."),
            Flashcard(front = "Extension object", back = "Structural\nAdding functionality to a hierarchy without changing the hierarchy."),
            Flashcard(front = "Facade", back = "Structural\nProvide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use."),
            Flashcard(front = "Flyweight", back = "Structural\nUse sharing to support large numbers of similar objects efficiently."),
            Flashcard(front = "Front controller", back = "Structural\nThe pattern relates to the design of Web applications. It provides a centralized entry point for handling requests."),
            Flashcard(front = "Marker", back = "Structural\nEmpty interface to associate metadata with a class."),
            Flashcard(front = "Module", back = "Structural\nGroup several related elements, such as classes, singletons, methods, globally used, into a single conceptual entity."),
            Flashcard(front = "Proxy", back = "Structural\nProvide a surrogate or placeholder for another object to control access to it."),
            Flashcard(front = "Twin", back = "Structural\nTwin allows modeling of multiple inheritance in programming languages that do not support this feature."),
            Flashcard(front = "Blackboard", back = "Behavioral\nArtificial intelligence pattern for combining disparate sources of data (see blackboard system)"),
            Flashcard(front = "Chain of responsibility", back = "Behavioral\nAvoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it."),
            Flashcard(front = "Command", back = "Behavioral\nEncapsulate a request as an object, thereby allowing for the parameterization of clients with different requests, and the queuing or logging of requests. It also allows for the support of undoable operations."),
            Flashcard(front = "Interpreter", back = "Behavioral\nGiven a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language."),
            Flashcard(front = "Iterator", back = "Behavioral\nProvide a way to access the elements of an aggregate object sequentially without exposing its underlying representation."),
            Flashcard(front = "Mediator", back = "Behavioral\nDefine an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it allows their interaction to vary independently."),
            Flashcard(front = "Memento", back = "Behavioral\nWithout violating encapsulation, capture and externalize an object's internal state allowing the object to be restored to this state later."),
            Flashcard(front = "Null object", back = "Behavioral\nAvoid null references by providing a default object."),
            Flashcard(front = "Observer or Publish/subscribe", back = "Behavioral\nDefine a one-to-many dependency between objects where a state change in one object results in all its dependents being notified and updated automatically."),
            Flashcard(front = "Servant", back = "Behavioral\nDefine common functionality for a group of classes."),
            Flashcard(front = "Specification", back = "Behavioral\nRecombinable business logic in a Boolean fashion."),
            Flashcard(front = "State", back = "Behavioral\nAllow an object to alter its behavior when its internal state changes. The object will appear to change its class."),
            Flashcard(front = "Strategy", back = "Behavioral\nDefine a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it."),
            Flashcard(front = "Template method", back = "Behavioral\nDefine the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure."),
            Flashcard(front = "Visitor", back = "Behavioral\nRepresent an operation to be performed on the elements of an object structure. Visitor lets a new operation be defined without changing the classes of the elements on which it operates."),
            Flashcard(front = "Active Object", back = "Concurrency\nDecouples method execution from method invocation that reside in their own thread of control. The goal is to introduce concurrency, by using asynchronous method invocation and a scheduler for handling requests."),
            Flashcard(front = "Balking", back = "Concurrency\nOnly execute an action on an object when the object is in a particular state."),
            Flashcard(front = "Binding properties", back = "Concurrency\nCombining multiple observers to force properties in different objects to be synchronized or coordinated in some way."),
            Flashcard(front = "Blockchain", back = "Concurrency\nDecentralized way to store data and agree on ways of processing it in a Merkle tree, optionally using digital signature for any individual contributions."),
            Flashcard(front = "Compute kernel", back = "Concurrency\nThe same calculation many times in parallel, differing by integer parameters used with non-branching pointer math into shared arrays, such as GPU-optimized Matrix multiplication or Convolutional neural network."),
            Flashcard(front = "Double-checked locking", back = "Concurrency\nReduce the overhead of acquiring a lock by first testing the locking criterion (the 'lock hint') in an unsafe manner; only if that succeeds does the actual locking logic proceed. Can be unsafe when implemented in some language/hardware combinations. It can therefore sometimes be considered an anti-pattern."),
            Flashcard(front = "Event-based asynchronous", back = "Concurrency\nAddresses problems with the asynchronous pattern that occur in multithreaded programs."),
            Flashcard(front = "Guarded suspension", back = "Concurrency\nManages operations that require both a lock to be acquired and a precondition to be satisfied before the operation can be executed."),
            Flashcard(front = "Join", back = "Concurrency\nJoin-pattern provides a way to write concurrent, parallel and distributed programs by message passing. Compared to the use of threads and locks, this is a high-level programming model."),
            Flashcard(front = "Lock", back = "Concurrency\nOne thread puts a \"lock\" on a resource, preventing other threads from accessing or modifying it."),
            Flashcard(front = "Messaging design pattern (MDP)", back = "Concurrency\nAllows the interchange of information (i.e. messages) between components and applications."),
            Flashcard(front = "Monitor object", back = "Concurrency\nAn object whose methods are subject to mutual exclusion, thus preventing multiple objects from erroneously trying to use it at the same time."),
            Flashcard(front = "Reactor", back = "Concurrency\nA reactor object provides an asynchronous interface to resources that must be handled synchronously."),
            Flashcard(front = "Read-write lock", back = "Concurrency\nAllows concurrent read access to an object, but requires exclusive access for write operations."),
            Flashcard(front = "Scheduler", back = "Concurrency\nExplicitly control when threads may execute single-threaded code."),
            Flashcard(front = "Thread pool", back = "Concurrency\nA number of threads are created to perform a number of tasks, which are usually organized in a queue. Typically, there are many more tasks than threads. Can be considered a special case of the object pool pattern."),
            Flashcard(front = "Thread-specific storage", back = "Concurrency\nStatic or \"global\" memory local to a thread."))
}
