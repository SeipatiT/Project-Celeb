import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WikiExample {
    public WikiExample() throws MalformedURLException {
        String subject = "Prince";
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&format=json&exsentences=1&exintro=&explaintext=&exsectionformat=plain&titles=" + subject.replace(" ", "%20"));
        String text = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
            String line = null;
            while (null != (line = br.readLine())) {
                line = line.trim();
                if (true) {
                    text += line;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("text = " + text);
        JSONObject json = new JSONObject(text);
        JSONObject query = json.getJSONObject("query");
        JSONObject pages = query.getJSONObject("pages");
        for(String key: pages.keySet()) {
            System.out.println("key = " + key);
            JSONObject page = pages.getJSONObject(key);
            String extract = page.getString("extract");
            System.out.println("extract = " + extract);
        }

    }

    public static void main(String[] args) throws MalformedURLException {
        WikiExample wikiExample = new WikiExample();
        System.out.println(wikiExample);



    }
}
