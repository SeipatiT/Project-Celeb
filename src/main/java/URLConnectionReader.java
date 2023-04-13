

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        URL url = new URL(
                "https://en.wikipedia.org/");
        Scanner scanner = new Scanner(url.openStream());

        StringBuffer stringBuffer = new StringBuffer();

        while (scanner.hasNext()){
            stringBuffer.append(scanner.next());
        }

        String result = stringBuffer.toString();
        System.out.println(result);

        result = result.replaceAll("<[^>]*>", "");
        System.out.println("Contents of the web page: "+result);


    }
}






//        URL yahoo = new URL("https://www.mediawiki.org/w/api.php?action=query&list=search&srsearch=Nelson%20Mandela&utf8=&format=json");
//        URLConnection yc = yahoo.openConnection();
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(
//                        yc.getInputStream()));
//        String inputLine;
//
//        while ((inputLine = in.readLine()) != null)
//            System.out.println(inputLine);
//        in.close();
//
//        ScriptEngine jsEngine = new ScriptEngineManager().getEngineByName("Nashorn");
//
//        Bindings bind = jsEngine.getBindings(ScriptContext.ENGINE_SCOPE);
//
//        jsEngine.eval(new FileReader("src/main/resources/templates/js/opensearch.js"));
//    }