package net.kresina;

import net.kresina.util.enums.CryptorName;
import net.kresina.util.interfaces.Cryptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Controller
public class WebController {

    public Map<String, Cryptor> stringCryptorHashMap = new LinkedHashMap<String, Cryptor>();
    public List<String> cryptorNames = new ArrayList<String>();

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String test(Model model,
                       @RequestParam(name = "message") String message,
                       @RequestParam(name = "coder") String coder,
                       @RequestParam(name = "submitButton") String action
    ) {
        System.out.println(message);
        String encrypted = "";
        if (coder != null) {
            Cryptor cryptor = stringCryptorHashMap.get(coder);
            if ("Decrypt".equals(action)) {
                encrypted = cryptor.decrypt(message);
            } else {
                encrypted = cryptor.encrypt(message);
            }
        }
        model.addAttribute("cryptorNamesList", cryptorNames);
        model.addAttribute("encrypted", encrypted);
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping()
    public String defaultMethod(Model model){
        model.addAttribute("cryptorNamesList", cryptorNames);
        return "index";
    }

    @PostConstruct
    public void init(){
        for(CryptorName n : CryptorName.values()){
            try {
                Class<?> aClass = Class.forName("net.kresina.util.implementations." + n.getText());
                Cryptor c = (Cryptor) aClass.newInstance();
                stringCryptorHashMap.put(n.getText(), c);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        cryptorNames = new ArrayList<String>(stringCryptorHashMap.keySet());
    }
}
