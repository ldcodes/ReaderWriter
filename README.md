# ReaderWriter

A data set is shared among a number of concurrent processes  
Readers : only read the data set; they do not perform any updates  
Writers   : can both read and write.  
Problem :     
allow multiple readers to read at the same time.    
only one single writer can access the shared data at the same time.  
