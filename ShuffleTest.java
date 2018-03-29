package sjsu.yang.cs146.project1a;
import java.io.BufferedReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.FileReader;

import java.io.PrintWriter;


/** A test class of Shuffle calss.
 * @author Rui Yang
 * @version CS146 project1a
 */
public class ShuffleTest {
    ShuffleSongs shuffleSongs;  //attach the Shufflesong class.
    String[] arg;  // a variable reference to Shuffled String[].
    String[] out;   // a variable reference to the actual ouput String[].
    PrintWriter playListOut; //a print write obejct to write into file.
    String expectedLine;    //an reference to the expected file.


    /** a construct to set all variable will
     *  be using in this test class.
     */
    @Before
    public void setUp() throws Exception {
        shuffleSongs = new ShuffleSongs();
        playListOut = new PrintWriter("src/resources/PlaylistOut.txt");

    }

    /** a test method to test the shuffle String[] with
     *  the give Target.txt file
     */
    @Test
    public void testArray() throws Exception {

        arg = shuffleSongs.readFile();
        String[] ab = shuffleSongs.shuffleSongs(arg);
        for (int i = 0; i < ab.length; i++) {
            playListOut.println(ab[i]);
        }
        playListOut.close();

        BufferedReader In = new BufferedReader(new FileReader("src/resources/PlaylistOut.txt"));
        BufferedReader Out = new BufferedReader(new FileReader("src/resources/Target.txt"));
        while ((expectedLine = Out.readLine()) != null) {

            String actualLine = In.readLine();
            Assert.assertEquals(expectedLine, actualLine);
        }
    }
}
