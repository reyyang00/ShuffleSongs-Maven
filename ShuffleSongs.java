package sjsu.yang.cs146.project1a;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

/** the solution implementation of a shuffle songs.
 *  base on an arrayimplementation.
 * @author Rui Yang
 * @version CS146 project1a
 */

public class ShuffleSongs {

    /** a method to read a file in and put
     *  strings in an array.
     */
    public String[] readFile()throws Exception{
        String[] arrayFile = new String[459];
        FileReader fileReader = new FileReader("src/resources/Playlist.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        String line="";
        int count=0;
        while((line=reader.readLine())!=null){
           arrayFile[count] = line;
           count++;
        }
        return arrayFile;
    }


    /** to shuffle the input string array.
     * @param theArray the input array.
     */
    public String[] shuffleSongs(String[] theArray){
        String temp= "";
        Random r = new Random();
        r.setSeed(20);

        for(int i =theArray.length-1;i>0;i--){
            int j = r.nextInt(i);
            temp = theArray[j];
            theArray[j] = theArray[i];
            theArray[i]=temp;
        }
        return theArray;
    }

}
