package signal;

/* 
  * This will use signals to insert data into the
  * .txt file for no absolute reason
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;

public class signal {
  // These will be the signals
  enum signal_types {
    a01,
    send,
    recieve
  }

  abstract static class setupSignals {
    public String signal;
    public String file_name;
    public String data_being_sent;

    abstract public String getSignal(String signal_name);
    abstract public String withSignalSend(String fileNAME,String send_Again);
  }

  public void stateSignals(String signal_name, String send_data,String file) {
    ArrayList<String> data = new ArrayList<String>();
    setupSignals signalset = new setupSignals() {
      @Override
      public String getSignal(String signal_name) {
        this.signal = signal_name;
        data.add(this.signal);
        return this.signal;
      }
      @Override
      public String withSignalSend(String fileNAME,String send_Again) {
        try {
          this.file_name = "SIGNAL.txt";
          this.data_being_sent = send_Again;
          Formatter sendDataToFile = new Formatter(this.file_name);
          sendDataToFile.format("%s", this.data_being_sent);
          sendDataToFile.close();
          data.add(this.file_name);
          data.add(this.data_being_sent);
        } catch (Exception e) {
          System.out.println(e);
        }
        return this.file_name + "\n" + this.data_being_sent;
      }
    };

    switch(signal_name) {
      case "a01":
        data.add(signal_name);
        signal_types sig = signal_types.a01;
        if(sig == signal_types.a01) {
          signalset.getSignal("a01");
          signalset.withSignalSend(file,"\nSENT_WITH_SIGNAL_a01_WITHSTANDING_TYPE_TEXT");
        }
        break;
      case "send":
        data.add(signal_name);
        signal_types sig2 = signal_types.send;
        if(sig2 == signal_types.send) {
          signalset.getSignal("send");
          signalset.withSignalSend(file,"\nSENT_WITH_SIGNAL_send_WITHSTANDING_TYPE_send\n"+"DATA_WITH_SEND_REQUEST\n"+send_data);
        }
        break;
      case "recieve":
        data.add(signal_name);
        signal_types sig3 = signal_types.recieve;
        if(sig3 == signal_types.recieve) {
          signalset.getSignal("recieve");
          signalset.withSignalSend(file, "\nSENT_WITH_SIGNAL_recieve_WITHSTANDING_TYPE_recieve\n"+"DATA_WITH_RECIEVE_REQUEST\n"+"Recieve_From_\n--->"+file);
        }
        break;
    }
  }
}
