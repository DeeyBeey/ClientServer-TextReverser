### 1. Compilation

1. Open a terminal or command prompt.

2. Navigate to the directory containing the Java source files (`Client.java` and `Server.java`).

3. Compile the Java source files using the `javac` command:

    ```bash
    javac Client.java Server.java
    ```

    This command compiles both `Client.java` and `Server.java` and generates corresponding `.class` files.

### 2. Running the Server

1. After successful compilation, run the server by providing the port number as a command-line argument:

    ```bash
    java Server <portNumber>
    ```

    Replace `<portNumber>` with the desired port number.

    Example:

    ```bash
    java Server 8080
    ```
2. The server will start listening for client connections on the specified port.

### 3. Running the Client

1. Open another terminal or command prompt window.

2. Run the client by providing the server IP address and port number as command-line arguments:

    ```bash
    java Client <serverIP> <portNumber>
    ```

    Replace `<serverIP>` with the IP address of the server and `<portNumber>` with the port number on which the server is listening.

    Example:

    ```bash
    java Client 127.0.0.1 8080
    ```

    > Note: Since server is on the same machine it will run only on localhost, hence use the IP address in the example usage or simply replace it with "localhost"

3. Follow the on-screen instructions to enter the text (under 80 characters) in the client program.

4. The client will send the input to the server, and you will receive the modified response from the server.

> Note: Ensure that the server is running before starting the client. Also, make sure that the port number provided to the server and client is the same.