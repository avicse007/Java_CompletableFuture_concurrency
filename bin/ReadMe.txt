1. Race Condition 
	--> Occurs on fields not on parameter and not variables
 	--> 2 threads are reading / writing a given field
 	-->

2. Check for the happens-before link
	--> Are your read/write volatile??
	--> Are your read and write is synchronized

3. Synchronized or volatile 
	--> Synchronized = atomicity
	
