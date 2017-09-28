import net.kresina.WebController;
import net.kresina.util.implementations.MorseCryptorImpl;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void testMorseCryptorImpl(){
        MorseCryptorImpl morseCryptor = new MorseCryptorImpl();
        String input = "abcdefghchijklmnopqrstuvwxyz 1234567890 097512430ýčíšýěáč";
        String encrypted = morseCryptor.encrypt(input);
        Assert.assertEquals(input, morseCryptor.decrypt(encrypted));
    }

    @Test
    public void testWebControllerInit(){
        WebController webController = new WebController();
        webController.init();
        Assert.assertTrue(webController.stringCryptorHashMap.size() == 2);
    }

}
