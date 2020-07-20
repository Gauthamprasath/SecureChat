# SecureChat
A secure communication System, based on the use and verification of temporary sessions, spereately created at the begining of each conversation. 

Used Diffie Hellman algorithm to set session key for each sesson and the keys are shared wwith the respective users at both ends. Once the session is set the key are stored in the database server(here, I used Oracle DB). After the sesson keys are set, The communication takes place.

In the communication process, the users give sesson key as input and the user can verify whether the user on the other side of the communication is authenticated. The system will notify if the session key used by the either of the comunication side is invalid.
