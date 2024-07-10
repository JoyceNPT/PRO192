/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {
    //Change the name of input and output file based on practical paper
    String inputFile = "input.txt";
    String outputFile = "output.txt";

    //--VARIABLES - @STUDENT: DECLARE YOUR VARIABLES HERE:
	int n;
//        ArrayList<Song> listSong = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        String line;
        String result = "";
        SongList songlist = new SongList();


	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
    String fi, fo;
    
    /**
     * Set input and output file for automatic rating
     * @param args path of input file and path of output file
     */
    public void setFile (String[] args){
        fi = args.length>=2? args[0]: inputFile;
        fo = args.length>=2? args[1]: outputFile;
    }
    
    /**
     * Reads data from input file
     */
    public void read(){
        try (Scanner sc  = new Scanner(new File(fi))){
    //--END FIXED PART----------------------------

            //INPUT - @STUDENT: ADD YOUR CODE FOR INPUT HERE:
            int n = Integer.parseInt(sc.nextLine());
            for(int i = 0; i < n; i++){
                line = sc.nextLine();
                list.add(line);
            }


	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
            sc.close();
        }catch(FileNotFoundException ex){
            System.out.println("Input Exception # " + ex);
        }
    }
    //--END FIXED PART----------------------------
    
    //ALGORITHM - @STUDENT: ADD YOUROWN METHODS HERE (IF NEED):
    

    
	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART--------------------------    
    /**
     * Main algorithm
     */
    public void solve(){
    //--END FIXED PART----------------------------

        //ALGORITHM - @STUDENT: ADD YOUR CODE HERE:
        for (String str : list) {
            String[] arr = str.split("\\s+");
            
            if(arr[0].equals("AddSong")){
                String name = arr[1];
                int duration = Integer.parseInt(arr[2]);
                String composer = arr[3];
                
//                Song song = new Song(name, duration, composer);
//                listSong.add(song);
                songlist.inputData(name, duration, composer);
                result += songlist.info + "\n";
            }
            else if(arr[0].equals("MaxSong")){
                Song maxSong = songlist.getSongMaxDuration();
                if(maxSong != null)
                    result += songlist.info + "\n";
            }
            else if(arr[0].equals("Top3")){
                songlist.getTop3Ranking();
                result += songlist.info + "\n";
            }
            else if(arr[0].equals("Clear")){
                songlist.removeSongMaxDuration();
                result += songlist.info + "\n";
            }
            else if(arr[0].equals("ClearAll")){
                songlist.removeAllData();
                result += songlist.info + "\n";
            }
        }

        System.out.println(result);
	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART-------------------------- 
    }
    
    /**
     * Write result into output file
     */
    public void printResult(){
	    try{
            FileWriter fw = new FileWriter(fo);
	//--END FIXED PART----------------------------
                
        	//OUTPUT - @STUDENT: ADD YOUR CODE FOR OUTPUT HERE:
            fw.write(result);



	//--FIXED PART - DO NOT EDIT ANY THINGS HERE--
	//--START FIXED PART-------------------------- 
            fw.flush();
            fw.close();
        }catch (IOException ex){
            System.out.println("Output Exception # " + ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Q1 q = new Q1();
        q.setFile(args);
        q.read();
        q.solve();
        q.printResult();
    }
	//--END FIXED PART----------------------------    
}
