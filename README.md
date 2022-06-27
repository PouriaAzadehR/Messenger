# MESSENGER
this is a Messenger wich is going to simulate Twitter

## features
:heavy_check_mark: Socket programming

:heavy_check_mark: Multi thread 

:heavy_check_mark: Server-Client project 

:heavy_check_mark: SOA architecture 

:heavy_check_mark: real time chat

:heavy_check_mark: Javafx

:heavy_check_mark: Mysql


## SOCKET PROGRAMMING

Socket programming is a means of communicating data between two computers across a network. Connections can be made using either a connection-oriented protocol or a connectionless protocol. In our case, we will use TCP/IP which is a connection-oriented protocol.

Before exchanging data, computers must establish a link that is for connection-oriented protocols. UDP (User Datagram Protocol) is the only option for connectionless protocol.

To demonstrate sockets further, we shall use the Client/Server architecture. Client and server communicate by writing to and reading from the socket connection.

### What is Socket ?

A socket is a communication endpoint that serves as a link between two machines on a network. It has a port number, which the TCP/IP layer can use to identify the application that receives the data. An endpoint usually includes a port number and an IP address.

### TCP ?

Transmission Control Protocol (TCP) is a widely used protocol for data transmission on a network that supports client/server end points.

### Various kind of Sockets

1- A server socket - It awaits a request from a client.

2- A client socket - It establishes communication between client and server.

The client has to know two things about the server:

1- The server’s IP address.

2- The port number.

### How to creat a Socket Connection in Java ?

In Java, we create a socket connection by doing the following steps:

The server constructs a ServerSocket object to specify the port number on which our conversation will occur. Exception handling methods are in use whenever an I/O error occurs.

The accept() method is called by the server to validate an incoming request to the socket.

A client then creates a Socket object by specifying the server name and the port number.

The Socket class constructor attempts to connect the client to the server using the provided port number.

If the connection is successful, the client and server can then communicate using I/O streams. The client and server socket classes are responsible for the I/O streams.

The client’s OutputStream communicates with the server’s InputStream, and the server’s OutputStream communicates with the client’s InputStream.

A stream is basically a collection of sequenced data.

The two major types of streams are:

1- A character stream (usually used with text files).

2- A byte stream (used with images).

A character stream is in human-readable language while a byte stream is in machine language.


## MULTI THREADING

Server Programs such as database and web servers repeatedly execute requests from multiple clients and these are oriented around processing a large number of short tasks. An approach for building a server application would be to create a new thread each time a request arrives and service this new request in the newly created thread. While this approach seems simple to implement, it has significant disadvantages. A server that creates a new thread for every request would spend more time and consume more system resources in creating and destroying threads than processing actual requests.

Since active threads consume system resources, a JVM creating too many threads at the same time can cause the system to run out of memory. This necessitates the need to limit the number of threads being created.

### ThreadPool in Java

A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing. Since the thread is already existing when the request arrives, the delay introduced by thread creation is eliminated, making the application more responsive.
