/*
  * NOTE: Please contact me if you see a error in this.
  * I typed this in the ide I am using to learn Java and tried to
  * type it raw without having a compiler
  * so if you would be a good citizen and tell me if there is a mistake that would be fantastic :)
*/

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Collections;
import java.util.Scanner;
import signal.signal;

public class Main {
  // We will override this
  abstract static class set {
    public String create_file_name;
    
    abstract public String getFile(String create_fileNAME);
    abstract public void create(String write_data_to_file);
  }
  // This will be where we override the values
  public static void getSetup(String file_,String informationToInput) {
    ArrayList<String> saved_data = new ArrayList<String>();
    set setup = new set() {
      @Override
      public String getFile(String create_fileNAME) {
        this.create_file_name = create_fileNAME;
        saved_data.add(this.create_file_name);
        return this.create_file_name;
      }
      @Override
      public void create(String write_data_to_file) {
        saved_data.add(write_data_to_file);
        try {
          Formatter cFile = new Formatter(this.create_file_name);
          cFile.format("%s",write_data_to_file);
          cFile.close();
        } catch (Exception e) {
          System.out.println(e); 
        }
      }
    };
    setup.getFile(file_);
    setup.create(informationToInput);
    Collections.sort(saved_data);
    System.out.println(saved_data);
  }
  
  // I didn't wanna make another file so I made this mini project in one file :)
  public static void main(String[] args) {
    Scanner fileNAME = new Scanner(System.in);
    // Gets filename to create. HAS TO BE .txt
    System.out.print("File name >> ");
    String file_ = fileNAME.nextLine();
    // Gets the .txt data(what the text will be)
    System.out.print("Data >> ");
    String file_data = fileNAME.nextLine();
    // Adding into the file
    System.out.print("Signal >> ");
    String SIGNAL = fileNAME.nextLine();
    signal setSignal = new signal();
    setSignal.stateSignals(SIGNAL,file_data,file_);
    // Calling the function that will create and write into the file
    getSetup(file_, file_data);
  }
}
