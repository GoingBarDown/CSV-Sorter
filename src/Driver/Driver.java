package Driver;
import java.io.*;
import java.util.*;



import Exceptions.BadIsbn10Exception;
import Exceptions.BadIsbn13Exception;
import Exceptions.BadPriceException;
import Exceptions.BadYearException;
import Exceptions.MissingFieldException;
import Exceptions.TooFewFieldsException;
import Exceptions.TooManyFieldsException;
import Exceptions.UnknownGenreException;


/**
 *  *
* 	@author [Chandler Higgins (Student #: 40156534), Zayd-Khomayne Boucaud (Student #: 40157754)]
 */

public class Driver {

    private static FileWriter comics;
    private static FileWriter hobbies;
    private static FileWriter movies;
    private static FileWriter music;
    private static FileWriter nostalgia;
    private static FileWriter radio;
    private static FileWriter sports;
    private static FileWriter trains;
    private static FileWriter syntax;
    private static FileWriter semantic;
    private static int howmany = 0;



    

	
    /**
     * The main method of the program. It orchestrates the execution of different parts of the assignment.
     * It calls the methods doPart1(), doPart2(), and doPart3(), catching and handling exceptions appropriately.
     *
     * @param args The command-line arguments passed to the program (not used in this implementation).
     */
	public static void main(String[] args) {
		
	
		// TODO Auto-generated method stub
	try {
			doPart1();
			doPart2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
        	try {
				semantic.write("Semantic error in file: \n====================\nError: Invalid ISBN-13\nRecord: " + "\n\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
	


//	doPart3();
		
	  
	/*  for (int i = 0; i < index; i++) {
          System.out.println("File #" + i + ": " + records[i][0]); // Assuming the first record is the file name
          for (int j = 0; j < records[i].length; j++) {
              System.out.println("Book Record #" + j + ": " + records[i][j]);
          }
      } */
	


	}
	
	/**
	 * Process input files, perform syntax checks, and categorize records into separate files.
	 * The method reads a list of file names from "part1_input_file_names.txt", processes each file,
	 * performs syntax checks, and categorizes valid records into separate files based on genre.
	 * Syntax errors and semantic errors are logged in "syntax_error_file.txt" and "semantic_error_file.txt" respectively.
	 *
	 * @throws IOException If an I/O error occurs while reading or writing files.
	 */
	
	public static void doPart1() throws IOException {
	 	comics = new FileWriter("Cartoon_Comics.csv.txt");
        hobbies = new FileWriter("Hobbies_Collectibles.csv.txt");
        movies = new FileWriter("Movies_TV_Books.csv.txt");
        music = new FileWriter("Music_Radio_Books.csv.txt");
        nostalgia = new FileWriter("Nostalgia_Eclectic_Books.csv.txt");
        radio = new FileWriter("Old_Time_Radio_Books.csv.txt");
        sports = new FileWriter("Sports_Sports_Memorabilia.csv.txt");
        trains = new FileWriter("Trains_Planes_Automobiles.csv.txt");		
        semantic = new FileWriter("semantic_error_file.txt");
	
        
        String[] files = new String[16];
        int index = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/chandlerhiggins/Downloads/Comp249_F23_Assg2/part1_input_file_names.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {	                
                	if (line.equals("16")) {
                		continue;
                	}
                files[index] = line;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    /*    for (int i = 0; i < files.length; i++) {
        	System.out.println(files[i]);
        }      */
        
        
        FileWriter syntax = new FileWriter("syntax_error_file.txt", true);

        
        int synterrors = 0; 
  for (int i = 0; i < files.length; i++) {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/chandlerhiggins/Downloads/A3_40156534/" + files[i]))) {
            int index2 = 0;
            String line;
            int numofrec = 0;
        	
         

        //	System.out.println(index2);
            int recordIndex = 0;
         //   String[] records = new String[numofrec];
            while ((line = reader.readLine()) != null) {
            	String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            	

            
                    
                for (int j = 0; j < fields.length; j++) {
                    fields[j] = (fields[j] != null) ? fields[j].trim() : "";
                }


            //	fields[0] = removeCommasInQuotes(fields[0]);
        	//	System.out.println(fields.length + "Bob");

            	
            //	records[recordIndex] = line;
             //   recordIndex++;
           
           if (fields.length < 6) {
        	   try {
        		   throw new TooFewFieldsException("Syntax error in file: " + files[i] + "\n====================\nError: Too Few Fields\nRecord: " + line + "\n\n");
        	   } catch (TooFewFieldsException e){
        	   syntax.write("Syntax error in file: " + files[i] + "\n====================\nError: Too Few Fields\nRecord: " + line + "\n\n");
        	   synterrors++;
        	   continue;
        	   }
           } if (fields.length > 6) {
        	   try {
        		   throw new TooManyFieldsException("Syntax error in file: " + files[i] + "\n====================\nError: Too Many Fields\nRecord: " + line + "\n\n");
        	   } catch (TooManyFieldsException e){
        		   syntax.write("Syntax error in file: " + files[i] + "\n====================\nError: Too Many Fields\nRecord: " + line + "\n\n");
        		   synterrors++;
        		   continue;
        	   }
           }
           
           if (fields.length == 6) {
        	   for (int j = 0; j < fields.length; j++) {
        		   if (fields[j].isEmpty()) {
        			   if (j == 0) {
        				   try {
        					   throw new MissingFieldException("Syntax error in file: " + files[i] + "\n====================\nError: Missing Title\nRecord: " + line + "\n\n");
        				   } catch (MissingFieldException e){
        					   syntax.write("Syntax error in file: " + files[i] + "\n====================\nError: Missing Title\nRecord: " + line + "\n\n");
        					   synterrors++;
        				   }
        			   }
        			   if (j == 1) {
        				   try {
        					   throw new MissingFieldException("Syntax error in file: " + files[i] + "\n====================\nError: Missing Authors\nRecord: " + line + "\n\n");
        				   } catch (MissingFieldException e){
        					   syntax.write("Syntax error in file: " + files[i] + "\n====================\nError: Missing Authors\nRecord: " + line + "\n\n");
        					   synterrors++;
        				   }
        			   }
        			   if (j == 2) {
        				   try {
        					   throw new MissingFieldException("Syntax error in file: " + files[i] + "\n====================\nError: Missing Price\nRecord: " + line + "\n\n");
        				   } catch (MissingFieldException e){
        					   syntax.write("Syntax error in file: " + files[i] + "\n====================\nError: Missing Price\nRecord: " + line + "\n\n");
        					   synterrors++;
        				   }
        			   }
        			   if (j == 3) {
        				   try {
        					   throw new MissingFieldException("Syntax error in file: " + files[i] + "\n====================\nError: Missing ISBN\nRecord: " + line + "\n\n");
        				   } catch (MissingFieldException e){
        					   syntax.write("Syntax error in file: " + files[i] + "\n====================\nError: Missing ISBN\nRecord: " + line + "\n\n");
        					   synterrors++;
        				   }
        			   }
        			   if (j == 4) {
        				   try {
        					   throw new MissingFieldException("Syntax error in file: " + files[i] + "\n====================\nError: Missing Genre\nRecord: " + line + "\n\n");
        				   } catch (MissingFieldException e){
        					   syntax.write("Syntax error in file: " + files[i] + "\n====================\nError: Missing Genre\nRecord: " + line + "\n\n");
        					   synterrors++;
        				   }
        			   }
        			   if (j == 5) {
        				   try {
        					   throw new MissingFieldException("Syntax error in file: " + files[i] + "\n====================\nError: Missing Year\nRecord: " + line + "\n\n");
        				   } catch (MissingFieldException e){
        					   syntax.write("Syntax error in file: " + files[i] + "\n====================\nError: Missing Year\nRecord: " + line + "\n\n");
        					   synterrors++;
        				   }
        			   }
        			   if (!fields[4].equals("CCB") && !fields[4].equals("HCB") && !fields[4].equals("MTV") && !fields[4].equals("MRB") && !fields[4].equals("NEB") && !fields[4].equals("OTR") && !fields[4].equals("SSM") && !fields[4].equals("TPA")) {
        				   try {
        					   throw new UnknownGenreException("Syntax error in file: " + files[i] + "\n====================\nError: Unknown Genre\nRecord: " + line + "\n\n");
        				   } catch (UnknownGenreException e){
        					   syntax.write("Syntax error in file: " + files[i] + "\n====================\nError: Unknown Genre\nRecord: " + line + "\n\n");
        					   synterrors++;
        				   }
        			   }
        		   }
        	   }
        	   boolean isitnull = false;
        	   for (int k = 0; k < fields.length; k++) {
        		   if (fields[k].isEmpty()) {
        			   isitnull = true;
        			   break;
        		   }
        		   }
        	   if (isitnull == false) {
        		   if (fields[4].equals("CCB")) {
    				   comics.write(line + "\n");
    				   howmany++;
    			   } else if (fields[4].equals("HCB")) {
    				   hobbies.write(line + "\n");
    				   howmany++;
    			   } else if (fields[4].equals("MTV")) {
    				   movies.write(line + "\n");
    				   howmany++;
    			   } else if (fields[4].equals("MRB")) { // MRB NEB OTR SSM TPA
    				   music.write(line + "\n");
    				   howmany++;
    			   } else if (fields[4].equals("NEB")) {
    				   nostalgia.write(line + "\n");
    				   howmany++;
    			   } else if (fields[4].equals("OTR")) {
    				   radio.write(line + "\n");
    				   howmany++;
    			   } else if (fields[4].equals("SSM")) {
    				   sports.write(line + "\n");
    				   howmany++;
    			   } else if (fields[4].equals("TPA")) {
    				   trains.write(line + "\n");
    				   howmany++;
        	   }
           }
           
            }
            	}
        
        } catch (IOException e) {
        	e.printStackTrace();
        }
     }
  syntax.close();
  comics.close();
  hobbies.close();
  music.close();
  nostalgia.close();
  radio.close();
  sports.close();
  trains.close();
		}
	
	
	
	static int currentindex = 0;
	
	
	/**
	 * Reads data from CSV files, performs semantic checks on the data, and
	 * writes valid data to serialized objects for each category.
	 *
	 * @throws IOException           If an I/O error occurs while reading or writing files.
	 */
	public static void doPart2() throws IOException {

		
		
		
	    ObjectOutputStream CBBobject=new ObjectOutputStream(new FileOutputStream(new File("Cartoons_Comics.csv.ser")));
        ObjectOutputStream HCBobject=new ObjectOutputStream(new FileOutputStream(new File("Hobbies_Collectibles.csv.ser")));
        ObjectOutputStream MTVobject=new ObjectOutputStream(new FileOutputStream(new File("Movies_TV_Books.csv.ser")));
        ObjectOutputStream MRBobject=new ObjectOutputStream(new FileOutputStream(new File("Music_Radio_Books.csv.ser")));
        ObjectOutputStream NEBobject=new ObjectOutputStream(new FileOutputStream(new File("Nostalgia_Eclectic_Books.csv.ser")));
        ObjectOutputStream OTRobject=new ObjectOutputStream(new FileOutputStream(new File("Old_Time_Radio_Books.csv.txt")));
        ObjectOutputStream SSMobject=new ObjectOutputStream(new FileOutputStream(new File("Sports_Sports_Memorabilia.csv.ser")));
        ObjectOutputStream TPAobject=new ObjectOutputStream(new FileOutputStream(new File("Trains_Planes_Automobiles.csv.ser")));
	        
        String[] files = new String[8];
        
        files[0] = "Cartoon_Comics.csv.txt";
        files[1] = "Hobbies_Collectibles.csv.txt";
        files[2] = "Movies_TV_Books.csv.txt";
        files[3] = "Music_Radio_Books.csv.txt";
        files[4] = "Nostalgia_Eclectic_Books.csv.txt";
        files[5] = "Old_Time_Radio_Books.csv.txt";
        files[6] = "Sports_Sports_Memorabilia.csv.txt";
        files[7] = "Trains_Planes_Automobiles.csv.txt";
        
        
        File com = new File("Cartoon_Comics.csv.txt");
        File hob = new File("Hobbies_Collectibles.csv.txt");
        File mov = new File("Movies_TV_Books.csv.txt");
        File mus = new File("Music_Radio_Books.csv.txt");
        File nos = new File("Nostalgia_Eclectic_Books.csv.txt");
        File old = new File("Old_Time_Radio_Books.csv.txt");
        File spo = new File("Sports_Sports_Memorabilia.csv.txt");
        File tra = new File("Trains_Planes_Automobiles.csv.txt");
        
     
        

        File[] farray = new File[8];
        
        int comindex = 0;
        int hobindex = 0;
        int movindex = 0;
        int musindex = 0;
        int nosindex = 0;
        int oldindex = 0;
        int spoindex = 0;
        int traindex = 0;

        
        
    	Book comBook[] = new Book[countLines(com)];
    	Book hobBook[] = new Book[countLines(hob)];
    	Book movBook[] = new Book[countLines(mov)];
    	Book musBook[] = new Book[countLines(mus)];
    	Book nosBook[] = new Book[countLines(nos)];
    	Book oldBook[] = new Book[countLines(old)];
    	Book spoBook[] = new Book[countLines(spo)];
    	Book traBook[] = new Book[countLines(tra)];
    	
    	


    	
    	
        farray[0] = com;
        farray[1] = hob;
        farray[2] = mov;
        farray[3] = mus;
        farray[4] = nos;
        farray[5] = old;
        farray[6] = spo;
        farray[7] = tra;

        
      /*  int[] flength = new int[8];
        for (int i = 0; i < farray.length; i++) {
        	flength[i] = countLines(farray[i]);
        	System.out.println(flength[i] + "FRANKTHETANK");
        }  */
        
       
        
        
               // FileWriter syntax = new FileWriter("semantic_error_file.txt", true);
        int semanticerrors = 0; 
        String line;
        int filenum = 0;
  for (int i = 0; i < files.length; i++) {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/chandlerhiggins/eclipse-workspace/Assignment3_249/" + files[i]))) {
        	
            while ((line = reader.readLine()) != null) {
        		howmany++;
            	Book bk = new Book();
            	double price = 0;
             	long isbn = 0;
             	int year = 0;
             	
             	String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
           
            
            for (int j = 0; j < fields.length; j++) {
            	
            	
            	
            	// Check to see if price is invalid
            	if (j == 2) {
            	price = Double.parseDouble(fields[j]);
            	if (price < 0) {
            		try {
            			throw new BadPriceException("Semantic error in file: " + files[i] + "\n====================\nError: Invalid Price\nRecord: " + line + "\n\n");
            		} catch (BadPriceException e) {
            			semantic.write("Semantic error in file: " + files[i] + "\n====================\nError: Invalid Price\nRecord: " + line + "\n\n");
            			semanticerrors++;
            			continue;
            		}
            		}

            	}
            	
            	if (j == 3) {
            		
            		if (fields[3].length() == 13) {
            	        isbn = Long.parseLong(fields[3]);
            			if (!isValidISBN10(isbn)) {
	                		try {
	                			throw new BadIsbn10Exception("Semantic error in file: " + files[i] + "\n====================\nError: Invalid ISBN-10\nRecord: " + line + "\n\n");
	                		} catch (BadIsbn10Exception e) {
	                			semantic.write("Semantic error in file: " + files[i] + "\n====================\nError: Invalid ISBN-10\nRecord: " + line + "\n\n");
	                			semanticerrors++;
	                			continue;
	                		} catch (NumberFormatException e) {
	                        	semantic.write("Semantic error in file: " + files[i] + "\n====================\nError: Invalid ISBN-10\nRecord: " + line + "\n\n");
	                			semanticerrors++;
	                			continue;
	                        }
                		}
                	}
            		
            		if (fields[3].length() == 10) {
            	        isbn = Long.parseLong(fields[3]);

            			if (!isValidISBN13(isbn)) {
	                		try {
	                			throw new BadIsbn13Exception("Semantic error in file: " + files[i] + "\n====================\nError: Invalid Price\nRecord: " + line + "\n\n");
	                		} catch (BadIsbn13Exception e) {
	                			semantic.write("Semantic error in file: " + files[i] + "\n====================\nError: Invalid ISBN-13\nRecord: " + line + "\n\n");
	                			semanticerrors++;
	                			continue;
	                		} catch (NumberFormatException e) {
	                        	semantic.write("Semantic error in file: " + files[i] + "\n====================\nError: Invalid ISBN-13\nRecord: " + line + "\n\n");
	                			semanticerrors++;
	                			continue;
	                        }
                		}
                	}
            	}
            	
            	if (j == 5) {
            		year = Integer.parseInt(fields[j]);
                	if (year < 1995 || year > 2010) {
                		try {
                			throw new BadYearException("Semantic error in file: " + files[i] + "\n====================\nError: Invalid Year\nRecord: " + line + "\n\n");
                		} catch (BadYearException e) {
                			semantic.write("Semantic error in file: " + files[i] + "\n====================\nError: Invalid Year\nRecord: " + line + "\n\n");
                			semanticerrors++;
                			continue;
                		}
                		}
            	}
            	
            }
            
        	
    		
        		bk.setTitle(fields[0]);
        		bk.setAuthors(fields[1]);
            	bk.setPrice(price);
    			bk.setIsbn(isbn);
    			bk.setGenre(fields[4]);
            	bk.setYear(year);

            	
            	switch(i) {
                case 0:
                    CBBobject.writeObject(bk);
                    comBook[comindex++] = bk;
                    break;
                case 1: 
                    HCBobject.writeObject(bk);
                    hobBook[hobindex++] = bk;
                    break;
                case 2:
                    MTVobject.writeObject(bk);
                    movBook[movindex++] = bk;
                    break;
                case 3: 
                    MRBobject.writeObject(bk);
                    musBook[musindex++] = bk;
                    break; 
                case 4:
                    NEBobject.writeObject(bk);
                    nosBook[nosindex++] = bk;
                    break;
                case 5:
                    OTRobject.writeObject(bk);
                    oldBook[oldindex++] = bk;
                    break;
                case 6: 
                    SSMobject.writeObject(bk);
                    spoBook[spoindex++] = bk;
                    break;
                case 7:
                    TPAobject.writeObject(bk);
                    traBook[traindex++] = bk;
                    break;
                default:
                    System.out.println("This object can't be written to the file");
            }
            }

                } catch (FileNotFoundException e) {
                	e.printStackTrace();
                } catch (IOException e) {
                	e.printStackTrace();
                }
            }
  			semantic.close();
  			syntax.close();
  		  comics.close();
  		  hobbies.close();
  		  music.close();
  		  nostalgia.close();
  		  radio.close();
  		  sports.close();
  		  trains.close();
  		  
  		CBBobject.close();
        HCBobject.close();
        MTVobject.close();
        MRBobject.close();
        OTRobject.close();
        SSMobject.close();
        TPAobject.close();      
        
    //    for (int i = 0; i < comBook.length; i++) {
    //    	System.out.println(comBook[i] + "Bob");
    //    }
        
	}
	
	
	
	/**
	 * Part 3 of the assignment. Allows the user to view the content of a selected serialized file.
	 * The method displays a menu where the user can either view the currently selected file or choose a new file to view.
	 * The user can exit the program by choosing the 'x' option. The selected file is displayed using ObjectInputStream.
	 */
	public static void doPart3() {
		
		Scanner scanner = new Scanner(System.in);
		String choice;
		
	/*	String com = "1  Cartoons_Comics_Books.csv.ser	(27 records)";
		String hob = "2  Hobbies_Collectibles_Books.csv.ser	(37	records)";
		String mov = "3  Movies_TV.csv.ser			(689 records)";
		String mus = "4  Music_Radio_Books.csv.ser		(519 records)";
		String nos = "5  Nostalgia_Eclectic_Books.csv.ser	(54 records)";
		String old = "6  Old_Time_Radio.csv.ser		(8 records)";
		String spo = "7  Sports_Sports_Memorabilia.csv.ser	(194 records)";
		String tra = "8  Trains_Planes_Automobiles.csv.ser	(37 records)";	*/
		
		String com = "Cartoons_Comics.csv.ser";
		String hob = "Hobbies_Collectibles.csv.ser";
		String mov = "Movies_TV_Books.csv.ser)";
		String mus = "Music_Radio_Books.csv.ser";
		String nos = "Nostalgia_Eclectic_Books.csv.ser";
		String old = "Old_Time_Radio.csv.ser";
		String spo = "Sports_Sports_Memorabilia.csv.ser";
		String tra = "Trains_Planes_Automobiles.csv.ser";


		String selectedFile = null;
		boolean selected = false;
		
		  do {
			  
			  if (selected == false){
	            System.out.println("-----------------------------");
	            System.out.println("Main Menu");
	            System.out.println("-----------------------------");
	            System.out.println("v View the selected file");
	            System.out.println("s Select a file to view");
	            System.out.println("x Exit");
	            System.out.println("-----------------------------");
	            System.out.print("Enter Your Choice: ");
			  }
			  
			  if (selected == true){
		            System.out.println("-----------------------------");
		            System.out.println("Main Menu");
		            System.out.println("-----------------------------");
		            System.out.println("v View the selected file " + selectedFile);
		            System.out.println("s Select a file to view");
		            System.out.println("x Exit");
		            System.out.println("-----------------------------\n");
		            System.out.print("Enter Your Choice: ");
				  }

	            choice = scanner.nextLine();

	            switch (choice) {
	                case "v":
	                    try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/chandlerhiggins/eclipse-workspace/Assignment3_249/" + selectedFile))) {
	                        while (true) {
	                            try {
	                                // Read and deserialize the object
	                                Book bk = (Book) objectInputStream.readObject();

	                                // Do something with the deserialized object (e.g., print it)
	                                System.out.println(bk);
	                            } catch (ClassNotFoundException e) {
	                                // This exception will be thrown when there are no more objects to read
	                                break;
	                            }
	                        }
	                    } catch (EOFException e) {
	                        // Reached the end of the file
	                        System.out.println();
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }
	                	
	                    // code to view the selected file
	                    break;
	                case "s":
	                	System.out.println("-----------------------------");
	    	            System.out.println("		File Sub-Menu");
	    	            System.out.println("-----------------------------");
	    	            System.out.println("1 " + com + "\t(27 records)");
	    	            System.out.println("2 " + hob + "\t(37 records)");
	    	            System.out.println("3 " + mov + "\t(689 records)");
	    	            System.out.println("4 " + mus + "\t(519 records)");
	    	            System.out.println("5 " + nos + "\t(54 records)");
	    	            System.out.println("6 " + old + "\t(8 records)");
	    	            System.out.println("7 " + spo + "\t(194 records)");
	    	            System.out.println("8 " + tra + "\t(37 records)");
	    	            System.out.println("9  Exit");
	    	            System.out.println("-----------------------------\n");
	    	            System.out.print("Enter your choice: ");
		                int fileChoice = scanner.nextInt();
		                String absorb = scanner.nextLine();


	    	            
	    	            switch (fileChoice) {
	    	            case 1: selectedFile = com;
	    	            selected = true;
	    	            break;
	    	            case 2: selectedFile = hob;
	    	            selected = true;
	    	            break;
	    	            case 3: selectedFile = mov;
	    	            selected = true;
	    	            break;
	    	            case 4: selectedFile = mus;
	    	            selected = true;
	    	            break;
	    	            case 5: selectedFile = nos;
	    	            selected = true;
	    	            break;
	    	            case 6: selectedFile = old;
	    	            selected = true;
	    	            break;
	    	            case 7: selectedFile = spo;
	    	            selected = true;
	    	            break;
	    	            case 8: selectedFile = tra;
	    	            selected = true;
	    	            break;
	    	            }


	                	
	                	
	                    // code to select a file to view
	                    break;
	                case "x":
	                    System.out.println("Exiting...");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (!choice.equals("x")); 
	        	
	        }
		  
		  
		  
		  
		  
	    

	
		
		
		
		
	   
	
	
	
	
	
	
	
	 /**
     * 
     * A utility method to count the number of digits in a given long integer.
     * 
     * @param n the long integer to count the digits of
     * @return an integer representing the number of digits in the given long
     *         integer
     */
    public static int countDig(long n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count = count + 1;
        }
        return count;
    }
    
    /**
     * 
     * Calculates the sum of the digits in a given long number.
     * 
     * @param n the long number to be summed
     * @return the sum of the digits in the input long number
     */
    public static long longSum(long n) {

        String numString = Long.toString(n);
        int numDigits = numString.length();
        long[] larray = new long[numDigits];
        int sum = 0;
        
    	if (larray.length == 10) {
        for (int i = 0, y = 10; i < numDigits; i++, y--) {
            long digit = n % 10;
            larray[i] = digit;
            sum += (larray[i] * y);
            n /= 10;
        	}
    	}
        	
        if (larray.length == 13) {
           for (int i = 0, k=3; i < numDigits; i++) {
        	   long digit = n % 10;
               larray[i] = digit;
               if ((i % 2) == 1) {
               sum += (larray[i] * 3);
               n /= 10;
             } else {
                 sum += larray[i];
               n /= 10;
             }

        	}
        	
        }
        return sum;

    }
    
    
    /**
     * Determines whether a given ISBN-10 string is valid or not.
     * 
     * @param isbn the ISBN-10 string to validate
     * @return true if the ISBN-10 string is valid, false otherwise
     */
    public static boolean isValidISBN10(long isbn) {

        if (((longSum(isbn) % 11) != 0)) {
            return false;
        } else {
            return true;
        }
    }
	 
    /**
     * 
     * Checks if the given ISBN-13 string is valid according to the ISBN-13
     * algorithm.
     * 
     * @param isbn the ISBN-13 string to be checked
     * @return true if the ISBN-13 string is valid, false otherwise
     * @throws NumberFormatException if the input string is not a valid long number
     */
    public static boolean isValidISBN13(long isbn) {

        if ((longSum(isbn) % 10) != 0) {
            return false;
        } else {
            return true;
        }
    }

	
	 /**
     * 
     * Removes all commas within quotation marks in the given input string.
     * 
     * @param input the input string that may contain commas within quotation marks
     * @return the modified string with commas removed within quotation marks
     */
    public static String removeCommasInQuotes(String input) {
        boolean insideQuotes = false;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '"') { 
                insideQuotes = !insideQuotes; // Toggle state inside and outside quotes
            } else if (c == ',' && insideQuotes) {
                continue; // If the current character is a comma and is within quotation marks, skip
                          // directly without adding output
            }
            output.append(c);
        }
        return output.toString();
    }
	  
    /**
     * Reads the lines from a given file and returns them as a String array.
     * The method uses a BufferedReader to read the lines from the file and stores
     * them in a String array. The number of lines in the file is first counted
     * to determine the size of the String array to be returned.
     * 
     * @param file the file to read lines from
     * @return linesArray a String array containing the lines from the file
     * @throws IOException           if an I/O error occurs while reading the file
     * @throws FileNotFoundException if the file does not exist or cannot be opened
     *                               for reading
     */
    
  
    public static String[] readLinesFromFile(File file) throws IOException, FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int numLines = countLines(file);
        String[] linesArray = new String[numLines];
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            linesArray[i++] = line;
        }
        reader.close();
        return linesArray;
    }
	  
    /**
     * Counts the number of lines in a given file and returns the count as an
     * integer.
     * The method uses a BufferedReader to read the lines from the file and counts
     * the number of lines by iterating over them until the end of the file is
     * reached.
     * 
     * @param file the file to count lines from
     * @return the number of lines in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    private static int countLines(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int numLines = 0;
        while (reader.readLine() != null) {
            numLines++;
        }
        reader.close();
        return numLines;
    }
	
	

}
